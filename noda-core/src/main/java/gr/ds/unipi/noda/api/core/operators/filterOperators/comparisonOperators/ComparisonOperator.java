package gr.ds.unipi.noda.api.core.operators.filterOperators.comparisonOperators;

import gr.ds.unipi.noda.api.core.operators.filterOperators.FilterOperator;

public abstract class ComparisonOperator<T, U> implements FilterOperator<T> {

    private final String fieldName;
    private final U fieldValue;

    protected ComparisonOperator(String fieldName, U fieldValue) {
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
    }

    public String getFieldName() {
        return fieldName;
    }

    public U getFieldValue() {
        return fieldValue;
    }

    public static BaseComparisonOperatorFactory comparisonOperator;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ComparisonOperator<?, ?> that = (ComparisonOperator<?, ?>) o;
        
        if (!fieldName.equals(that.fieldName)) return false;
        return fieldValue.equals(that.fieldValue);
    }

    @Override
    public int hashCode() {
        int result = fieldName.hashCode();
        result = 31 * result + fieldValue.hashCode();
        result = 31 * result + getClass().hashCode();
        return result;
    }
}
