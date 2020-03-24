package gr.ds.unipi.noda.api.redisearch.filterOperator.textualOperator;

import gr.ds.unipi.noda.api.core.constants.StringPool;
import gr.ds.unipi.noda.api.redisearch.filterOperator.RediSearchPostFilterOperator;

abstract class TextualOperator extends gr.ds.unipi.noda.api.core.operators.filterOperators.textualOperators.TextualOperator<StringBuilder> implements RediSearchPostFilterOperator {
    private final boolean isNotEqual;
    TextualOperator(String fieldName, String[] elements, int condition) {
        super(fieldName, elements, condition);
        this.isNotEqual = false;
    }

    TextualOperator(String fieldName, String[] elements, int condition, boolean isNotEqual) {
        super(fieldName, elements, condition);
        this.isNotEqual = isNotEqual;
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
