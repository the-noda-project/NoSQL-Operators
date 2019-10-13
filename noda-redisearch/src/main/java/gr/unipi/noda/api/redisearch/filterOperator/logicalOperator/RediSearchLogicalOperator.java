package gr.unipi.noda.api.redisearch.filterOperator.logicalOperator;

import gr.unipi.noda.api.core.nosqldb.StringPool;
import gr.unipi.noda.api.core.operators.filterOperators.FilterOperator;
import gr.unipi.noda.api.core.operators.filterOperators.logicalOperators.LogicalOperator;
import gr.unipi.noda.api.redisearch.filterOperator.RedisFilterOperator;

abstract class RediSearchLogicalOperator extends LogicalOperator<StringBuilder> implements RedisFilterOperator {

    RediSearchLogicalOperator(FilterOperator filterOperator1, FilterOperator filterOperator2, FilterOperator... filterOperators) {
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
            sb.append(((RedisFilterOperator) f).getPostOperatorExpression()).append(getPostOperatorField());
        sb.delete(sb.length() - 2, sb.length());
        sb.append(StringPool.QUOTE);
        return sb;
    }

    private void checkNumberOfChildrenCondition(RedisFilterOperator... filterOperatorChildren) {
        if (filterOperatorChildren.length < 2) {
            try {
                throw new Exception("Less than two children");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
