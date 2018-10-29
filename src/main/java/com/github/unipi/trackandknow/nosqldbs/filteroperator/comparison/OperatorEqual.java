package com.github.unipi.trackandknow.nosqldbs.filteroperator.comparison;

public class OperatorEqual<T> implements ComparisonOperator<T> {

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

    private OperatorEqual(String fieldName, T fieldValue) {
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;

    }

    public static <T> OperatorEqual newOperatorEqual(String fieldName, T fieldValue) {
        return new OperatorEqual(fieldName, fieldValue);
    }

    @Override
    public String getJsonString() {

        return "{ " + ((!fieldName.contains(".")) ? fieldName : "\"" + fieldName + "\"") +
                ": { $eq: " + ((fieldValue.getClass() == String.class) ? "\"" + fieldValue + "\"" : fieldValue) + " } }";
    }

}
