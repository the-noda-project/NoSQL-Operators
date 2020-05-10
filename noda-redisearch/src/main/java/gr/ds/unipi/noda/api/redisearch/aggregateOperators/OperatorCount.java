package gr.ds.unipi.noda.api.redisearch.aggregateOperators;

import gr.ds.unipi.noda.api.core.constants.AggregationKeywords;
import gr.ds.unipi.noda.api.core.constants.StringPool;
import io.redisearch.aggregation.reducers.Reducer;
import io.redisearch.aggregation.reducers.Reducers;

/**
 * @author adimo on 24/9/2019
 */
final class OperatorCount extends AggregateOperator {

    private OperatorCount(String fieldName) {
        super(fieldName, AggregationKeywords.COUNT.toString());
    }

    static OperatorCount newOperatorCount() {
        return new OperatorCount(StringPool.BLANK);
    }

    @Override
    protected Reducer getOperatorField() {
        return Reducers.count();
    }
}
