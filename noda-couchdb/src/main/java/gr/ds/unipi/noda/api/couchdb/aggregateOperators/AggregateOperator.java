package gr.ds.unipi.noda.api.couchdb.aggregateOperators;

import org.apache.commons.lang3.tuple.ImmutablePair;

abstract class AggregateOperator extends gr.ds.unipi.noda.api.core.operators.aggregateOperators.AggregateOperator<ImmutablePair<String, String>> {

    protected AggregateOperator(String fieldName, String alias) {
        super(fieldName, alias);
    }

    abstract protected String reduceStageExpression();

    abstract protected String rereduceStageExpression();

    @Override
    public ImmutablePair<String, String> getOperatorExpression() {
        return new ImmutablePair<>(reduceStageExpression(), rereduceStageExpression());
    }
}