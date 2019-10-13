package gr.unipi.noda.api.redisearch.aggregateOperator;

import gr.unipi.noda.api.core.nosqldb.Keywords;
import gr.unipi.noda.api.core.nosqldb.StringPool;
import io.redisearch.aggregation.reducers.Reducer;
import io.redisearch.aggregation.reducers.Reducers;

class OperatorSum extends RediSearchAggregateOperator {

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
