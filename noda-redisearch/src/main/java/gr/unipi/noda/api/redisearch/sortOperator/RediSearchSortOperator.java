package gr.unipi.noda.api.redisearch.sortOperator;

import gr.unipi.noda.api.core.operators.sortOperators.SortOperator;
import io.redisearch.aggregation.SortedField;

/**
 * @author adimo on 2/10/2019
 */
abstract class RediSearchSortOperator extends SortOperator<SortedField> {

    protected RediSearchSortOperator(String fieldName) {
        super(fieldName, 0);
    }

    protected abstract SortedField getOperatorField();

    @Override
    public SortedField getOperatorExpression() {
        return getOperatorField();
    }
}
