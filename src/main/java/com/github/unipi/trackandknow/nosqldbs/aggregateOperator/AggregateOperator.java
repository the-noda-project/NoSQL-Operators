package com.github.unipi.trackandknow.nosqldbs.aggregateOperator;

import com.github.unipi.trackandknow.nosqldbs.Operator;

public abstract class AggregateOperator implements Operator {

    private final String fieldName;
    private String alias;

    protected AggregateOperator(String fieldName, String alias) {
        this.fieldName = fieldName;
        this.alias = alias;
    }

    public AggregateOperator as(String alias){
        this.alias = alias;
        return this;
    }

    protected abstract String getOperatorJsonField();

    @Override
    public StringBuilder getJsonStringBuilder(){
        StringBuilder sb = new StringBuilder();
        sb.append(getAlias());

        sb.append(": { $");
        sb.append(getOperatorJsonField());
        sb.append(": ");

        sb.append("\"$");
        sb.append(getFieldName());
        sb.append("\"");
        sb.append(" }");

        return sb;
    }

    public String getFieldName() {
        return fieldName;
    }

    public String getAlias() {
        return alias;
    }
}
