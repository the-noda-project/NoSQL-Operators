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

    NoSqlDbOperators sort(SortingOperator sop1, SortingOperator... sop2);

    NoSqlDbOperators limit(int limit);

    void project();

    Dataset<Row> toDataframe();

}
