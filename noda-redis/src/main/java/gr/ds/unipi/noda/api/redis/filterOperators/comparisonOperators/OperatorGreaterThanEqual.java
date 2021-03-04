package gr.ds.unipi.noda.api.redis.filterOperators.comparisonOperators;

import java.util.Date;

public final class OperatorGreaterThanEqual<T> extends ComparisonOperator<T> {

    private OperatorGreaterThanEqual(String fieldName, T fieldValue) {
        super(fieldName, fieldValue);
    }

    @Override
    protected String minumumRangeValue(){
        if(getFieldValue() instanceof Date){
            return String.valueOf(((Date) getFieldValue()).getTime());
        }
        return getFieldValue().toString();
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

    public static OperatorGreaterThanEqual<Long> newOperatorGreaterThanEqual(String fieldName, Date fieldValue) {
        return new OperatorGreaterThanEqual(fieldName, fieldValue.getTime());
    }

}
