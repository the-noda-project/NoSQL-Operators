package com.github.unipi.trackandknow.nosqldbs.filterOperator.comparisonOperator;

public class OperatorLessThan<T extends Number> extends ComparisonOperator<T> {

    private OperatorLessThan(String fieldName, T fieldValue) {

        super(fieldName, fieldValue);
    }

    @Override
    protected String getOperatorJsonField() {
        return "lt";
    }

    public static <T extends Number> OperatorLessThan newOperatorLessThan(String fieldName, T fieldValue) {
        return new OperatorLessThan(fieldName, fieldValue);
    }

//    @Override
//    public StringBuilder getJsonString() {
//
//        return "{ " + ((!fieldName.contains(".")) ? fieldName : "\"" + fieldName + "\"") +
//                ": { $lt: " + fieldValue + " } }";
//    }

}
