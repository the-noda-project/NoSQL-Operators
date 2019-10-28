package gr.ds.unipi.noda.api.redis.aggregateOperator;

import gr.ds.unipi.noda.api.core.constants.Keywords;
import gr.ds.unipi.noda.api.core.constants.StringPool;
import io.redisearch.aggregation.reducers.Reducer;
import io.redisearch.aggregation.reducers.Reducers;

class OperatorAvg extends AggregateOperator {

    private OperatorAvg(String fieldName) {
        super(fieldName, Keywords.AVG.toString().concat(fieldName));
    }

    static OperatorAvg newOperatorAvg(String fieldName) {
        return new OperatorAvg(fieldName);
    }

    @Override
    protected Reducer getOperatorField() {
        return Reducers.avg(StringPool.AT.concat(getFieldName()));
    }
}
