package gr.ds.unipi.noda.api.redis.aggregateOperator;

import io.redisearch.aggregation.reducers.Reducer;

abstract class AggregateOperator extends gr.ds.unipi.noda.api.core.operators.aggregateOperators.AggregateOperator<Reducer> {

    AggregateOperator(String fieldName, String alias) {
        super(fieldName, alias);
    }

    protected abstract Reducer getOperatorField();

    public Reducer getOperatorExpression() {
        return getOperatorField().as(getAlias());
    }
}
