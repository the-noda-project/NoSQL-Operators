package gr.ds.unipi.noda.api.neo4j.aggregateOperators;

abstract class AggregateOperator extends gr.ds.unipi.noda.api.core.operators.aggregateOperators.AggregateOperator<String> {

    protected AggregateOperator(String fieldName, String alias) {
        super(fieldName, alias);
    }

    @Override
    public String getOperatorExpression() {
        return null;
    }

}
