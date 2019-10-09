package gr.unipi.noda.api.core.operators.filterOperators.logicalOperators;

import gr.unipi.noda.api.core.operators.filterOperators.FilterOperator;

public abstract class BaseLogicalOperatorFactory {

    public abstract LogicalOperator newOperatorAnd(FilterOperator filterOperator1, FilterOperator filterOperator2, FilterOperator... filterOperators);

    public abstract LogicalOperator newOperatorOr(FilterOperator filterOperator1, FilterOperator filterOperator2, FilterOperator... filterOperators);

}
