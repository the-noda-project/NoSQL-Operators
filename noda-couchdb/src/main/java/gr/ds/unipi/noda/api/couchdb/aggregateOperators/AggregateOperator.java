package gr.ds.unipi.noda.api.couchdb.aggregateOperators;

abstract class AggregateOperator extends gr.ds.unipi.noda.api.core.operators.aggregateOperators.AggregateOperator<String[]> {

    protected AggregateOperator(String fieldName, String alias) {
        super(fieldName, alias);
    }

    abstract protected String reduceStageExpression();

    abstract protected String rereduceStageExpression();

    @Override
    public String[] getOperatorExpression() {
        return new String[]{reduceStageExpression(), rereduceStageExpression()};
    }
}