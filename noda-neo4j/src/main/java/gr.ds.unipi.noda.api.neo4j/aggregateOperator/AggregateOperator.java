package gr.ds.unipi.noda.api.neo4j.aggregateOperator;

abstract class AggregateOperator extends gr.ds.unipi.noda.api.core.operators.aggregateOperators.AggregateOperator<T> {

    protected AggregateOperator(String fieldName, String alias) {
        super(fieldName, alias);
    }

    @Override
    public T getOperatorExpression() {
        return null;
    }

}
