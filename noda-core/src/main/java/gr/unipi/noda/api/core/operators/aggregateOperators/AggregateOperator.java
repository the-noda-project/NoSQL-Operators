package gr.unipi.noda.api.core.operators.aggregateOperators;

import gr.unipi.noda.api.core.operators.Operator;

public abstract class AggregateOperator<T> implements Operator<T> {

    private final String fieldName;
    private String alias;

    protected AggregateOperator(String fieldName, String alias) {
        this.fieldName = fieldName;
        this.alias = alias;
    }

    public AggregateOperator as(String alias) {
        this.alias = alias;
        return this;
    }

    public String getFieldName() {
        return fieldName;
    }

    public String getAlias() {
        return alias;
    }

}
