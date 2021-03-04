package gr.ds.unipi.noda.api.hbase.filterOperators.logicalOperators;

import gr.ds.unipi.noda.api.core.operators.filterOperators.FilterOperator;
import org.apache.hadoop.hbase.filter.FilterList;

final class OperatorOr extends LogicalOperator {

    private OperatorOr(FilterOperator filterOperator1, FilterOperator filterOperator2, FilterOperator... filterOperators) {
        super(filterOperator1, filterOperator2, filterOperators);
    }

    @Override
    protected FilterList.Operator getLogicalExpression() {
        return FilterList.Operator.MUST_PASS_ONE;
    }

    public static OperatorOr newOperatorOr(FilterOperator filterOperator1, FilterOperator filterOperator2, FilterOperator... filterOperators) {
        return new OperatorOr(filterOperator1, filterOperator2, filterOperators);
    }

}
