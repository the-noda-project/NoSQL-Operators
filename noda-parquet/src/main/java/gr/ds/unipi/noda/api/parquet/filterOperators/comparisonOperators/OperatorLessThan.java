package gr.ds.unipi.noda.api.parquet.filterOperators.comparisonOperators;

import org.apache.parquet.filter2.predicate.FilterPredicate;
import org.apache.parquet.filter2.predicate.Operators;

import java.util.Date;

import static org.apache.parquet.filter2.predicate.FilterApi.lt;

final class OperatorLessThan<T> extends ComparisonOperator<T> {

    private OperatorLessThan(String fieldName, T fieldValue) {
        super(fieldName, fieldValue);
    }

    @Override
    protected <C extends Operators.Column & Operators.SupportsLtGt,V extends Comparable> FilterPredicate getOperator1(C column, V value) {
        return lt(column, value);
    }

//    @Override
//    protected <C extends Operators.Column & Operators.SupportsEqNotEq, V extends Comparable> FilterPredicate getOperator2(C column, V value) {
//        return null;
//    }

    public static OperatorLessThan<Double> newOperatorLessThan(String fieldName, Double fieldValue) {
        return new OperatorLessThan(fieldName, fieldValue);
    }

    public static OperatorLessThan<Integer> newOperatorLessThan(String fieldName, Integer fieldValue) {
        return new OperatorLessThan(fieldName, fieldValue);
    }

    public static OperatorLessThan<Float> newOperatorLessThan(String fieldName, Float fieldValue) {
        return new OperatorLessThan(fieldName, fieldValue);
    }

    public static OperatorLessThan<Short> newOperatorLessThan(String fieldName, Short fieldValue) {
        return new OperatorLessThan(fieldName, fieldValue);
    }

    public static OperatorLessThan<Long> newOperatorLessThan(String fieldName, Long fieldValue) {
        return new OperatorLessThan(fieldName, fieldValue);
    }

    public static OperatorLessThan<Date> newOperatorLessThan(String fieldName, Date fieldValue) {
        return new OperatorLessThan(fieldName, fieldValue);
    }

}
