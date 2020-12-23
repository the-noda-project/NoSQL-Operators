package gr.ds.unipi.noda.api.hbase.filterOperators.comparisonOperators;

import org.apache.hadoop.hbase.CompareOperator;

import java.util.Date;

final class OperatorNotEqual<T> extends ComparisonOperator<T> {

    private OperatorNotEqual(String fieldName, T fieldValue) {

        super(fieldName, fieldValue);
    }

    @Override
    protected CompareOperator getComparisonExpression() {
        return CompareOperator.NOT_EQUAL;
    }

    public static OperatorNotEqual<Double> newOperatorNotEqual(String fieldName, Double fieldValue) {
        return new OperatorNotEqual(fieldName, fieldValue);
    }

    public static OperatorNotEqual<Integer> newOperatorNotEqual(String fieldName, Integer fieldValue) {
        return new OperatorNotEqual(fieldName, fieldValue);
    }

    public static OperatorNotEqual<Float> newOperatorNotEqual(String fieldName, Float fieldValue) {
        return new OperatorNotEqual(fieldName, fieldValue);
    }

    public static OperatorNotEqual<Short> newOperatorNotEqual(String fieldName, Short fieldValue) {
        return new OperatorNotEqual(fieldName, fieldValue);
    }

    public static OperatorNotEqual<Long> newOperatorNotEqual(String fieldName, Long fieldValue) {
        return new OperatorNotEqual(fieldName, fieldValue);
    }

    public static OperatorNotEqual<Date> newOperatorNotEqual(String fieldName, Date fieldValue) {
        return new OperatorNotEqual(fieldName, fieldValue);
    }

    public static OperatorNotEqual<Boolean> newOperatorNotEqual(String fieldName, Boolean fieldValue) {
        return new OperatorNotEqual(fieldName, fieldValue);
    }

    public static OperatorNotEqual<String> newOperatorNotEqual(String fieldName, String fieldValue) {
        return new OperatorNotEqual(fieldName, fieldValue);
    }

}
