package gr.ds.unipi.noda.api.redis.filterOperator.comparisonOperator;

import gr.ds.unipi.noda.api.core.constants.StringPool;

/**
 * @author adimo on 7/10/2019
 */
class OperatorLessThan<T> extends ComparisonOperator<T> {
    private OperatorLessThan(String fieldName, T fieldValue) {
        super(fieldName, fieldValue);
    }

    @Override
    protected String getOperatorField() {
        return StringPool.OPEN_BRACKET + "-inf" + StringPool.SPACE + StringPool.OPEN_PARENTHESIS + getFieldValue() + StringPool.CLOSE_BRACKET;
    }

    @Override
    protected String getPostOperatorField() {
        return StringPool.LESS_THAN;
    }

    static OperatorLessThan<Double> newOperatorLessThan(String fieldName, Double fieldValue) {
        return new OperatorLessThan<>(fieldName, fieldValue);
    }

    static OperatorLessThan<Integer> newOperatorLessThan(String fieldName, Integer fieldValue) {
        return new OperatorLessThan<>(fieldName, fieldValue);
    }

    static OperatorLessThan<Float> newOperatorLessThan(String fieldName, Float fieldValue) {
        return new OperatorLessThan<>(fieldName, fieldValue);
    }

    static OperatorLessThan<Short> newOperatorLessThan(String fieldName, Short fieldValue) {
        return new OperatorLessThan<>(fieldName, fieldValue);
    }

    static OperatorLessThan<Long> newOperatorLessThan(String fieldName, Long fieldValue) {
        return new OperatorLessThan<>(fieldName, fieldValue);
    }
}
