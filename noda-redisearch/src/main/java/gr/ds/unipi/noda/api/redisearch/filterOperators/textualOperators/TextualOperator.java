package gr.ds.unipi.noda.api.redisearch.filterOperators.textualOperators;

import gr.ds.unipi.noda.api.core.constants.StringPool;
import gr.ds.unipi.noda.api.redisearch.filterOperators.RediSearchPostFilterOperator;

abstract class TextualOperator extends gr.ds.unipi.noda.api.core.operators.filterOperators.textualOperators.TextualOperator<StringBuilder> implements RediSearchPostFilterOperator {
    private final boolean isNotEqual;
    TextualOperator(String fieldName, String[] elements) {
        super(fieldName, elements);
        this.isNotEqual = false;
    }

    protected abstract String getOperatorField();

    protected abstract StringBuilder getPostOperatorField();

    @Override
    public StringBuilder getPostOperatorExpression() {
        StringBuilder sb = new StringBuilder();
        if (isNotEqual) {
            sb.append(StringPool.DASH).append(StringPool.AT);
        } else {
            sb.append(StringPool.AT);
        }
        sb.append(getFieldName()).append(StringPool.COLON).append(getOperatorField());
        return sb;
    }

    @Override
    public StringBuilder getOperatorExpression() {
        StringBuilder sb = getPostOperatorField();
        return sb.delete(sb.length() - 2, sb.length());
    }


}
