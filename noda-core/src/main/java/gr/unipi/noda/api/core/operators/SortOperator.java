package gr.unipi.noda.api.core.operators;

public abstract class SortOperator<T> implements Operator<T> {

    private final String fieldName;
    private final int order;//1 for asc, -1 for desc

    protected SortOperator(String fieldName, int order) {
        this.fieldName = fieldName;
        this.order = order;
    }

    public String getFieldName() {
        return fieldName;
    }

    public int getOrder() {
        return order;
    }
}

