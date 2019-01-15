package com.github.unipi.trackandknow.nosqldbs.aggregateOperator;

public class OperatorSum extends AggregateOperator {

    private OperatorSum(String fieldName){
        super(fieldName, "sum_"+fieldName);
    }

    public static OperatorSum newOperatorSum(String fieldName){
        return new OperatorSum(fieldName);
    }

    @Override
    protected String getOperatorJsonField() {
        return "sum";
    }
}
