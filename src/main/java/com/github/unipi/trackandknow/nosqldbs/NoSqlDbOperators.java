package com.github.unipi.trackandknow.nosqldbs;

import com.github.unipi.trackandknow.nosqldbs.aggregateOperator.AggregateOperator;
import com.github.unipi.trackandknow.nosqldbs.filterOperator.FilterOperator;

public interface NoSqlDbOperators {

    NoSqlDbOperators filter(FilterOperator filterOperator);

    void execute();

    NoSqlDbOperators groupBy(String fieldName, AggregateOperator... aggregateOperator);

    double max(String fieldName);

    int count();

    void project();

}
