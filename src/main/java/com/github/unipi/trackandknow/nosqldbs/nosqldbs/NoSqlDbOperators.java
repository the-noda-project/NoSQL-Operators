package com.github.unipi.trackandknow.nosqldbs.nosqldbs;

import com.github.unipi.trackandknow.nosqldbs.aggregateOperator.AggregateOperator;
import com.github.unipi.trackandknow.nosqldbs.filterOperator.FilterOperator;
import com.github.unipi.trackandknow.nosqldbs.sortOperator.SortingOperator;
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

    NoSqlDbOperators sort(SortingOperator sortingOperator, SortingOperator... sortingOperators);

    NoSqlDbOperators limit(int limit);

    NoSqlDbOperators project(String fieldName, String... fieldNames);

    Dataset<Row> toDataframe();

}
