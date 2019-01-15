package com.github.unipi.trackandknow.nosqldbs.filterOperator.logicalOperator;

import com.github.unipi.trackandknow.nosqldbs.filterOperator.FilterOperator;

public abstract class LogicalOperator implements FilterOperator {

    private final FilterOperator[] filterOperatorChildren;

    protected LogicalOperator(FilterOperator... filterOperatorChildren) {
        checkNumberOfChildrenCondition(filterOperatorChildren);
        this.filterOperatorChildren = filterOperatorChildren;
    }

    protected FilterOperator[] getFilterOperatorChildren() {
        return filterOperatorChildren;
    }

    protected abstract String getOperatorJsonField();

    public StringBuilder getJsonStringBuilder() {
        StringBuilder sb = new StringBuilder();

        sb.append("{ $");
        sb.append(getOperatorJsonField());
        sb.append(": [ ");

        for (FilterOperator fop : getFilterOperatorChildren()) {

            sb.append(fop.getJsonStringBuilder());
            sb.append(", ");

        }
        sb.deleteCharAt(sb.lastIndexOf(", "));

        sb.append(" ] }");

        return sb;
    }

    private void checkNumberOfChildrenCondition(FilterOperator... filterOperatorChildren) {
        if (filterOperatorChildren.length < 2) {
            try {
                throw new Exception("Less than two children");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
