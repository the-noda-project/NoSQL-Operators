package gr.unipi.noda.api.core.nosqldb;

import gr.unipi.noda.api.core.operators.AggregateOperator;
import gr.unipi.noda.api.core.operators.FilterOperator;
import gr.unipi.noda.api.core.operators.SortOperator;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;

import java.util.Optional;

public interface NoSqlDbOperators {

    default NoSqlDbOperators filter(FilterOperator filterOperator, FilterOperator... filterOperators) {
        throw new UnsupportedOperationException("Filter primitive is not supported");
    }

    default NoSqlDbOperators groupBy(String fieldName, AggregateOperator... aggregateOperator) {
        throw new UnsupportedOperationException("Groupby primitive is not supported");
    }

    default NoSqlDbOperators distinct(String fieldName) {
        throw new UnsupportedOperationException("Distinct primitive is not supported");
    }

    default void printScreen() {
        throw new UnsupportedOperationException("PrintScreen primitive is not supported");
    }

    default Optional<Double> max(String fieldName) {
        throw new UnsupportedOperationException("Max primitive is not supported");
    }

    default Optional<Double> min(String fieldName) {
        throw new UnsupportedOperationException("Min primitive is not supported");
    }

    default Optional<Double> sum(String fieldName) {
        throw new UnsupportedOperationException("Sum primitive is not supported");
    }

    default Optional<Double> avg(String fieldName) {
        throw new UnsupportedOperationException("Average primitive is not supported");
    }

    default int count() {
        throw new UnsupportedOperationException("Count primitive is not supported");
    }

    default NoSqlDbOperators sort(SortOperator sortOperator, SortOperator... sortingOperators) {
        throw new UnsupportedOperationException("Sort primitive is not supported");
    }

    default NoSqlDbOperators limit(int limit) {
        throw new UnsupportedOperationException("Limit primitive is not supported");
    }

    default NoSqlDbOperators project(String fieldName, String... fieldNames) {
        throw new UnsupportedOperationException("Project primitive is not supported");
    }

    default Dataset<Row> toDataframe() {
        throw new UnsupportedOperationException("ToDataframe primitive is not supported");
    }

}
