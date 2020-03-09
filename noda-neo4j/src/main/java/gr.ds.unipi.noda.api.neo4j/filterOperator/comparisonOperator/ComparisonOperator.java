package gr.ds.unipi.noda.api.neo4j.filterOperator.comparisonOperator;

abstract class ComparisonOperator<U> extends gr.ds.unipi.noda.api.core.operators.filterOperators.comparisonOperators.ComparisonOperator<T, U> {

    protected ComparisonOperator(String fieldName, U fieldValue) {
        super(fieldName, fieldValue);
    }

    @Override
    public T getOperatorExpression() {
        return null;
    }
}
