package com.github.unipi.trackandknow.nosqldbs.connectivity;

import com.github.unipi.trackandknow.nosqldbs.aggregateOperator.AggregateOperator;
import com.github.unipi.trackandknow.nosqldbs.filterOperator.FilterOperator;
import com.github.unipi.trackandknow.nosqldbs.sortOperator.SortingOperator;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;

public interface NoSqlDbOperators {

    NoSqlDbOperators filter(FilterOperator filterOperator);

    NoSqlDbOperators groupBy(String fieldName, AggregateOperator... aggregateOperator);

    NoSqlDbOperators distinct(String fieldName);

    void printScreen();

    double max(String fieldName);

    double min(String fieldName);

    double sum(String fieldName);

    double avg(String fieldName);

    int count();

    NoSqlDbOperators sort(SortingOperator sortingOperator, SortingOperator... sortingOperators);

    NoSqlDbOperators limit(int limit);

    NoSqlDbOperators project(String fieldName, String... fieldNames);

    Dataset<Row> toDataframe();

}
