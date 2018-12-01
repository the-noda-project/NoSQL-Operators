package com.github.unipi.trackandknow.nosqldbs.filterOperator.comparisonOperator;

public class OperatorGreaterThan<T extends Number> extends ComparisonOperator<T> {

    private OperatorGreaterThan(String fieldName, T fieldValue) {
        super(fieldName, fieldValue);
    }

    @Override
    protected String getOperatorJsonField() {
        return "gt";
    }

    public static <T extends Number> OperatorGreaterThan newOperatorGreaterThan(String fieldName, T fieldValue) {
        return new OperatorGreaterThan(fieldName, fieldValue);
    }


}
