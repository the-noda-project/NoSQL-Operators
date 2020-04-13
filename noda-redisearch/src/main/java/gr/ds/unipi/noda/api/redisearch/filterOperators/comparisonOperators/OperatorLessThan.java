package gr.ds.unipi.noda.api.redisearch.filterOperators.comparisonOperators;

import gr.ds.unipi.noda.api.core.constants.StringPool;
import io.redisearch.querybuilder.Value;
import io.redisearch.querybuilder.Values;

/**
 * @author adimo on 7/10/2019
 */
final class OperatorLessThan<T> extends ComparisonOperator<T> {
    private OperatorLessThan(String fieldName, T fieldValue) {
        super(fieldName, fieldValue);
    }

    @Override
    protected Value getOperatorField() {
        return Values.lt((double)getFieldValue());
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
