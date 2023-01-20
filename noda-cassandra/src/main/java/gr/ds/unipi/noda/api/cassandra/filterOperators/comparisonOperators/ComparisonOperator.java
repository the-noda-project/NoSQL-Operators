package gr.ds.unipi.noda.api.cassandra.filterOperators.comparisonOperators;

abstract class ComparisonOperator<U> extends gr.ds.unipi.noda.api.core.operators.filterOperators.comparisonOperators.ComparisonOperator<StringBuilder, U> {
    protected ComparisonOperator(String fieldName, U fieldValue) {
        super(fieldName, fieldValue);
    }

    @Override
    public StringBuilder getOperatorExpression() {
        return null;
    }
}
