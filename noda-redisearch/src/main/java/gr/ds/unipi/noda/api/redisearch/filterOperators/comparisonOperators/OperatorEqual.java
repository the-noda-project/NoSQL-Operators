package gr.ds.unipi.noda.api.redisearch.filterOperators.comparisonOperators;

import gr.ds.unipi.noda.api.core.constants.StringPool;
import io.redisearch.querybuilder.Value;
import io.redisearch.querybuilder.Values;

final class OperatorEqual<T> extends ComparisonOperator<T> {

    private OperatorEqual(String fieldName, T fieldValue) {
        super(fieldName, fieldValue, false);
    }

    @Override
    protected Value getOperatorField() {
        if(getFieldValue() instanceof String)
            return Values.value(getFieldValue().toString());
        else if (getFieldValue() instanceof Boolean)
            return Values.tags(Boolean.toString((boolean) getFieldValue()));
        else
            return new RangeValue(Double.parseDouble(getFieldValue().toString()), Double.parseDouble(getFieldValue().toString()));
    }

    @Override
    protected String getPostOperatorField() {
        return StringPool.DOUBLE_EQUAL;
    }

    static OperatorEqual<Double> newOperatorEqual(String fieldName, Double fieldValue) {
        return new OperatorEqual<>(fieldName, fieldValue);
    }

    static OperatorEqual<Integer> newOperatorEqual(String fieldName, Integer fieldValue) {
        return new OperatorEqual<>(fieldName, fieldValue);
    }

    static OperatorEqual<Float> newOperatorEqual(String fieldName, Float fieldValue) {
        return new OperatorEqual<>(fieldName, fieldValue);
    }

    static OperatorEqual<Short> newOperatorEqual(String fieldName, Short fieldValue) {
        return new OperatorEqual<>(fieldName, fieldValue);
    }

    static OperatorEqual<Long> newOperatorEqual(String fieldName, Long fieldValue) {
        return new OperatorEqual<>(fieldName, fieldValue);
    }

    static OperatorEqual<Boolean> newOperatorEqual(String fieldName, Boolean fieldValue) {
        return new OperatorEqual<>(fieldName, fieldValue);
    }

    static OperatorEqual<String> newOperatorEqual(String fieldName, String fieldValue) {
        return new OperatorEqual<>(fieldName, fieldValue);
    }

}
