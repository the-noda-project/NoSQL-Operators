package gr.ds.unipi.noda.api.neo4j.filterOperators.comparisonOperators;

import java.util.Date;

final class OperatorLessThan<T> extends ComparisonOperator<T> {

    private OperatorLessThan(String fieldName, T fieldValue) {

        super(fieldName, fieldValue);
    }

    @Override
    protected String getComparisonType() {
        return " < ";
    }

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
