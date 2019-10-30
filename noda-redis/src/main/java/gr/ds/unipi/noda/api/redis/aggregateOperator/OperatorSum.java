package gr.ds.unipi.noda.api.redis.aggregateOperator;

import gr.ds.unipi.noda.api.core.constants.Keywords;
import gr.ds.unipi.noda.api.core.constants.StringPool;
import io.redisearch.aggregation.reducers.Reducer;
import io.redisearch.aggregation.reducers.Reducers;

class OperatorSum extends AggregateOperator {

    private OperatorSum(String fieldName) {
        super(fieldName, Keywords.SUM.toString().concat(fieldName));
    }

    static OperatorSum newOperatorSum(String fieldName) {
        return new OperatorSum(fieldName);
    }

    @Override
    protected Reducer getOperatorField() {
        return Reducers.sum(StringPool.AT.concat(getFieldName()));
    }
}
