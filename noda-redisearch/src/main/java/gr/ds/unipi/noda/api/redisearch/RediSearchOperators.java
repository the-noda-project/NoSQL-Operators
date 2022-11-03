package gr.ds.unipi.noda.api.redisearch;

import gr.ds.unipi.noda.api.core.constants.AggregationKeywords;
import gr.ds.unipi.noda.api.core.constants.StringPool;
import gr.ds.unipi.noda.api.core.nosqldb.NoSqlDbConnector;
import gr.ds.unipi.noda.api.core.nosqldb.NoSqlDbOperators;
import gr.ds.unipi.noda.api.core.operators.aggregateOperators.AggregateOperator;
import gr.ds.unipi.noda.api.core.operators.filterOperators.FilterOperator;
import gr.ds.unipi.noda.api.core.operators.joinOperators.JoinOperator;
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
    private final RediSearchQueryHelper queryHelper;

    private RediSearchOperators(NoSqlDbConnector connector, String indexName, SparkSession sparkSession) {
        super(connector, indexName, sparkSession);
        this.queryHelper = new RediSearchQueryHelper(getDataCollection(), RediSearchConnectionManager.getInstance().getConnection(getNoSqlDbConnector()));
    }

    private RediSearchOperators(RediSearchOperators operators, RediSearchQueryHelper queryHelper) {
        super(operators.getNoSqlDbConnector(), operators.getDataCollection(), operators.getSparkSession());
        this.queryHelper = queryHelper;
    }

    static RediSearchOperators newRedisOperators(NoSqlDbConnector connector, String indexName, SparkSession sparkSession) {
        return new RediSearchOperators(connector, indexName, sparkSession);
    }

    @Override
    public NoSqlDbOperators filter(FilterOperator filterOperator, FilterOperator... filterOperators) {
        RediSearchQueryHelper helper = queryHelper.copyOf();
        if(func.apply(filterOperator, filterOperators).anyMatch(RediSearchGeographicalOperatorFactory.isGeo) && helper.isAggregate())
            throw new UnsupportedOperationException("RediSearchGeographicalOperator is not supported as post filter query.");
        else if (RediSearchGeographicalOperatorFactory.isOperatorGeoBox(filterOperator) && filterOperators.length == 0) {
            helper.setzRangeInfo(((RediSearchGeographicalOperator) filterOperator)
                    .getZRangeInfo().apply(helper.getJedisResource(), getDataCollection()));
        } else if (RediSearchGeographicalOperatorFactory.isOperatorGeoBox(filterOperator) && filterOperators.length > 0) {
            throw new IllegalArgumentException("OperatorInGeoRectangle cannot be combined with other FilterOperators.");
        } else {
            applyQuery(filterOperator, filterOperators, helper);
        }
        return new RediSearchOperators(this, helper);
    }

    @Override
    public NoSqlDbOperators groupBy(String fieldName, String... fieldNames) {
        RediSearchQueryHelper helper = queryHelper.copyOf();
        helper.applyGroupBy(StringPool.AT.concat(fieldName), Arrays.stream(fieldNames).map(StringPool.AT::concat).toArray(String[]::new));
        return new RediSearchOperators(this, helper);
    }

    @Override
    public NoSqlDbOperators aggregate(AggregateOperator aggregateOperator, AggregateOperator... aggregateOperators) {
        RediSearchQueryHelper helper = queryHelper.copyOf();
        helper.applyAggregate((Reducer) aggregateOperator.getOperatorExpression(),
                Arrays.stream(aggregateOperators).map(AggregateOperator::getOperatorExpression).map(Reducer.class::cast).toArray(Reducer[]::new));
        return new RediSearchOperators(this, helper);
    }

    private void applyQuery(FilterOperator filterOperator, FilterOperator[] filterOperators, RediSearchQueryHelper queryHelper) {
        if (queryHelper.isAggregate()) {
            queryHelper.applyPostQuery(func.apply(filterOperator, filterOperators).map(f -> ((RediSearchPostFilterOperator) f).getPostOperatorExpression().toString()).collect(Collectors.joining()));
        } else {
            func.apply(filterOperator, filterOperators).forEach(f -> queryHelper.applyPreQuery((Node) f.getOperatorExpression()));
        }
        func.apply(filterOperator, filterOperators).filter(RediSearchGeographicalOperatorFactory::isOperatorGeoNearestNeighbor).findAny()
                .ifPresent(filterOperator1 -> queryHelper.applyResultLimit(((OperatorGeoNearestNeighbors) filterOperator1).getNeighborsCount()));

        func.apply(filterOperator, filterOperators).filter(filterOperator1 -> filterOperator1 instanceof OperatorTopKInGeoTextualCircle).findAny()
                .ifPresent(filterOperator2 -> queryHelper.applyResultLimit(((OperatorTopKInGeoTextualCircle) filterOperator2).getTopK()));
    }

    @Override
    public NoSqlDbOperators distinct(String fieldName) {
        return groupBy(fieldName);
    }

    @Override
    public void printScreen() {
        queryHelper.printResults();
    }

    @Override
    public Optional<Double> max(String fieldName) {
        queryHelper.applyAggregate((Reducer) AggregateOperator.aggregateOperator.newOperatorMax(fieldName).getOperatorExpression());
        AggregationResult aggregate = queryHelper.executeAggregation();
        return Optional.of(aggregate.getRow(0).getDouble(AggregationKeywords.MAX.toString().concat(fieldName)));
    }

    @Override
    public Optional<Double> min(String fieldName) {
        queryHelper.applyAggregate((Reducer) AggregateOperator.aggregateOperator.newOperatorMin(fieldName).getOperatorExpression());
        AggregationResult aggregate = queryHelper.executeAggregation();
        return Optional.of(aggregate.getRow(0).getDouble(AggregationKeywords.MIN.toString().concat(fieldName)));
    }

    @Override
    public Optional<Double> sum(String fieldName) {
        queryHelper.applyAggregate((Reducer) AggregateOperator.aggregateOperator.newOperatorSum(fieldName).getOperatorExpression());
        AggregationResult aggregate = queryHelper.executeAggregation();
        return Optional.of(aggregate.getRow(0).getDouble(AggregationKeywords.SUM.toString().concat(fieldName)));
    }

    @Override
    public Optional<Double> avg(String fieldName) {
        queryHelper.applyAggregate((Reducer) AggregateOperator.aggregateOperator.newOperatorAvg(fieldName).getOperatorExpression());
        AggregationResult aggregate = queryHelper.executeAggregation();
        return Optional.of(aggregate.getRow(0).getDouble(AggregationKeywords.AVG.toString().concat(fieldName)));
    }

    @Override
    public int count() {
        return queryHelper.totalResults();
    }

    @Override
    public NoSqlDbOperators sort(SortOperator sortOperator, SortOperator... sortingOperators) {
        RediSearchQueryHelper helper = queryHelper.copyOf();
        SortedField[] sortedFields = Stream.concat(Stream.of(sortOperator), Arrays.stream(sortingOperators))
                .map(SortOperator::getOperatorExpression).map(SortedField.class::cast).toArray(SortedField[]::new);
        helper.applySortBy(sortedFields);
        return new RediSearchOperators(this, helper);
    }

    @Override
    public NoSqlDbOperators limit(int limit) {
        RediSearchQueryHelper helper = queryHelper.copyOf();
        helper.applyResultLimit(limit);
        return new RediSearchOperators(this, helper);
    }

    @Override
    public NoSqlDbOperators project(String fieldName, String... fieldNames) {
        RediSearchQueryHelper helper = queryHelper.copyOf();
        String[] fields = Stream.concat(Stream.of(fieldName), Arrays.stream(fieldNames)).toArray(String[]::new);
        helper.applyReturnFields(fields);
        return new RediSearchOperators(this, helper);
    }

    @Override
    public Dataset<Row> toDataframe() {
        throw new UnsupportedOperationException("ToDataframe primitive is not supported");
    }

    @Override
    public NoSqlDbOperators join(NoSqlDbOperators noSqlDbOperators, JoinOperator jo) {
        return null;
    }

    private final BiFunction<FilterOperator, FilterOperator[], Stream<FilterOperator>> func = (filterOperator, filterOperators) -> Stream.concat(Stream.of(filterOperator), Arrays.stream(filterOperators));
}