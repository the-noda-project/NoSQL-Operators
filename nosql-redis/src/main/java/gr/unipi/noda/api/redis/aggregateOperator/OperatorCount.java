package gr.unipi.noda.api.redis.aggregateOperator;

import io.redisearch.aggregation.reducers.Reducer;
import io.redisearch.aggregation.reducers.Reducers;

/**
 * @author adimo on 24/9/2019
 */
public class OperatorCount extends AggregateOperator {

    private OperatorCount(String fieldName) {
        super(fieldName, "count");
    }

    public static OperatorCount newOperatorCount() {
        return new OperatorCount("");
    }

    @Override
    protected Reducer getOperatorField() {
        return Reducers.count();
    }
}
