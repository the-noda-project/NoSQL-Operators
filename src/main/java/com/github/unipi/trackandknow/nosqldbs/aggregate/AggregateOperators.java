package com.github.unipi.trackandknow.nosqldbs.aggregate;

public class AggregateOperators {

    public static AggregateOperator max(String fieldName) {
        return OperatorMax.newOperatorMax(fieldName);
    }

}
