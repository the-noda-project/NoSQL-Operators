package gr.ds.unipi.noda.api.redisearch;

import gr.ds.unipi.noda.api.core.constants.AggregationKeywords;
import gr.ds.unipi.noda.api.core.constants.StringPool;
import gr.ds.unipi.noda.api.core.nosqldb.NoSqlDbOperators;
import gr.ds.unipi.noda.api.core.operators.aggregateOperators.AggregateOperator;
import gr.ds.unipi.noda.api.core.operators.filterOperators.FilterOperator;
import gr.ds.unipi.noda.api.core.operators.sortOperators.SortOperator;
import gr.ds.unipi.noda.api.redisearch.filterOperator.RediSearchPostFilterOperator;
import gr.ds.unipi.noda.api.redisearch.filterOperator.geographicalOperator.geoSpatialOperators.OperatorGeoNearestNeighbors;
import gr.ds.unipi.noda.api.redisearch.filterOperator.geographicalOperator.geoSpatialOperators.RediSearchGeoSpatialOperatorFactory;
import gr.ds.unipi.noda.api.redisearch.filterOperator.geographicalOperator.geoSpatialOperators.RediSearchGeoSpatialOperator;
import gr.ds.unipi.noda.api.redisearch.filterOperator.geographicalOperator.geoSpatialOperators.ZRangeInfo;
import io.redisearch.AggregationResult;
import io.redisearch.aggregation.AggregationBuilder;
import io.redisearch.aggregation.SortedField;
import io.redisearch.aggregation.reducers.Reducer;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import redis.clients.jedis.GeoCoordinate;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RediSearchOperators implements NoSqlDbOperators {
    private final RediSearchConnectionManager rediSearchConnectionManager = RediSearchConnectionManager.getInstance();
    private final RediSearchConnector connector;
    private AggregationBuilder aggregationBuilder;
    private ZRangeInfo zRangeInfo;

    private RediSearchOperators(RediSearchConnector connector) {
        this.connector = connector;
        aggregationBuilder = new AggregationBuilder();
    }

    static RediSearchOperators newRedisOperators(RediSearchConnector connector, String indexName) {
        connector.setIndexName(indexName);
        return new RediSearchOperators(connector);
    }

    @Override
    public NoSqlDbOperators filter(FilterOperator filterOperator, FilterOperator... filterOperators) {
        if (RediSearchGeoSpatialOperatorFactory.isOperatorGeoNearestNeighbor(filterOperator)) {
            if (aggregationBuilder.getArgs().size() == 1) {
                aggregationBuilder = new AggregationBuilder(filterOperator.getOperatorExpression().toString()).limit(((OperatorGeoNearestNeighbors) filterOperator).getNeighborsCount());
            } else {
                throw new UnsupportedOperationException("RedisGeographicalOperator is not supported as post filter query.");
            }
        } else if (RediSearchGeoSpatialOperatorFactory.isOperatorGeoBox(filterOperator)) {
            zRangeInfo = ((RediSearchGeoSpatialOperator)filterOperator)
                    .getZRangeInfo().apply(connector.getJedisConn(), connector.getIndexName());
        }
        if (aggregationBuilder.getArgs().size() == 1) {
            String s = filterOperator.getOperatorExpression().toString();
            String s1 = Arrays.stream(filterOperators).map(f -> f.getOperatorExpression().toString()).collect(Collectors.joining());
            aggregationBuilder = new AggregationBuilder(s.concat(s1));
        } else {
            String s = ((RediSearchPostFilterOperator) filterOperator).getPostOperatorExpression().toString();
            String s1 = Arrays.stream(filterOperators).map(f -> ((RediSearchPostFilterOperator) f).getPostOperatorExpression().toString()).collect(Collectors.joining());
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
        if (Objects.nonNull(zRangeInfo)) {
            Set<String> rectangleSearchMembers = connector.getJedisConn().zrangeByScore(zRangeInfo.getKey(), zRangeInfo.getLowerBoundScore(), zRangeInfo.getUpperBoundScore());
            List<GeoCoordinate> geopos = connector.getJedisConn().geopos(zRangeInfo.getKey(), rectangleSearchMembers.toArray(StringPool.EMPTY_ARRAY));
            geopos.forEach(pos -> System.out.println(pos.toString()));
        } else {
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
    }

    @Override
    public Optional<Double> max(String fieldName) {
        aggregationBuilder.groupBy(StringPool.AT_AND_STAR, (Reducer) AggregateOperator.aggregateOperator.newOperatorMax(fieldName).getOperatorExpression());
        AggregationResult aggregate = rediSearchConnectionManager.getConnection(connector).aggregate(aggregationBuilder);
        return Optional.of(aggregate.getRow(0).getDouble(AggregationKeywords.MAX.toString().concat(fieldName)));
    }

    @Override
    public Optional<Double> min(String fieldName) {
        aggregationBuilder.groupBy(StringPool.AT_AND_STAR, (Reducer) AggregateOperator.aggregateOperator.newOperatorMin(fieldName).getOperatorExpression());
        AggregationResult aggregate = rediSearchConnectionManager.getConnection(connector).aggregate(aggregationBuilder);
        return Optional.of(aggregate.getRow(0).getDouble(AggregationKeywords.MIN.toString().concat(fieldName)));
    }

    @Override
    public Optional<Double> sum(String fieldName) {
        aggregationBuilder.groupBy(StringPool.AT_AND_STAR, (Reducer) AggregateOperator.aggregateOperator.newOperatorSum(fieldName).getOperatorExpression());
        AggregationResult aggregate = rediSearchConnectionManager.getConnection(connector).aggregate(aggregationBuilder);
        return Optional.of(aggregate.getRow(0).getDouble(AggregationKeywords.SUM.toString().concat(fieldName)));
    }

    @Override
    public Optional<Double> avg(String fieldName) {
        aggregationBuilder.groupBy(StringPool.AT_AND_STAR, (Reducer) AggregateOperator.aggregateOperator.newOperatorAvg(fieldName).getOperatorExpression());
        AggregationResult aggregate = rediSearchConnectionManager.getConnection(connector).aggregate(aggregationBuilder);
        return Optional.of(aggregate.getRow(0).getDouble(AggregationKeywords.AVG.toString().concat(fieldName)));
    }

    @Override
    public int count() {
        aggregationBuilder.groupBy(StringPool.AT_AND_STAR, (Reducer) AggregateOperator.aggregateOperator.newOperatorCount().getOperatorExpression());
        AggregationResult aggregate = rediSearchConnectionManager.getConnection(connector).aggregate(aggregationBuilder);
        return (int) aggregate.getRow(0).getDouble(AggregationKeywords.COUNT.toString());
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
