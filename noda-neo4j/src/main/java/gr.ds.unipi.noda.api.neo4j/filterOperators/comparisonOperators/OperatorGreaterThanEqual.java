package gr.ds.unipi.noda.api.neo4j.filterOperators.comparisonOperators;

import java.util.Date;

final class OperatorGreaterThanEqual<T> extends ComparisonOperator<T> {

    private OperatorGreaterThanEqual(String fieldName, T fieldValue) {
        super(fieldName, fieldValue);
    }

    @Override
    protected String getComparisonType() {
        return " >= ";
    }

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
