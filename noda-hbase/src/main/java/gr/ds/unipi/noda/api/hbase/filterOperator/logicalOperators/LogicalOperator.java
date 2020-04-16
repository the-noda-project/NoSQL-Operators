package gr.ds.unipi.noda.api.hbase.filterOperator.logicalOperators;

import gr.ds.unipi.noda.api.core.operators.filterOperators.FilterOperator;
import org.apache.hadoop.hbase.filter.Filter;
import org.apache.hadoop.hbase.filter.FilterList;

abstract class LogicalOperator extends gr.ds.unipi.noda.api.core.operators.filterOperators.logicalOperators.LogicalOperator<Filter> {
    protected LogicalOperator(FilterOperator filterOperator1, FilterOperator filterOperator2, FilterOperator... filterOperators) {
        super(filterOperator1, filterOperator2, filterOperators);
    }

    protected abstract FilterList.Operator getLogicalExpression();

    @Override
    public Filter getOperatorExpression() {
        FilterList filterList = new FilterList(getLogicalExpression());
        for (int i = 0; i < getFilterOperatorChildren().length; i++) {
            filterList.addFilter((Filter) getFilterOperatorChildren()[i].getOperatorExpression());
        }
        return filterList;
    }
}
