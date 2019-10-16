package gr.ds.unipi.noda.api.redis.aggregateOperator;

import gr.ds.unipi.noda.api.core.constants.Keywords;
import gr.ds.unipi.noda.api.core.constants.StringPool;
import io.redisearch.aggregation.reducers.Reducer;
import io.redisearch.aggregation.reducers.Reducers;

class OperatorMax extends AggregateOperator {

    private OperatorMax(String fieldName) {
        super(fieldName, Keywords.MAX.toString().concat(fieldName));
    }

    public static OperatorMax newOperatorMax(String fieldName) {
        return new OperatorMax(fieldName);
    }

    @Override
    protected Reducer getOperatorField() {
        return Reducers.max(StringPool.AT.concat(getFieldName()));
    }
}
