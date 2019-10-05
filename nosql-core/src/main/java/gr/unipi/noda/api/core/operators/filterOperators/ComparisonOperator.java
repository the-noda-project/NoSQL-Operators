package gr.unipi.noda.api.core.operators.filterOperators;

import gr.unipi.noda.api.core.operators.FilterOperator;

public abstract class ComparisonOperator<T, U> implements FilterOperator<T> {

    private final String fieldName;
    private final U fieldValue;

    protected ComparisonOperator(String fieldName, U fieldValue) {
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
    }

    protected String getFieldName() {
        return fieldName;
    }

    protected U getFieldValue() {
        return fieldValue;
    }
}
