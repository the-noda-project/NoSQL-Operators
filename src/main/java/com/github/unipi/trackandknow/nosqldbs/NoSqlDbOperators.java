package com.github.unipi.trackandknow.nosqldbs;

import com.github.unipi.trackandknow.nosqldbs.aggregateOperator.AggregateOperator;
import com.github.unipi.trackandknow.nosqldbs.filterOperator.FilterOperator;

public interface NoSqlDbOperators {

    NoSqlDbOperators filter(FilterOperator filterOperator);

    NoSqlDbOperators groupBy(String fieldName, AggregateOperator... aggregateOperator);

    NoSqlDbOperators distinct(String fieldName);

    void printScreen();


    double max(String fieldName);

    int count();

    void project();

}
