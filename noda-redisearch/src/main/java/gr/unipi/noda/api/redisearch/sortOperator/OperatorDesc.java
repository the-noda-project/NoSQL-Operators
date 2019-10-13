package gr.unipi.noda.api.redisearch.sortOperator;

import gr.unipi.noda.api.core.nosqldb.StringPool;
import io.redisearch.aggregation.SortedField;

class OperatorDesc extends RediSearchSortOperator {

    private OperatorDesc(String fieldName) {
        super(fieldName);
    }

    @Override
    protected SortedField getOperatorField() {
        return SortedField.desc(StringPool.AT.concat(getFieldName()));
    }

    public static OperatorDesc newOperatorDesc(String fieldName) {
        return new OperatorDesc(fieldName);
    }

}
