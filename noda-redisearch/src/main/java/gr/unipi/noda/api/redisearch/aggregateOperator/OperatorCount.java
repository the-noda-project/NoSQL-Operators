package gr.unipi.noda.api.redisearch.aggregateOperator;

import gr.unipi.noda.api.core.nosqldb.Keywords;
import io.redisearch.aggregation.reducers.Reducer;
import io.redisearch.aggregation.reducers.Reducers;

/**
 * @author adimo on 24/9/2019
 */
class OperatorCount extends RediSearchAggregateOperator {

    private OperatorCount(String fieldName) {
        super(fieldName, Keywords.COUNT.toString());
    }

    public static OperatorCount newOperatorCount() {
        return new OperatorCount("");
    }

    @Override
    protected Reducer getOperatorField() {
        return Reducers.count();
    }
}
