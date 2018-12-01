package com.github.unipi.trackandknow.nosqldbs.filterOperator.comparisonOperator;

public class OperatorEqual<T> extends ComparisonOperator<T> {

    private OperatorEqual(String fieldName, T fieldValue) {

        super(fieldName, fieldValue);
    }

    @Override
    protected String getOperatorJsonField() {
        return "eq";
    }

    public static <T> OperatorEqual newOperatorEqual(String fieldName, T fieldValue) {
        return new OperatorEqual(fieldName, fieldValue);
    }


}
