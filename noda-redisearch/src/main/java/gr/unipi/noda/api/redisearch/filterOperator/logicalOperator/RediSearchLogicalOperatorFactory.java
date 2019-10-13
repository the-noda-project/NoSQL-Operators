package gr.unipi.noda.api.redisearch.filterOperator.logicalOperator;

import gr.unipi.noda.api.core.operators.filterOperators.FilterOperator;
import gr.unipi.noda.api.core.operators.filterOperators.logicalOperators.BaseLogicalOperatorFactory;
import gr.unipi.noda.api.core.operators.filterOperators.logicalOperators.LogicalOperator;

/**
 * @author adimo on 10/10/2019
 */
public class RediSearchLogicalOperatorFactory extends BaseLogicalOperatorFactory {
    @Override
    public LogicalOperator newOperatorAnd(FilterOperator filterOperator1, FilterOperator filterOperator2, FilterOperator... filterOperators) {
        return OperatorAnd.newOperatorAnd(filterOperator1, filterOperator2, filterOperators);
    }

    @Override
    public LogicalOperator newOperatorOr(FilterOperator filterOperator1, FilterOperator filterOperator2, FilterOperator... filterOperators) {
        return OperatorOr.newOperatorOr(filterOperator1,filterOperator2, filterOperators);
    }
}
