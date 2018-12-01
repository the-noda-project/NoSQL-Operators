package com.github.unipi.trackandknow.nosqldbs.filterOperator.comparisonOperator;

public class OperatorGreaterThanEqual<T extends Number> extends ComparisonOperator<T> {

    private OperatorGreaterThanEqual(String fieldName, T fieldValue) {

        super(fieldName, fieldValue);
    }

    @Override
    protected String getOperatorJsonField() {
        return "gte";
    }

    public static <T extends Number> OperatorGreaterThanEqual newOperatorGreaterThanEqual(String fieldName, T fieldValue) {
        return new OperatorGreaterThanEqual(fieldName, fieldValue);
    }

//    @Override
//    public StringBuilder getJsonString() {
//
//        return "{ " + ((!fieldName.contains(".")) ? fieldName : "\"" + fieldName + "\"") +
//                ": { $gte: " + fieldValue + " } }";
//    }

}
