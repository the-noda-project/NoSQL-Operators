package gr.ds.unipi.noda.api.redisearch.filterOperators.comparisonOperators;

import gr.ds.unipi.noda.api.core.constants.StringPool;
import gr.ds.unipi.noda.api.redisearch.filterOperators.RediSearchPostFilterOperator;
import io.redisearch.querybuilder.Node;
import io.redisearch.querybuilder.QueryBuilder;
import io.redisearch.querybuilder.Value;

abstract class ComparisonOperator<T> extends gr.ds.unipi.noda.api.core.operators.filterOperators.comparisonOperators.ComparisonOperator<Node, T> implements RediSearchPostFilterOperator {
    private final boolean isNotEqual;

    ComparisonOperator(String fieldName, T fieldValue, boolean isNotEqual) {
        super(fieldName, fieldValue);
        this.isNotEqual = isNotEqual;
    }

    ComparisonOperator(String fieldName, T fieldValue) {
        super(fieldName, fieldValue);
        this.isNotEqual = false;
    }

    protected abstract Value getOperatorField();

    protected abstract String getPostOperatorField();

    @Override
    public Node getOperatorExpression() {
        if (isNotEqual) {
            return QueryBuilder.disjunct(getFieldName(), getOperatorField());
        } else {
            return QueryBuilder.intersect(getFieldName(), getOperatorField());//new ValueNode(getFieldName(), StringPool.BLANK, getOperatorField());
        }
    }

    public StringBuilder getPostOperatorExpression() {
        StringBuilder sb = new StringBuilder();
        sb.append(StringPool.AT)
                .append(getFieldName()).append(getPostOperatorField())
                .append(getField());
        return sb;
    }

    private Object getField() {
        if(super.getFieldValue() instanceof String)
            return StringPool.APOSTROPHE + super.getFieldValue() + StringPool.APOSTROPHE;
        else
            return super.getFieldValue();
    }
}
