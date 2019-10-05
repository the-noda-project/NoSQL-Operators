package gr.unipi.noda.api.redis.aggregateOperator;

import io.redisearch.aggregation.reducers.Reducer;
import io.redisearch.aggregation.reducers.Reducers;

public class OperatorAvg extends AggregateOperator {

    private OperatorAvg(String fieldName) {
        super(fieldName, "avg_" + fieldName);
    }

    public static OperatorAvg newOperatorAvg(String fieldName) {
        return new OperatorAvg(fieldName);
    }

    @Override
    protected Reducer getOperatorField() {
        return Reducers.avg(getFieldName());
    }
}
