package com.github.unipi.trackandknow.nosqldbs.sortOperator;

import com.github.unipi.trackandknow.nosqldbs.Operator;

public abstract class SortingOperator implements Operator {

    private final String fieldName;
    private final int order;//1 for asc, -1 for desc

    protected SortingOperator(String fieldName, int order) {
        this.fieldName = fieldName;
        this.order = order;
    }

    @Override
    public StringBuilder getJsonStringBuilder() {
        StringBuilder sb = new StringBuilder();
        sb.append(fieldName + " : " + order);
        return sb;
    }
}
