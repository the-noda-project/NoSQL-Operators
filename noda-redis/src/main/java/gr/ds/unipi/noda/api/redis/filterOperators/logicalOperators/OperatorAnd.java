package gr.ds.unipi.noda.api.redis.filterOperators.logicalOperators;

import gr.ds.unipi.noda.api.core.operators.filterOperators.FilterOperator;
import gr.ds.unipi.noda.api.redis.filterOperators.comparisonOperators.*;

final class OperatorAnd extends LogicalOperator {

    private OperatorAnd(FilterOperator filterOperator1, FilterOperator filterOperator2, FilterOperator... filterOperators) {
        super(-1, OperatorGreaterThanEqual.class, OperatorLessThanEqual.class, filterOperator1, filterOperator2, filterOperators);
    }

    public static OperatorAnd newOperatorAnd(FilterOperator filterOperator1, FilterOperator filterOperator2, FilterOperator... filterOperators) {
        return new OperatorAnd(filterOperator1, filterOperator2, filterOperators);
    }

    @Override
    protected String setOperation() {
        return "SINTERSTORE";
    }

}
