package gr.ds.unipi.noda.api.redis.filterOperator.comparisonOperators;

import java.util.Date;

public final class OperatorLessThanEqual<T> extends ComparisonOperator<T> {

    private OperatorLessThanEqual(String fieldName, T fieldValue) {
        super(fieldName, fieldValue);
    }

    @Override
    protected String maximumRangeValue(){
        if(getFieldValue() instanceof Date){
            return String.valueOf(((Date) getFieldValue()).getTime());
        }
        return getFieldValue().toString();
    }

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

    public static OperatorLessThanEqual<Long> newOperatorLessThanEqual(String fieldName, Date fieldValue) {
        return new OperatorLessThanEqual(fieldName, fieldValue.getTime());
    }

}
