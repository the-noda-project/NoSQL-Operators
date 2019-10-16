package gr.ds.unipi.noda.api.redis.filterOperator.comparisonOperator;

import gr.ds.unipi.noda.api.core.constants.StringPool;

/**
 * @author adimo on 7/10/2019
 */
class OperatorGreaterThanEqual<T> extends ComparisonOperator<T> {
    private OperatorGreaterThanEqual(String fieldName, T fieldValue) {
        super(fieldName, fieldValue);
    }

    @Override
    protected String getOperatorField() {
        return StringPool.OPEN_BRACKET + getFieldValue() + StringPool.SPACE + "+inf" + StringPool.CLOSE_BRACKET;
    }

    @Override
    protected String getPostOperatorField() {
        return StringPool.GREATER_THAN_OR_EQUAL;
    }

    public static OperatorGreaterThanEqual<Double> newOperatorGreaterThanEqual(String fieldName, Double fieldValue) {
        return new OperatorGreaterThanEqual<>(fieldName, fieldValue);
    }

    public static OperatorGreaterThanEqual<Integer> newOperatorGreaterThanEqual(String fieldName, Integer fieldValue) {
        return new OperatorGreaterThanEqual<>(fieldName, fieldValue);
    }

    public static OperatorGreaterThanEqual<Float> newOperatorGreaterThanEqual(String fieldName, Float fieldValue) {
        return new OperatorGreaterThanEqual<>(fieldName, fieldValue);
    }

    public static OperatorGreaterThanEqual<Short> newOperatorGreaterThanEqual(String fieldName, Short fieldValue) {
        return new OperatorGreaterThanEqual<>(fieldName, fieldValue);
    }

    public static OperatorGreaterThanEqual<Long> newOperatorGreaterThanEqual(String fieldName, Long fieldValue) {
        return new OperatorGreaterThanEqual<>(fieldName, fieldValue);
    }
}
