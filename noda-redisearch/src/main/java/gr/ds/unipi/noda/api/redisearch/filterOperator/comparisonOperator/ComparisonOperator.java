package gr.ds.unipi.noda.api.redisearch.filterOperator.comparisonOperator;

import gr.ds.unipi.noda.api.core.constants.StringPool;
import gr.ds.unipi.noda.api.redisearch.filterOperator.RediSearchPostFilterOperator;

abstract class ComparisonOperator<T> extends gr.ds.unipi.noda.api.core.operators.filterOperators.comparisonOperators.ComparisonOperator<StringBuilder, T> implements RediSearchPostFilterOperator {
    private final boolean isNotEqual;

    ComparisonOperator(String fieldName, T fieldValue, boolean isNotEqual) {
        super(fieldName, fieldValue);
        this.isNotEqual = isNotEqual;
    }

    ComparisonOperator(String fieldName, T fieldValue) {
        super(fieldName, fieldValue);
        this.isNotEqual = false;
    }

    protected abstract String getOperatorField();

    protected abstract String getPostOperatorField();

    @Override
    public StringBuilder getOperatorExpression() {
        StringBuilder sb = new StringBuilder();
        if (isNotEqual) {
            sb.append(StringPool.DASH).append(StringPool.AT);
        } else {
            sb.append(StringPool.AT);
        }
        sb.append(getFieldName()).append(StringPool.COLON).append(getOperatorField());
        return sb;
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
