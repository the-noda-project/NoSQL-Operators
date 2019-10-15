package gr.unipi.noda.api.redis.aggregateOperator;

import gr.unipi.noda.api.core.nosqldb.Keywords;
import gr.unipi.noda.api.redis.StringPool;
import io.redisearch.aggregation.reducers.Reducer;
import io.redisearch.aggregation.reducers.Reducers;

class OperatorMin extends AggregateOperator {

    private OperatorMin(String fieldName) {
        super(fieldName, Keywords.MIN.toString().concat(fieldName));
    }

    public static OperatorMin newOperatorMin(String fieldName) {
        return new OperatorMin(fieldName);
    }

    @Override
    protected Reducer getOperatorField() {
        return Reducers.min(StringPool.AT.concat(getFieldName()));
    }
}
