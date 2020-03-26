package gr.ds.unipi.noda.api.redisearch.filterOperators.comparisonOperators;

import gr.ds.unipi.noda.api.core.constants.StringPool;

/**
 * @author adimo on 7/10/2019
 */
final class OperatorLessThanEqual<T> extends ComparisonOperator<T> {
    private OperatorLessThanEqual(String fieldName, T fieldValue) {
        super(fieldName, fieldValue);
    }

    @Override
    protected String getOperatorField() {
        return StringPool.OPEN_BRACKET + "-inf" + StringPool.SPACE + getFieldValue() + StringPool.CLOSE_BRACKET;
    }

    @Override
    protected String getPostOperatorField() {
        return StringPool.LESS_THAN_OR_EQUAL;
    }

    static OperatorLessThanEqual<Double> newOperatorLessThanEqual(String fieldName, Double fieldValue) {
        return new OperatorLessThanEqual<>(fieldName, fieldValue);
    }

    static OperatorLessThanEqual<Integer> newOperatorLessThanEqual(String fieldName, Integer fieldValue) {
        return new OperatorLessThanEqual<>(fieldName, fieldValue);
    }

    static OperatorLessThanEqual<Float> newOperatorLessThanEqual(String fieldName, Float fieldValue) {
        return new OperatorLessThanEqual<>(fieldName, fieldValue);
    }

    static OperatorLessThanEqual<Short> newOperatorLessThanEqual(String fieldName, Short fieldValue) {
        return new OperatorLessThanEqual<>(fieldName, fieldValue);
    }

    static OperatorLessThanEqual<Long> newOperatorLessThanEqual(String fieldName, Long fieldValue) {
        return new OperatorLessThanEqual<>(fieldName, fieldValue);
    }
}
