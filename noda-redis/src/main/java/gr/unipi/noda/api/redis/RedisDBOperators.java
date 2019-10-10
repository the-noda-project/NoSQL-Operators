package gr.unipi.noda.api.redis;

import gr.unipi.noda.api.core.nosqldb.NoSqlDbOperators;
import gr.unipi.noda.api.core.operators.aggregateOperators.AggregateOperator;
import gr.unipi.noda.api.core.operators.filterOperators.FilterOperator;
import gr.unipi.noda.api.core.operators.sortOperators.SortOperator;
import io.redisearch.Query;
import io.redisearch.aggregation.AggregationBuilder;
import io.redisearch.aggregation.SortedField;
import io.redisearch.aggregation.reducers.Reducer;
import io.redisearch.aggregation.reducers.Reducers;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public final class RedisDBOperators implements NoSqlDbOperators {
    private final RedisConnectionManager redisConnectionManager = RedisConnectionManager.getInstance();
    private final RedisDBConnector connector;
    private AggregationBuilder aggregationBuilder;

    public RedisDBOperators(RedisDBConnector connector) {
        this.connector = connector;
        aggregationBuilder = new AggregationBuilder();
    }

    public static RedisDBOperators newRedisDBOperators(RedisDBConnector connector, String indexName) {
        connector.setIndexName(indexName);
        return new RedisDBOperators(connector);
    }

    @Override
    public NoSqlDbOperators filter(FilterOperator filterOperator, FilterOperator... filterOperators) {
        Query q = new Query("hello world")
                .addFilter(new Query.NumericFilter("price", 0, 1000))
                .limit(0, 5);
        AggregationBuilder r = new AggregationBuilder("hello")
                .apply("@price/1000", "k")
                .groupBy("@state", Reducers.avg("@k").as("avgprice"))
                .filter("@avgprice>=2")
                .sortBy(10, SortedField.asc("@state"));
        return this;
    }

    public NoSqlDbOperators groupBy(String fieldName, AggregateOperator... aggregateOperator) {
        List<Reducer> reducers = new ArrayList<>();
        for (AggregateOperator t : aggregateOperator)
            reducers.add((Reducer) t.getOperatorExpression());
        aggregationBuilder.groupBy(Collections.singletonList(fieldName), reducers);
        return this;
    }

    @Override
    public NoSqlDbOperators distinct(String fieldName) {
        return this;
    }

    @Override
    public void printScreen() {
        redisConnectionManager.getConnection(connector).aggregate(aggregationBuilder);
    }

    @Override
    public Optional<Double> max(String fieldName) {
        return Optional.empty();
    }

    @Override
    public Optional<Double> min(String fieldName) {
        return Optional.empty();
    }

    @Override
    public Optional<Double> sum(String fieldName) {
        return Optional.empty();
    }

    @Override
    public Optional<Double> avg(String fieldName) {
        return Optional.empty();
    }

    @Override
    public int count() {
        return 0;
    }

    @Override
    public NoSqlDbOperators sort(SortOperator sortOperator, SortOperator... sortingOperators) {
        return null;
    }

    @Override
    public NoSqlDbOperators limit(int limit) {
        return this;
    }

    @Override
    public NoSqlDbOperators project(String fieldName, String... fieldNames) {
        return null;
    }

    @Override
    public Dataset<Row> toDataframe() {
        return null;
    }
}
