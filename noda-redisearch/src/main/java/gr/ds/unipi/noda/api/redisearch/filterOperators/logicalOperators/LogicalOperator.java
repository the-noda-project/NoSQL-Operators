package gr.ds.unipi.noda.api.redisearch.filterOperators.logicalOperators;

import gr.ds.unipi.noda.api.core.constants.StringPool;
import gr.ds.unipi.noda.api.core.operators.filterOperators.FilterOperator;
import gr.ds.unipi.noda.api.redisearch.filterOperators.RediSearchPostFilterOperator;
import io.redisearch.querybuilder.Node;

abstract class LogicalOperator extends gr.ds.unipi.noda.api.core.operators.filterOperators.logicalOperators.LogicalOperator<Node> implements RediSearchPostFilterOperator {

    LogicalOperator(FilterOperator filterOperator1, FilterOperator filterOperator2, FilterOperator... filterOperators) {
        super(filterOperator1, filterOperator2, filterOperators);
    }

    protected abstract String getPostOperatorField();

    public StringBuilder getPostOperatorExpression() {
        StringBuilder sb = new StringBuilder();
        sb.append(StringPool.QUOTE);
        for (FilterOperator f : getFilterOperatorChildren())
            sb.append(((RediSearchPostFilterOperator) f).getPostOperatorExpression()).append(getPostOperatorField());
        sb.delete(sb.length() - 2, sb.length());
        sb.append(StringPool.QUOTE);
        return sb;
    }
}
