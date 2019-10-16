package gr.ds.unipi.noda.api.redis.aggregateOperator;

import gr.ds.unipi.noda.api.core.constants.Keywords;
import gr.ds.unipi.noda.api.core.constants.StringPool;
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
