package gr.ds.unipi.noda.api.hbase.filterOperator.logicalOperators;

import gr.ds.unipi.noda.api.core.operators.filterOperators.FilterOperator;

abstract class LogicalOperator extends gr.ds.unipi.noda.api.core.operators.filterOperators.logicalOperators.LogicalOperator<Object> {
    protected LogicalOperator(FilterOperator filterOperator1, FilterOperator filterOperator2, FilterOperator... filterOperators) {
        super(filterOperator1, filterOperator2, filterOperators);
    }

    @Override
    public Object getOperatorExpression() {
        return null;
    }
}
