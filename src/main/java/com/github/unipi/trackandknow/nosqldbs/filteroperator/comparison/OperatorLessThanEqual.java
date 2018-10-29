package com.github.unipi.trackandknow.nosqldbs.filteroperator.comparison;

public class OperatorLessThanEqual<T extends Number> implements ComparisonOperator<T> {

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

    private OperatorLessThanEqual(String fieldName, T fieldValue) {
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;

    }

    public static <T extends Number> OperatorLessThanEqual newOperatorLessThanEqual(String fieldName, T fieldValue) {
        return new OperatorLessThanEqual(fieldName, fieldValue);
    }

    @Override
    public String getJsonString() {
        return "{ " + ((!fieldName.contains(".")) ? fieldName : "\"" + fieldName + "\"") +
                ": { $lte: " + fieldValue + " } }";
    }

}
