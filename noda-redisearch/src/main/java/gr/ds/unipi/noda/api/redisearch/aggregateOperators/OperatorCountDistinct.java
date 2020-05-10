package gr.ds.unipi.noda.api.redisearch.aggregateOperators;

import gr.ds.unipi.noda.api.core.constants.AggregationKeywords;
import gr.ds.unipi.noda.api.core.constants.StringPool;
import io.redisearch.aggregation.reducers.Reducer;
import io.redisearch.aggregation.reducers.Reducers;

public class OperatorCountDistinct extends AggregateOperator {
    private OperatorCountDistinct(String fieldName) {
        super(fieldName, AggregationKeywords.COUNT_DISTINCT.toString());
    }

    static OperatorCountDistinct newOperatorCount(String fieldName) {
        return new OperatorCountDistinct(fieldName);
    }

    @Override
    protected Reducer getOperatorField() {
        return Reducers.count_distinct(StringPool.AT.concat(getFieldName()));
    }
}
