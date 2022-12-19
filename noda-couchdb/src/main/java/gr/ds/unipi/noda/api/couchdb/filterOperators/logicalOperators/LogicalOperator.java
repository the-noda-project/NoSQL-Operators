package gr.ds.unipi.noda.api.couchdb.filterOperators.logicalOperators;

import gr.ds.unipi.noda.api.core.operators.filterOperators.FilterOperator;

import java.util.Arrays;
import java.util.stream.Collectors;

abstract class LogicalOperator extends gr.ds.unipi.noda.api.core.operators.filterOperators.logicalOperators.LogicalOperator<String> {
    protected LogicalOperator(FilterOperator<?> filterOperator1, FilterOperator<?> filterOperator2, FilterOperator<?>... filterOperators) {
        super(filterOperator1, filterOperator2, filterOperators);
    }

    abstract protected String operatorSymbol();

    @Override
    public String getOperatorExpression() {
        return "(" + Arrays.stream(getFilterOperatorChildren())
                .map(o -> (String) o.getOperatorExpression())
                .collect(Collectors.joining(operatorSymbol())) + ")";
    }
}
