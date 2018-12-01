package com.github.unipi.trackandknow.nosqldbs.aggregateOperator;

public class AggregateOperators {

    public static AggregateOperator max(String fieldName) {
        return OperatorMax.newOperatorMax(fieldName);
    }

}
