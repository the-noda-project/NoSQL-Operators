package gr.ds.unipi.noda.api.couchdb.sortOperators;

import org.apache.commons.lang3.tuple.ImmutablePair;

abstract class SortOperator extends gr.ds.unipi.noda.api.core.operators.sortOperators.SortOperator<ImmutablePair<String, String>> {
    protected SortOperator(String fieldName) {
        super(fieldName);
    }

    protected abstract String orderName();

    @Override
    public ImmutablePair<String, String> getOperatorExpression() {
        return new ImmutablePair<>(getFieldName(), orderName());
    }
}
