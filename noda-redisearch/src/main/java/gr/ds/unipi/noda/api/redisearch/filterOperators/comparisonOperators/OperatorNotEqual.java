package gr.ds.unipi.noda.api.redisearch.filterOperators.comparisonOperators;

import gr.ds.unipi.noda.api.core.constants.StringPool;
import io.redisearch.querybuilder.Value;
import io.redisearch.querybuilder.Values;

/**
 * @author adimo on 7/10/2019
 */
final class OperatorNotEqual<T> extends ComparisonOperator<T> {
    private OperatorNotEqual(String fieldName, T fieldValue) {
        super(fieldName, fieldValue, true);
    }

    @Override
    protected Value getOperatorField() {
        if (getFieldValue() instanceof String)
            return Values.value(getFieldValue().toString());
        else if (getFieldValue() instanceof Boolean)
            return Values.tags(Boolean.toString((boolean) (Object) getFieldValue()));
        else
            return Values.eq(Double.parseDouble(getFieldValue().toString()));
    }

    @Override
    protected String getPostOperatorField() {
        return StringPool.NOT_EQUAL;
    }

    static OperatorNotEqual<Double> newOperatorNotEqual(String fieldName, Double fieldValue) {
        return new OperatorNotEqual<>(fieldName, fieldValue);
    }

    static OperatorNotEqual<Integer> newOperatorNotEqual(String fieldName, Integer fieldValue) {
        return new OperatorNotEqual<>(fieldName, fieldValue);
    }

    static OperatorNotEqual<Float> newOperatorNotEqual(String fieldName, Float fieldValue) {
        return new OperatorNotEqual<>(fieldName, fieldValue);
    }

    static OperatorNotEqual<Short> newOperatorNotEqual(String fieldName, Short fieldValue) {
        return new OperatorNotEqual<>(fieldName, fieldValue);
    }

    static OperatorNotEqual<Long> newOperatorNotEqual(String fieldName, Long fieldValue) {
        return new OperatorNotEqual<>(fieldName, fieldValue);
    }

    static OperatorNotEqual<Boolean> newOperatorNotEqual(String fieldName, Boolean fieldValue) {
        return new OperatorNotEqual<>(fieldName, fieldValue);
    }

    static OperatorNotEqual<String> newOperatorNotEqual(String fieldName, String fieldValue) {
        return new OperatorNotEqual<>(fieldName, fieldValue);
    }
}
