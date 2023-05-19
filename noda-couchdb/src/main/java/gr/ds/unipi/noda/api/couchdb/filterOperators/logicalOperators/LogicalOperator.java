package gr.ds.unipi.noda.api.couchdb.filterOperators.logicalOperators;

import gr.ds.unipi.noda.api.core.operators.filterOperators.FilterOperator;
import gr.ds.unipi.noda.api.couchdb.filterOperators.FilterStrategy;

import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
import java.util.stream.Collectors;

abstract class LogicalOperator extends gr.ds.unipi.noda.api.core.operators.filterOperators.logicalOperators.LogicalOperator<FilterStrategy> {
    protected LogicalOperator(FilterOperator<?> filterOperator1, FilterOperator<?> filterOperator2, FilterOperator<?>... filterOperators) {
        super(filterOperator1, filterOperator2, filterOperators);
    }

    abstract protected String mapOperatorSymbol();

    abstract protected String mangoOperatorSymbol();

    @Override
    public FilterStrategy getOperatorExpression() {
        return new FilterStrategy() {
            @Override
            public String asMapFilter() {
                return "(" + Arrays.stream(getFilterOperatorChildren())
                        .map(op -> ((FilterStrategy) op.getOperatorExpression()).asMapFilter())
                        .collect(Collectors.joining(mapOperatorSymbol())) + ")";
            }

            @Override
            public Map<String, Object> asFindFilter() {
                return Collections.singletonMap(mangoOperatorSymbol(),
                        Arrays.stream(getFilterOperatorChildren())
                                .map(op -> ((FilterStrategy) op.getOperatorExpression()).asFindFilter())
                                .collect(Collectors.toList())
                );
            }
        };
    }
}
