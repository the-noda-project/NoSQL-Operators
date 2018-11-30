package com.github.unipi.trackandknow.nosqldbs.filteroperator.comparison;

public class OperatorGreaterThanEqual<T extends Number> implements ComparisonOperator<T> {

    private final String fieldName;
    private final T fieldValue;

    @Override
    public String getFieldName() {
        return fieldName;
    }

    @Override
    public T getFieldValue() {
        return fieldValue;
    }

    @Override
    public int getComparisonOperatorId() {
        return 2;
    }

    private OperatorGreaterThanEqual(String fieldName, T fieldValue) {
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;

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
