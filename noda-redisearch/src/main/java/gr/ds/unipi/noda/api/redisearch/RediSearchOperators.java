package gr.ds.unipi.noda.api.redisearch;

import gr.ds.unipi.noda.api.core.constants.AggregationKeywords;
import gr.ds.unipi.noda.api.core.constants.StringPool;
import gr.ds.unipi.noda.api.core.nosqldb.NoSqlDbConnector;
import gr.ds.unipi.noda.api.core.nosqldb.NoSqlDbOperators;
import gr.ds.unipi.noda.api.core.operators.aggregateOperators.AggregateOperator;
import gr.ds.unipi.noda.api.core.operators.filterOperators.FilterOperator;
import gr.ds.unipi.noda.api.core.operators.sortOperators.SortOperator;
import gr.ds.unipi.noda.api.redisearch.filterOperators.RediSearchPostFilterOperator;
import gr.ds.unipi.noda.api.redisearch.filterOperators.geoperators.geoTextualOperators.geoTextualApproximateOperators.OperatorTopKInGeoTextualCircle;
import gr.ds.unipi.noda.api.redisearch.filterOperators.geoperators.geographicalOperators.OperatorGeoNearestNeighbors;
import gr.ds.unipi.noda.api.redisearch.filterOperators.geoperators.geographicalOperators.RediSearchGeographicalOperator;
import gr.ds.unipi.noda.api.redisearch.filterOperators.geoperators.geographicalOperators.RediSearchGeographicalOperatorFactory;
import io.redisearch.AggregationResult;
import io.redisearch.aggregation.SortedField;
import io.redisearch.aggregation.reducers.Reducer;
import io.redisearch.querybuilder.Node;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;

