package gr.ds.unipi.noda.api.neo4j.filterOperators.logicalOperators;

import gr.ds.unipi.noda.api.core.operators.filterOperators.FilterOperator;
import gr.ds.unipi.noda.api.core.operators.filterOperators.logicalOperators.BaseLogicalOperatorFactory;

public class Neo4jLogicalOperatorFactory extends BaseLogicalOperatorFactory {
    @Override
    public LogicalOperator newOperatorAnd(FilterOperator filterOperator1, FilterOperator filterOperator2, FilterOperator... filterOperators) {
        return OperatorAnd.newOperatorAnd(filterOperator1, filterOperator2, filterOperators);
    }

    @Override
    public LogicalOperator newOperatorOr(FilterOperator filterOperator1, FilterOperator filterOperator2, FilterOperator... filterOperators) {
        return OperatorOr.newOperatorOr(filterOperator1, filterOperator2, filterOperators);
    }
}
