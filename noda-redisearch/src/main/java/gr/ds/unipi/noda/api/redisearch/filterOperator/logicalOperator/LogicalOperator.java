package gr.ds.unipi.noda.api.redisearch.filterOperator.logicalOperator;

import gr.ds.unipi.noda.api.core.constants.StringPool;
import gr.ds.unipi.noda.api.core.operators.filterOperators.FilterOperator;
import gr.ds.unipi.noda.api.redisearch.filterOperator.RediSearchPostFilterOperator;

abstract class LogicalOperator extends gr.ds.unipi.noda.api.core.operators.filterOperators.logicalOperators.LogicalOperator<StringBuilder> implements RediSearchPostFilterOperator {

    LogicalOperator(FilterOperator filterOperator1, FilterOperator filterOperator2, FilterOperator... filterOperators) {
        super(filterOperator1, filterOperator2, filterOperators);
    }

    protected abstract String getOperatorField();

    protected abstract String getPostOperatorField();

    public StringBuilder getOperatorExpression() {
        StringBuilder sb = new StringBuilder();
        for (FilterOperator f : getFilterOperatorChildren())
            sb.append(f.getOperatorExpression()).append(getOperatorField());
        sb.delete(sb.length() - 1, sb.length());
        return sb;
    }

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
