package gr.ds.unipi.noda.api.redisearch.filterOperators.textualOperators;

import gr.ds.unipi.noda.api.redisearch.filterOperators.RediSearchPostFilterOperator;
import io.redisearch.querybuilder.Node;
import io.redisearch.querybuilder.QueryBuilder;

abstract class TextualOperator extends gr.ds.unipi.noda.api.core.operators.filterOperators.textualOperators.TextualOperator<Node> implements RediSearchPostFilterOperator {
    private final boolean isNotEqual;
    TextualOperator(String fieldName, String[] elements) {
        super(fieldName, elements);
        this.isNotEqual = false;
    }

    protected abstract Node getOperatorField();

    protected abstract StringBuilder getPostOperatorField();

    @Override
    public Node getOperatorExpression() {
        if (isNotEqual) {
            return QueryBuilder.disjunct(getOperatorField());
        } else {
            return getOperatorField();
        }
    }

    @Override
    public StringBuilder getPostOperatorExpression() {
        StringBuilder sb = getPostOperatorField();
        return sb.delete(sb.length() - 2, sb.length());
    }


}
