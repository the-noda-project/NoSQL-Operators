package gr.ds.unipi.noda.api.redis.filterOperator.comparisonOperator;

import gr.ds.unipi.noda.api.core.constants.StringPool;

/**
 * @author adimo on 7/10/2019
 */
class OperatorNotEqual<T> extends ComparisonOperator<T> {
    private OperatorNotEqual(String fieldName, T fieldValue) {
        super(fieldName, fieldValue, true);
    }

    @Override
    protected String getOperatorField() {
        return StringPool.OPEN_BRACKET + getFieldValue() + StringPool.SPACE + getFieldValue() + StringPool.CLOSE_BRACKET;
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
