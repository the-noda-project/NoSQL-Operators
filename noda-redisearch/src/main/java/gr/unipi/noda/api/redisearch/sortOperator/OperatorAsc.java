package gr.unipi.noda.api.redisearch.sortOperator;

import gr.unipi.noda.api.core.nosqldb.StringPool;
import io.redisearch.aggregation.SortedField;

class OperatorAsc extends RediSearchSortOperator {

    private OperatorAsc(String fieldName) {
        super(fieldName);
    }

    @Override
    protected SortedField getOperatorField() {
        return SortedField.asc(StringPool.AT.concat(getFieldName()));
    }

    public static OperatorAsc newOperatorAsc(String fieldName) {
        return new OperatorAsc(fieldName);
    }
}
