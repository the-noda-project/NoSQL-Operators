package gr.ds.unipi.noda.api.redisearch.sortOperators;

import io.redisearch.aggregation.SortedField;

/**
 * @author adimo on 2/10/2019
 */
abstract class SortOperator extends gr.ds.unipi.noda.api.core.operators.sortOperators.SortOperator<SortedField> {

    SortOperator(String fieldName) {
        super(fieldName);
    }

    protected abstract SortedField getOperatorField();

    @Override
    public SortedField getOperatorExpression() {
        return getOperatorField();
    }
}
