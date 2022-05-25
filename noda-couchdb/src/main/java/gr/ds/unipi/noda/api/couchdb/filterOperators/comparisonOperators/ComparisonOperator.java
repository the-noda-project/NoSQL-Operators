package gr.ds.unipi.noda.api.couchdb.filterOperators.comparisonOperators;

abstract class ComparisonOperator<U> extends gr.ds.unipi.noda.api.core.operators.filterOperators.comparisonOperators.ComparisonOperator<Object, U> {
    protected ComparisonOperator(String fieldName, U fieldValue) {
        super(fieldName, fieldValue);
    }

    @Override
    public Object getOperatorExpression() {
        return null;
    }
}