import java.util.Arrays;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public final class RediSearchOperators extends NoSqlDbOperators {
    private RediSearchQueryHelper queryHelper;

    private RediSearchOperators(NoSqlDbConnector connector, String indexName, SparkSession sparkSession) {
        super(connector, indexName, sparkSession);
    }

    static RediSearchOperators newRedisOperators(NoSqlDbConnector connector, String indexName, SparkSession sparkSession) {
        return new RediSearchOperators(connector, indexName, sparkSession);
    }

    RediSearchQueryHelper queryHelper() {
        if (queryHelper == null) {
            queryHelper = new RediSearchQueryHelper(getDataCollection(), RediSearchConnectionManager.getInstance().getConnection(getNoSqlDbConnector()));
        }
        return queryHelper;
    }

    @Override
    public NoSqlDbOperators filter(FilterOperator filterOperator, FilterOperator... filterOperators) {
        if(func.apply(filterOperator, filterOperators).anyMatch(RediSearchGeographicalOperatorFactory.isGeo) && queryHelper().isAggregate())
            throw new UnsupportedOperationException("RediSearchGeographicalOperator is not supported as post filter query.");
        else if (RediSearchGeographicalOperatorFactory.isOperatorGeoBox(filterOperator) && filterOperators.length == 0) {
            queryHelper().setzRangeInfo(((RediSearchGeographicalOperator) filterOperator)
                    .getZRangeInfo().apply(queryHelper().getJedisResource(), getDataCollection()));
        } else if (RediSearchGeographicalOperatorFactory.isOperatorGeoBox(filterOperator) && filterOperators.length > 0) {
            throw new IllegalArgumentException("OperatorInGeoRectangle cannot be combined with other FilterOperators.");
        } else {
            applyQuery(filterOperator, filterOperators);
        }
        return this;
    }

    @Override
    public NoSqlDbOperators groupBy(String fieldName, String... fieldNames) {
        queryHelper().applyGroupBy(StringPool.AT.concat(fieldName), Arrays.stream(fieldNames).map(StringPool.AT::concat).toArray(String[]::new));
        return this;
    }

    @Override
    public NoSqlDbOperators aggregate(AggregateOperator aggregateOperator, AggregateOperator... aggregateOperators) {
        queryHelper().applyAggregate((Reducer) aggregateOperator.getOperatorExpression(),
                Arrays.stream(aggregateOperators).map(AggregateOperator::getOperatorExpression).map(Reducer.class::cast).toArray(Reducer[]::new));
        return this;
    }

    private void applyQuery(FilterOperator filterOperator, FilterOperator[] filterOperators) {
        if (queryHelper().isAggregate()) {
            queryHelper().applyPostQuery(func.apply(filterOperator, filterOperators).map(f -> ((RediSearchPostFilterOperator) f).getPostOperatorExpression().toString()).collect(Collectors.joining()));
        } else {
            func.apply(filterOperator, filterOperators).forEach(f -> queryHelper().applyPreQuery((Node) f.getOperatorExpression()));
        }
        func.apply(filterOperator, filterOperators).filter(RediSearchGeographicalOperatorFactory::isOperatorGeoNearestNeighbor).findAny()
                .ifPresent(filterOperator1 -> queryHelper().applyResultLimit(((OperatorGeoNearestNeighbors) filterOperator1).getNeighborsCount()));

        func.apply(filterOperator, filterOperators).filter(filterOperator1 -> filterOperator1 instanceof OperatorTopKInGeoTextualCircle).findAny()
                .ifPresent(filterOperator2 -> queryHelper().applyResultLimit(((OperatorTopKInGeoTextualCircle) filterOperator2).getTopK()));
    }

    @Override
    public NoSqlDbOperators distinct(String fieldName) {
        return groupBy(fieldName);
    }

    @Override
    public void printScreen() {
        queryHelper().printResults();
    }

    @Override
    public Optional<Double> max(String fieldName) {
        queryHelper().applyAggregate((Reducer) AggregateOperator.aggregateOperator.newOperatorMax(fieldName).getOperatorExpression());
        AggregationResult aggregate = queryHelper().executeAggregation();
        return Optional.of(aggregate.getRow(0).getDouble(AggregationKeywords.MAX.toString().concat(fieldName)));
    }

    @Override
    public Optional<Double> min(String fieldName) {
        queryHelper().applyAggregate((Reducer) AggregateOperator.aggregateOperator.newOperatorMin(fieldName).getOperatorExpression());
        AggregationResult aggregate = queryHelper().executeAggregation();
        return Optional.of(aggregate.getRow(0).getDouble(AggregationKeywords.MIN.toString().concat(fieldName)));
    }

    @Override
    public Optional<Double> sum(String fieldName) {
        queryHelper().applyAggregate((Reducer) AggregateOperator.aggregateOperator.newOperatorSum(fieldName).getOperatorExpression());
        AggregationResult aggregate = queryHelper().executeAggregation();
        return Optional.of(aggregate.getRow(0).getDouble(AggregationKeywords.SUM.toString().concat(fieldName)));
    }

    @Override
    public Optional<Double> avg(String fieldName) {
        queryHelper().applyAggregate((Reducer) AggregateOperator.aggregateOperator.newOperatorAvg(fieldName).getOperatorExpression());
        AggregationResult aggregate = queryHelper().executeAggregation();
        return Optional.of(aggregate.getRow(0).getDouble(AggregationKeywords.AVG.toString().concat(fieldName)));
    }

    @Override
    public int count() {
        return queryHelper().totalResults();
    }

    @Override
    public NoSqlDbOperators sort(SortOperator sortOperator, SortOperator... sortingOperators) {
        SortedField[] sortedFields = Stream.concat(Stream.of(sortOperator), Arrays.stream(sortingOperators))
                .map(SortOperator::getOperatorExpression).map(SortedField.class::cast).toArray(SortedField[]::new);
        queryHelper().applySortBy(sortedFields);
        return this;
    }

    @Override
    public NoSqlDbOperators limit(int limit) {
        queryHelper().applyResultLimit(limit);
        return this;
    }

    @Override
    public NoSqlDbOperators project(String fieldName, String... fieldNames) {
        String[] fields = Stream.concat(Stream.of(fieldName), Arrays.stream(fieldNames)).toArray(String[]::new);
        queryHelper().applyReturnFields(fields);
        return this;
    }

    @Override
    public Dataset<Row> toDataframe() {
        throw new UnsupportedOperationException("ToDataframe primitive is not supported");
    }

    private final BiFunction<FilterOperator, FilterOperator[], Stream<FilterOperator>> func = (filterOperator, filterOperators) -> Stream.concat(Stream.of(filterOperator), Arrays.stream(filterOperators));
}