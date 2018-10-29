package com.github.unipi.trackandknow.nosqldbs.filteroperator.comparison;

public class OperatorNotEqual<T> implements ComparisonOperator<T> {

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

    private OperatorNotEqual(String fieldName, T fieldValue) {
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;

    }

    public static <T> OperatorNotEqual newOperatorNotEqual(String fieldName, T fieldValue) {
        return new OperatorNotEqual(fieldName, fieldValue);
    }

    @Override
    public String getJsonString() {

        return "{ " + ((!fieldName.contains(".")) ? fieldName : "\"" + fieldName + "\"") +
                ": { $ne: " + ((fieldValue.getClass() == String.class) ? "\"" + fieldValue + "\"" : fieldValue) + " } }";
    }

}
