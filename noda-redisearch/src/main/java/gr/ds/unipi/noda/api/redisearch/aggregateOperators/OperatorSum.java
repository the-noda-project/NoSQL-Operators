package gr.ds.unipi.noda.api.redisearch.aggregateOperators;

import gr.ds.unipi.noda.api.core.constants.AggregationKeywords;
import gr.ds.unipi.noda.api.core.constants.StringPool;
import io.redisearch.aggregation.reducers.Reducer;
import io.redisearch.aggregation.reducers.Reducers;

final class OperatorSum extends AggregateOperator {

    private OperatorSum(String fieldName) {
        super(fieldName, AggregationKeywords.SUM.toString().concat(fieldName));
    }

    static OperatorSum newOperatorSum(String fieldName) {
        return new OperatorSum(fieldName);
    }

    @Override
    protected Reducer getOperatorField() {
        return Reducers.sum(StringPool.AT.concat(getFieldName()));
    }
}
