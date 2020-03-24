package gr.ds.unipi.noda.api.redisearch.aggregateOperator;

import gr.ds.unipi.noda.api.core.constants.AggregationKeywords;
import gr.ds.unipi.noda.api.core.constants.StringPool;
import io.redisearch.aggregation.reducers.Reducer;
import io.redisearch.aggregation.reducers.Reducers;

class OperatorMax extends AggregateOperator {

    private OperatorMax(String fieldName) {
        super(fieldName, AggregationKeywords.MAX.toString().concat(fieldName));
    }

    static OperatorMax newOperatorMax(String fieldName) {
        return new OperatorMax(fieldName);
    }

    @Override
    protected Reducer getOperatorField() {
        return Reducers.max(StringPool.AT.concat(getFieldName()));
    }
}
