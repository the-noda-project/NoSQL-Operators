package gr.ds.unipi.noda.api.YYYDataBase.filterOperator.logicalOperators;

import gr.ds.unipi.noda.api.core.operators.filterOperators.FilterOperator;
import gr.ds.unipi.noda.api.core.operators.filterOperators.logicalOperators.BaseLogicalOperatorFactory;
import gr.ds.unipi.noda.api.core.operators.filterOperators.logicalOperators.LogicalOperator;

public final class YYYDataBaseLogicalOperatorFactory extends BaseLogicalOperatorFactory {
    @Override
    public LogicalOperator newOperatorAnd(FilterOperator filterOperator1, FilterOperator filterOperator2, FilterOperator... filterOperators) {
        return null;
    }

    @Override
    public LogicalOperator newOperatorOr(FilterOperator filterOperator1, FilterOperator filterOperator2, FilterOperator... filterOperators) {
        return null;
    }
}
