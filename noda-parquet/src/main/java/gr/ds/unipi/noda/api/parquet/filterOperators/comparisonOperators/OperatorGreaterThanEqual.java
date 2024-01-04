package gr.ds.unipi.noda.api.parquet.filterOperators.comparisonOperators;

import org.apache.parquet.filter2.predicate.FilterPredicate;
import org.apache.parquet.filter2.predicate.Operators;

import java.util.Date;

import static org.apache.parquet.filter2.predicate.FilterApi.gtEq;

final class OperatorGreaterThanEqual<T> extends ComparisonOperator<T> {

    private OperatorGreaterThanEqual(String fieldName, T fieldValue) {
        super(fieldName, fieldValue);
    }

    @Override
    protected <C extends Operators.Column & Operators.SupportsLtGt,V extends Comparable> FilterPredicate getOperator1(C column, V value) {
        return gtEq(column, value);
    }

//    @Override
//    protected <C extends Operators.Column & Operators.SupportsEqNotEq, V extends Comparable> FilterPredicate getOperator2(C column, V value) {
//        return null;
//    }

    public static OperatorGreaterThanEqual<Double> newOperatorGreaterThanEqual(String fieldName, Double fieldValue) {
        return new OperatorGreaterThanEqual(fieldName, fieldValue);
    }

    public static OperatorGreaterThanEqual<Integer> newOperatorGreaterThanEqual(String fieldName, Integer fieldValue) {
        return new OperatorGreaterThanEqual(fieldName, fieldValue);
    }

    public static OperatorGreaterThanEqual<Float> newOperatorGreaterThanEqual(String fieldName, Float fieldValue) {
        return new OperatorGreaterThanEqual(fieldName, fieldValue);
    }

    public static OperatorGreaterThanEqual<Short> newOperatorGreaterThanEqual(String fieldName, Short fieldValue) {
        return new OperatorGreaterThanEqual(fieldName, fieldValue);
    }

    public static OperatorGreaterThanEqual<Long> newOperatorGreaterThanEqual(String fieldName, Long fieldValue) {
        return new OperatorGreaterThanEqual(fieldName, fieldValue);
    }

    public static OperatorGreaterThanEqual<Date> newOperatorGreaterThanEqual(String fieldName, Date fieldValue) {
        return new OperatorGreaterThanEqual(fieldName, fieldValue);
    }

}
