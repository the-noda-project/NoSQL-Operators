package com.github.unipi.trackandknow.nosqldbs;

import com.github.unipi.trackandknow.nosqldbs.filteroperator.FilterOperator;

public interface NoSqlDbOperators {


    void project();

    void project(String... column);

    NoSqlDbOperators filter(FilterOperator filterOperator);

    NoSqlDbOperators aggregation(String field);


}
