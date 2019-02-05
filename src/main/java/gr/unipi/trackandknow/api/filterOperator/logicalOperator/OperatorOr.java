package gr.unipi.trackandknow.api.filterOperator.logicalOperator;

import gr.unipi.trackandknow.api.filterOperator.FilterOperator;

public class OperatorOr extends LogicalOperator {

    private OperatorOr(FilterOperator... filterOperatorChildren) {
        super(filterOperatorChildren);
    }

    public static OperatorOr newOperatorOr(FilterOperator... filterOperatorChildren) {
        return new OperatorOr(filterOperatorChildren);
    }

    @Override
    protected String getOperatorJsonField() {
        return "or";
    }

}
