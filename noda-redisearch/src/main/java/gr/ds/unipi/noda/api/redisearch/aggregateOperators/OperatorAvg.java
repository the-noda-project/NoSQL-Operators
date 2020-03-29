package gr.ds.unipi.noda.api.redisearch.aggregateOperators;

import gr.ds.unipi.noda.api.core.constants.AggregationKeywords;
import gr.ds.unipi.noda.api.core.constants.StringPool;
import io.redisearch.aggregation.reducers.Reducer;
import io.redisearch.aggregation.reducers.Reducers;

final class OperatorAvg extends AggregateOperator {

    private OperatorAvg(String fieldName) {
        super(fieldName, AggregationKeywords.AVG.toString().concat(fieldName));
    }

    static OperatorAvg newOperatorAvg(String fieldName) {
        return new OperatorAvg(fieldName);
    }

    @Override
    protected Reducer getOperatorField() {
        return Reducers.avg(StringPool.AT.concat(getFieldName()));
    }
}
