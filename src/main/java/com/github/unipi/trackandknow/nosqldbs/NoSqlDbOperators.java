package com.github.unipi.trackandknow.nosqldbs;

import com.github.unipi.trackandknow.nosqldbs.aggregate.AggregateOperator;
import com.github.unipi.trackandknow.nosqldbs.filteroperator.FilterOperator;

public interface NoSqlDbOperators {

    NoSqlDbOperators filter(FilterOperator filterOperator);

    void execute();

    NoSqlDbOperators groupBy(String fieldName, AggregateOperator... aggregateOperator);

    double max(String fieldName);

    int count();

    void project();

}
