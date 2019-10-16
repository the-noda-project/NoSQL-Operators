package gr.ds.unipi.noda.api.redis.filterOperator.comparisonOperator;

import gr.ds.unipi.noda.api.core.constants.StringPool;

/**
 * @author adimo on 7/10/2019
 */
class OperatorGreaterThan<T> extends ComparisonOperator<T> {
    private OperatorGreaterThan(String fieldName, T fieldValue) {
        super(fieldName, fieldValue);
    }

    @Override
    protected String getOperatorField() {
        return StringPool.OPEN_BRACKET + StringPool.OPEN_PARENTHESIS + getFieldValue() + StringPool.SPACE + "+inf" + StringPool.CLOSE_BRACKET;
    }

    @Override
    protected String getPostOperatorField() {
        return StringPool.GREATER_THAN;
    }

    public static OperatorGreaterThan<Double> newOperatorGreaterThan(String fieldName, Double fieldValue) {
        return new OperatorGreaterThan<>(fieldName, fieldValue);
    }

    public static OperatorGreaterThan<Integer> newOperatorGreaterThan(String fieldName, Integer fieldValue) {
        return new OperatorGreaterThan<>(fieldName, fieldValue);
    }

    public static OperatorGreaterThan<Float> newOperatorGreaterThan(String fieldName, Float fieldValue) {
        return new OperatorGreaterThan<>(fieldName, fieldValue);
    }

    public static OperatorGreaterThan<Short> newOperatorGreaterThan(String fieldName, Short fieldValue) {
        return new OperatorGreaterThan<>(fieldName, fieldValue);
    }

    public static OperatorGreaterThan<Long> newOperatorGreaterThan(String fieldName, Long fieldValue) {
        return new OperatorGreaterThan<>(fieldName, fieldValue);
    }
}
