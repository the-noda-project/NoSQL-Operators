package gr.ds.unipi.noda.api.parquet.filterOperators.comparisonOperators;

import org.apache.parquet.filter2.predicate.FilterPredicate;
import org.apache.parquet.filter2.predicate.Operators;

import java.util.Date;

import static org.apache.parquet.filter2.predicate.FilterApi.ltEq;

final class OperatorLessThanEqual<T> extends ComparisonOperator<T> {

    private OperatorLessThanEqual(String fieldName, T fieldValue) {
        super(fieldName, fieldValue);
    }

    @Override
    protected <C extends Operators.Column & Operators.SupportsLtGt,V extends Comparable> FilterPredicate getOperator1(C column, V value) {
        return ltEq(column, value);
    }

//    @Override
//    protected <C extends Operators.Column & Operators.SupportsEqNotEq, V extends Comparable> FilterPredicate getOperator2(C column, V value) {
//        return null;
//    }

    public static OperatorLessThanEqual<Double> newOperatorLessThanEqual(String fieldName, Double fieldValue) {
        return new OperatorLessThanEqual(fieldName, fieldValue);
    }

    public static OperatorLessThanEqual<Integer> newOperatorLessThanEqual(String fieldName, Integer fieldValue) {
        return new OperatorLessThanEqual(fieldName, fieldValue);
    }

    public static OperatorLessThanEqual<Float> newOperatorLessThanEqual(String fieldName, Float fieldValue) {
        return new OperatorLessThanEqual(fieldName, fieldValue);
    }

    public static OperatorLessThanEqual<Short> newOperatorLessThanEqual(String fieldName, Short fieldValue) {
        return new OperatorLessThanEqual(fieldName, fieldValue);
    }

    public static OperatorLessThanEqual<Long> newOperatorLessThanEqual(String fieldName, Long fieldValue) {
        return new OperatorLessThanEqual(fieldName, fieldValue);
    }

    public static OperatorLessThanEqual<Date> newOperatorLessThanEqual(String fieldName, Date fieldValue) {
        return new OperatorLessThanEqual(fieldName, fieldValue);
    }

}
