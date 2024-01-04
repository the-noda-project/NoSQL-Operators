package gr.ds.unipi.noda.api.parquet.filterOperators.comparisonOperators;

import org.apache.parquet.filter2.predicate.FilterPredicate;
import org.apache.parquet.filter2.predicate.Operators;

import java.util.Date;

import static org.apache.parquet.filter2.predicate.FilterApi.gt;

final class OperatorGreaterThan<T> extends ComparisonOperator<T> {

    private OperatorGreaterThan(String fieldName, T fieldValue) {
        super(fieldName, fieldValue);
    }

    @Override
    protected <C extends Operators.Column & Operators.SupportsLtGt,V extends Comparable> FilterPredicate getOperator1(C column, V value) {
        return gt(column, value);
    }

//    @Override
//    protected <C extends Operators.Column & Operators.SupportsEqNotEq, V extends Comparable> FilterPredicate getOperator2(C column, V value) {
//        return null;
//    }

    public static OperatorGreaterThan<Double> newOperatorGreaterThan(String fieldName, Double fieldValue) {
        return new OperatorGreaterThan(fieldName, fieldValue);
    }

    public static OperatorGreaterThan<Integer> newOperatorGreaterThan(String fieldName, Integer fieldValue) {
        return new OperatorGreaterThan(fieldName, fieldValue);
    }

    public static OperatorGreaterThan<Float> newOperatorGreaterThan(String fieldName, Float fieldValue) {
        return new OperatorGreaterThan(fieldName, fieldValue);
    }

    public static OperatorGreaterThan<Short> newOperatorGreaterThan(String fieldName, Short fieldValue) {
        return new OperatorGreaterThan(fieldName, fieldValue);
    }

    public static OperatorGreaterThan<Long> newOperatorGreaterThan(String fieldName, Long fieldValue) {
        return new OperatorGreaterThan(fieldName, fieldValue);
    }

    public static OperatorGreaterThan<Date> newOperatorGreaterThan(String fieldName, Date fieldValue) {
        return new OperatorGreaterThan(fieldName, fieldValue);
    }

}
