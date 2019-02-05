package gr.unipi.trackandknow.api.nosqldb;

import gr.unipi.trackandknow.api.aggregateOperator.AggregateOperator;
import gr.unipi.trackandknow.api.filterOperator.FilterOperator;
import gr.unipi.trackandknow.api.sortOperator.SortOperator;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;

import java.util.Optional;

public interface NoSqlDbOperators {

    NoSqlDbOperators filter(FilterOperator filterOperator, FilterOperator... filterOperators);

    NoSqlDbOperators groupBy(String fieldName, AggregateOperator... aggregateOperator);

    NoSqlDbOperators distinct(String fieldName);

    void printScreen();

    Optional<Double> max(String fieldName);

    Optional<Double> min(String fieldName);

    Optional<Double> sum(String fieldName);

    Optional<Double> avg(String fieldName);

    int count();

    NoSqlDbOperators sort(SortOperator sortOperator, SortOperator... sortingOperators);

    NoSqlDbOperators limit(int limit);

    NoSqlDbOperators project(String fieldName, String... fieldNames);

    Dataset<Row> toDataframe();

}
