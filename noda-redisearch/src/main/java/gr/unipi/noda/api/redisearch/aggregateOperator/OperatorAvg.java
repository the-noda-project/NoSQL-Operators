package gr.unipi.noda.api.redisearch.aggregateOperator;

import gr.unipi.noda.api.core.nosqldb.Keywords;
import gr.unipi.noda.api.core.nosqldb.StringPool;
import io.redisearch.aggregation.reducers.Reducer;
import io.redisearch.aggregation.reducers.Reducers;

class OperatorAvg extends RediSearchAggregateOperator {

    private OperatorAvg(String fieldName) {
        super(fieldName, Keywords.AVG.toString().concat(fieldName));
    }

    public static OperatorAvg newOperatorAvg(String fieldName) {
        return new OperatorAvg(fieldName);
    }

    @Override
    protected Reducer getOperatorField() {
        return Reducers.avg(StringPool.AT.concat(getFieldName()));
    }
}
