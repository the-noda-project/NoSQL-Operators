package com.github.unipi.trackandknow.nosqldbs.filterOperator.logicalOperator;

import com.github.unipi.trackandknow.nosqldbs.filterOperator.FilterOperator;

public class OperatorOr extends LogicalOperator {

    private OperatorOr(FilterOperator... filterOperatorChildren){
        super(filterOperatorChildren);
    }

    public static OperatorOr newOperatorOr(FilterOperator... filterOperatorChildren){
        return new OperatorOr(filterOperatorChildren);
    }

    @Override
    protected String getOperatorJsonField() {
        return "or";
    }

}
