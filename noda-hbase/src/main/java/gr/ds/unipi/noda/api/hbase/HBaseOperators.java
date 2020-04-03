package gr.ds.unipi.noda.api.hbase;

import gr.ds.unipi.noda.api.core.nosqldb.NoSqlDbConnector;
import gr.ds.unipi.noda.api.core.nosqldb.NoSqlDbOperators;
import gr.ds.unipi.noda.api.core.operators.aggregateOperators.AggregateOperator;
import gr.ds.unipi.noda.api.core.operators.filterOperators.FilterOperator;
import gr.ds.unipi.noda.api.core.operators.sortOperators.SortOperator;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;

import java.util.Optional;

final class HBaseOperators extends NoSqlDbOperators {

    private final HBaseConnectionManager hbaseConnectionManager = HBaseConnectionManager.getInstance();

    private HBaseOperators(NoSqlDbConnector connector, String s, SparkSession sparkSession) {
        super(connector, s, sparkSession);
    }

    static HBaseOperators newHBaseOperators(NoSqlDbConnector connector, String s, SparkSession sparkSession) {
        return new HBaseOperators(connector, s, sparkSession);
    }

    @Override
    public NoSqlDbOperators filter(FilterOperator filterOperator, FilterOperator... filterOperators) {
        return null;
    }

    @Override
    public NoSqlDbOperators groupBy(String fieldName, AggregateOperator... aggregateOperator) {
        return null;
    }

    @Override
    public NoSqlDbOperators distinct(String fieldName) {
        return null;
    }

    @Override
    public void printScreen() {

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
        return null;
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
