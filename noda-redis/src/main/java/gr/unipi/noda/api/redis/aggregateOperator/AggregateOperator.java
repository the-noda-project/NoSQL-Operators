package gr.unipi.noda.api.redis.aggregateOperator;

import io.redisearch.aggregation.reducers.Reducer;

public abstract class AggregateOperator extends gr.unipi.noda.api.core.operators.AggregateOperator<Reducer> {

    protected AggregateOperator(String fieldName, String alias) {
        super(fieldName, alias);
    }

    protected abstract Reducer getOperatorField();

    public Reducer getOperatorExpression() {
        return getOperatorField().as(getAlias());
    }

}
