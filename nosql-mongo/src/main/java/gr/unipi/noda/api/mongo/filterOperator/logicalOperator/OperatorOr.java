package gr.unipi.noda.api.mongo.filterOperator.logicalOperator;

import gr.unipi.noda.api.core.operators.FilterOperator;

public class OperatorOr extends LogicalOperator {

    private OperatorOr(FilterOperator filterOperator1, FilterOperator filterOperator2, FilterOperator... filterOperators) {
        super(filterOperator1, filterOperator2, filterOperators);
    }

    public static OperatorOr newOperatorOr(FilterOperator filterOperator1, FilterOperator filterOperator2, FilterOperator... filterOperators) {
        return new OperatorOr(filterOperator1, filterOperator2, filterOperators);
    }

    @Override
    protected String getOperatorJsonField() {
        return "or";
    }

}
