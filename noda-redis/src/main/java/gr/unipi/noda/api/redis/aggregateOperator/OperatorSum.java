package gr.unipi.noda.api.redis.aggregateOperator;

import gr.unipi.noda.api.core.constants.Keywords;
import gr.unipi.noda.api.core.constants.StringPool;
import io.redisearch.aggregation.reducers.Reducer;
import io.redisearch.aggregation.reducers.Reducers;

class OperatorSum extends AggregateOperator {

    private OperatorSum(String fieldName) {
        super(fieldName, Keywords.SUM.toString().concat(fieldName));
    }

    public static OperatorSum newOperatorSum(String fieldName) {
        return new OperatorSum(fieldName);
    }

    @Override
    protected Reducer getOperatorField() {
        return Reducers.sum(StringPool.AT.concat(getFieldName()));
    }
}
