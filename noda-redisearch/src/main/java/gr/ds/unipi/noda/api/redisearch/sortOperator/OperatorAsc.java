package gr.ds.unipi.noda.api.redisearch.sortOperator;

import gr.ds.unipi.noda.api.core.constants.StringPool;
import io.redisearch.aggregation.SortedField;

class OperatorAsc extends SortOperator {

    private OperatorAsc(String fieldName) {
        super(fieldName, 1);
    }

    @Override
    protected SortedField getOperatorField() {
        return SortedField.asc(StringPool.AT.concat(getFieldName()));
    }

    static OperatorAsc newOperatorAsc(String fieldName) {
        return new OperatorAsc(fieldName);
    }
}
