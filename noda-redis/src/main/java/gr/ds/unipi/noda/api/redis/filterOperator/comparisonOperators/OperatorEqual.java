package gr.ds.unipi.noda.api.redis.filterOperator.comparisonOperators;

import gr.ds.unipi.noda.api.core.operators.Operator;
import gr.ds.unipi.noda.api.redis.filterOperator.Triplet;

import java.util.*;

final class OperatorEqual<T> extends ComparisonOperator<T> {

    private OperatorEqual(String fieldName, T fieldValue) {
        super(fieldName, fieldValue);
    }

    @Override
    public List<Triplet> getOperatorExpression() {
        if(getFieldValue() instanceof String){
            List<Triplet> list = new ArrayList();
            list.add(Triplet.newTriplet("return KEYS[1]\n", new String[]{getFieldName() + ":" + getFieldValue()}, new String[]{}));
            return list;
        }
        return super.getOperatorExpression();
    }

    public static OperatorEqual<Double> newOperatorEqual(String fieldName, Double fieldValue) {
        return new OperatorEqual(fieldName, fieldValue);
    }

    public static OperatorEqual<Integer> newOperatorEqual(String fieldName, Integer fieldValue) {
        return new OperatorEqual(fieldName, fieldValue);
    }

    public static OperatorEqual<Float> newOperatorEqual(String fieldName, Float fieldValue) {
        return new OperatorEqual(fieldName, fieldValue);
    }

    public static OperatorEqual<Short> newOperatorEqual(String fieldName, Short fieldValue) {
        return new OperatorEqual(fieldName, fieldValue);
    }

    public static OperatorEqual<Long> newOperatorEqual(String fieldName, Long fieldValue) {
        return new OperatorEqual(fieldName, fieldValue);
    }

    public static OperatorEqual<Long> newOperatorEqual(String fieldName, Date fieldValue) {
        return new OperatorEqual(fieldName, fieldValue.getTime());
    }

    public static OperatorEqual<Boolean> newOperatorEqual(String fieldName, Boolean fieldValue) {
        return new OperatorEqual(fieldName, fieldValue);
    }

    public static OperatorEqual<String> newOperatorEqual(String fieldName, String fieldValue) {
        return new OperatorEqual(fieldName, fieldValue);
    }

    @Override
    protected String minumumRangeValue(){
        if(getFieldValue() instanceof Date){
            return String.valueOf(((Date) getFieldValue()).getTime());
        }
        return getFieldValue().toString();
    }

    @Override
    protected String maximumRangeValue(){
        return minumumRangeValue();
    }
}
