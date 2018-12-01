package com.github.unipi.trackandknow.nosqldbs.filterOperator.comparisonOperator;

public class OperatorNotEqual<T> extends ComparisonOperator<T> {

    private OperatorNotEqual(String fieldName, T fieldValue) {

        super(fieldName, fieldValue);
    }

    @Override
    protected String getOperatorJsonField() {
        return "ne";
    }

    public static <T> OperatorNotEqual newOperatorNotEqual(String fieldName, T fieldValue) {
        return new OperatorNotEqual(fieldName, fieldValue);
    }


}
