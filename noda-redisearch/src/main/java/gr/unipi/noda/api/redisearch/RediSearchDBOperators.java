package gr.unipi.noda.api.redisearch;

import gr.unipi.noda.api.core.nosqldb.Keywords;
import gr.unipi.noda.api.core.nosqldb.NoSqlDbOperators;
import gr.unipi.noda.api.core.nosqldb.StringPool;
import gr.unipi.noda.api.core.operators.aggregateOperators.AggregateOperator;
import gr.unipi.noda.api.core.operators.filterOperators.FilterOperator;
import gr.unipi.noda.api.core.operators.sortOperators.SortOperator;
import gr.unipi.noda.api.redisearch.filterOperator.RedisFilterOperator;
import gr.unipi.noda.api.redisearch.geographicalOperator.OperatorNearestNeighbors;
import gr.unipi.noda.api.redisearch.geographicalOperator.RediSearchGeographicalOperatorFactory;
import io.redisearch.AggregationResult;
import io.redisearch.aggregation.AggregationBuilder;
import io.redisearch.aggregation.SortedField;
import io.redisearch.aggregation.reducers.Reducer;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RediSearchDBOperators implements NoSqlDbOperators {
    private final RediSearchConnectionManager rediSearchConnectionManager = RediSearchConnectionManager.getInstance();
    private final RediSearchDBConnector connector;
    private AggregationBuilder aggregationBuilder;

    private RediSearchDBOperators(RediSearchDBConnector connector) {
        this.connector = connector;
        aggregationBuilder = new AggregationBuilder();
    }

    static RediSearchDBOperators newRedisDBOperators(RediSearchDBConnector connector, String indexName) {
        connector.setIndexName(indexName);
        return new RediSearchDBOperators(connector);
    }

    @Override
    public NoSqlDbOperators filter(FilterOperator filterOperator, FilterOperator... filterOperators) {
        if (RediSearchGeographicalOperatorFactory.isOperatorNearestNeighbor(filterOperator)) {
            aggregationBuilder.filter(filterOperator.getOperatorExpression().toString()).limit(((OperatorNearestNeighbors) filterOperator).getNeighborsCount());
        }
        if (aggregationBuilder.getArgs().size() == 1) {
            String s = filterOperator.getOperatorExpression().toString();
            String s1 = Arrays.stream(filterOperators).map(f -> f.getOperatorExpression().toString()).collect(Collectors.joining());
            aggregationBuilder = new AggregationBuilder(s.concat(s1));
        } else {
            String s = ((RedisFilterOperator) filterOperator).getPostOperatorExpression().toString();
            String s1 = Arrays.stream(filterOperators).map(f -> ((RedisFilterOperator) f).getPostOperatorExpression().toString()).collect(Collectors.joining());
            aggregationBuilder.filter(s.concat(s1));
        }
        return this;
    }

    public NoSqlDbOperators groupBy(String fieldName, AggregateOperator... aggregateOperator) {
        aggregationBuilder.groupBy(StringPool.AT.concat(fieldName), Arrays.stream(aggregateOperator).map(AggregateOperator::getOperatorExpression).map(Reducer.class::cast).toArray(Reducer[]::new));
        return this;
    }

    @Override
    public NoSqlDbOperators distinct(String fieldName) {
        return groupBy(fieldName);
    }

    @Override
    public void printScreen() {
        AggregationResult aggregate = rediSearchConnectionManager.getConnection(connector).aggregate(aggregationBuilder);
        List<Map<String, Object>> results = aggregate.getResults();
        int index = 0;
        for (Map<String, Object> t : results) {
            int finalIndex = index;
            t.keySet().forEach(k -> System.out.println(k + StringPool.COLON + aggregate.getRow(finalIndex).getString(k)));
            index++;
        }
        System.out.println(aggregate.getResults());
    }

    @Override
    public Optional<Double> max(String fieldName) {
        aggregationBuilder.groupBy(StringPool.AT_AND_STAR, (Reducer) AggregateOperator.aggregateOperator.newOperatorMax(fieldName).getOperatorExpression());
        AggregationResult aggregate = rediSearchConnectionManager.getConnection(connector).aggregate(aggregationBuilder);
        return Optional.of(aggregate.getRow(0).getDouble(Keywords.MAX.toString().concat(fieldName)));
    }

    @Override
    public Optional<Double> min(String fieldName) {
        aggregationBuilder.groupBy(StringPool.AT_AND_STAR, (Reducer) AggregateOperator.aggregateOperator.newOperatorMin(fieldName).getOperatorExpression());
        AggregationResult aggregate = rediSearchConnectionManager.getConnection(connector).aggregate(aggregationBuilder);
        return Optional.of(aggregate.getRow(0).getDouble(Keywords.MIN.toString().concat(fieldName)));
    }

    @Override
    public Optional<Double> sum(String fieldName) {
        aggregationBuilder.groupBy(StringPool.AT_AND_STAR, (Reducer) AggregateOperator.aggregateOperator.newOperatorSum(fieldName).getOperatorExpression());
        AggregationResult aggregate = rediSearchConnectionManager.getConnection(connector).aggregate(aggregationBuilder);
        return Optional.of(aggregate.getRow(0).getDouble(Keywords.SUM.toString().concat(fieldName)));
    }

    @Override
    public Optional<Double> avg(String fieldName) {
        aggregationBuilder.groupBy(StringPool.AT_AND_STAR, (Reducer) AggregateOperator.aggregateOperator.newOperatorAvg(fieldName).getOperatorExpression());
        AggregationResult aggregate = rediSearchConnectionManager.getConnection(connector).aggregate(aggregationBuilder);
        return Optional.of(aggregate.getRow(0).getDouble(Keywords.AVG.toString().concat(fieldName)));
    }

    @Override
    public int count() {
        aggregationBuilder.groupBy(StringPool.AT_AND_STAR, (Reducer) AggregateOperator.aggregateOperator.newOperatorCount().getOperatorExpression());
        AggregationResult aggregate = rediSearchConnectionManager.getConnection(connector).aggregate(aggregationBuilder);
        return (int) aggregate.getRow(0).getDouble(Keywords.COUNT.toString());
    }

    @Override
    public NoSqlDbOperators sort(SortOperator sortOperator, SortOperator... sortingOperators) {
        Stream<SortOperator> stream = Stream.concat(Stream.of(sortOperator), Stream.of(sortingOperators));
        aggregationBuilder.sortBy(stream.map(SortOperator::getOperatorExpression).map(SortedField.class::cast).toArray(SortedField[]::new));
        return this;
    }

    @Override
    public NoSqlDbOperators limit(int limit) {
        aggregationBuilder.limit(limit);
        return this;
    }

    @Override
    public NoSqlDbOperators project(String fieldName, String... fieldNames) {
        Stream<String> stream = Stream.concat(Stream.of(fieldName), Stream.of(fieldNames));
        aggregationBuilder.load(stream.toArray(String[]::new));
        return this;
    }

    @Override
    public Dataset<Row> toDataframe() {
        throw new UnsupportedOperationException("ToDataframe primitive is not supported");
    }
}
