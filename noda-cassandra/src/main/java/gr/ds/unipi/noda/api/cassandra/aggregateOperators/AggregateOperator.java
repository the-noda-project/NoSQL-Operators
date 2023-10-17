package gr.ds.unipi.noda.api.cassandra.aggregateOperators;

abstract class AggregateOperator extends gr.ds.unipi.noda.api.core.operators.aggregateOperators.AggregateOperator<Object> {

    protected AggregateOperator(String fieldName, String alias) {
        super(fieldName, alias);
    }

    @Override
    public StringBuilder getOperatorExpression() {
        return null;
    }
}
