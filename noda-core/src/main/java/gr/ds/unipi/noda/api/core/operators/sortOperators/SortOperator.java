package gr.ds.unipi.noda.api.core.operators.sortOperators;

import gr.ds.unipi.noda.api.core.operators.Operator;

public abstract class SortOperator<T> implements Operator<T> {

    private final String fieldName;

    protected SortOperator(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getFieldName() {
        return fieldName;
    }

    public static BaseSortOperatorFactory sortOperator;

}

