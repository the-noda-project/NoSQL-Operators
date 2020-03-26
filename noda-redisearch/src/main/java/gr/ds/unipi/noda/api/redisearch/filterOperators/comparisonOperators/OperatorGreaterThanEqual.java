package gr.ds.unipi.noda.api.redisearch.filterOperators.comparisonOperators;

import gr.ds.unipi.noda.api.core.constants.StringPool;

/**
 * @author adimo on 7/10/2019
 */
final class OperatorGreaterThanEqual<T> extends ComparisonOperator<T> {
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

    static OperatorGreaterThanEqual<Double> newOperatorGreaterThanEqual(String fieldName, Double fieldValue) {
        return new OperatorGreaterThanEqual<>(fieldName, fieldValue);
    }

    static OperatorGreaterThanEqual<Integer> newOperatorGreaterThanEqual(String fieldName, Integer fieldValue) {
        return new OperatorGreaterThanEqual<>(fieldName, fieldValue);
    }

    static OperatorGreaterThanEqual<Float> newOperatorGreaterThanEqual(String fieldName, Float fieldValue) {
        return new OperatorGreaterThanEqual<>(fieldName, fieldValue);
    }

    static OperatorGreaterThanEqual<Short> newOperatorGreaterThanEqual(String fieldName, Short fieldValue) {
        return new OperatorGreaterThanEqual<>(fieldName, fieldValue);
    }

    static OperatorGreaterThanEqual<Long> newOperatorGreaterThanEqual(String fieldName, Long fieldValue) {
        return new OperatorGreaterThanEqual<>(fieldName, fieldValue);
    }
}
