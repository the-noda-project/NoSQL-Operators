package gr.unipi.trackandknow.api.sortOperator;

import gr.unipi.trackandknow.api.Operator;

public abstract class SortOperator implements Operator {

    private final String fieldName;
    private final int order;//1 for asc, -1 for desc

    protected SortOperator(String fieldName, int order) {
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
