package gr.unipi.noda.api.redisearch.aggregateOperator;

import gr.unipi.noda.api.core.operators.aggregateOperators.AggregateOperator;
import io.redisearch.aggregation.reducers.Reducer;

abstract class RediSearchAggregateOperator extends AggregateOperator<Reducer> {

    RediSearchAggregateOperator(String fieldName, String alias) {
        super(fieldName, alias);
    }

    protected abstract Reducer getOperatorField();
    public Reducer getOperatorExpression() {
        return getOperatorField().as(getAlias());
    }

}
