package gr.unipi.noda.api.redisearch.filterOperator.logicalOperator;

import gr.unipi.noda.api.core.nosqldb.StringPool;
import gr.unipi.noda.api.core.operators.filterOperators.FilterOperator;

class OperatorOr extends RediSearchLogicalOperator {

    private OperatorOr(FilterOperator filterOperator1, FilterOperator filterOperator2, FilterOperator... filterOperators) {
        super(filterOperator1, filterOperator2, filterOperators);
    }

    public static OperatorOr newOperatorOr(FilterOperator filterOperator1, FilterOperator filterOperator2, FilterOperator... filterOperators) {
        return new OperatorOr(filterOperator1, filterOperator2, filterOperators);
    }

    @Override
    protected String getOperatorField() {
        return StringPool.PIPE;
    }

    @Override
    protected String getPostOperatorField() {
        return StringPool.DOUBLE_PIPE;
    }

}
