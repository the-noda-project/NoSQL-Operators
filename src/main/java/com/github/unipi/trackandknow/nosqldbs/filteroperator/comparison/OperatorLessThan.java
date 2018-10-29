package com.github.unipi.trackandknow.nosqldbs.filteroperator.comparison;

public class OperatorLessThan<T extends Number> implements ComparisonOperator<T> {

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

    private OperatorLessThan(String fieldName, T fieldValue) {
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;

    }

    public static <T extends Number> OperatorLessThan newOperatorLessThan(String fieldName, T fieldValue) {
        return new OperatorLessThan(fieldName, fieldValue);
    }

    @Override
    public String getJsonString() {

        return "{ " + ((!fieldName.contains(".")) ? fieldName : "\"" + fieldName + "\"") +
                ": { $lt: " + fieldValue + " } }";
    }

}
