package gr.ds.unipi.noda.api.cassandra.filterOperators.comparisonOperators;

import java.util.Date;

final class OperatorEqual<T> extends ComparisonOperator<T> {


    @Override
    public StringBuilder getOperatorExpression(){
        StringBuilder operation = new StringBuilder();
        operation.append(getFieldName());
        operation.append('=');
        operation.append(getFieldValue());
        return operation;
    }

    private OperatorEqual(String fieldName, T fieldValue) {
        super(fieldName, fieldValue);
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

    public static OperatorEqual<Date> newOperatorEqual(String fieldName, Date fieldValue) {
        return new OperatorEqual(fieldName, fieldValue);
    }

    public static OperatorEqual<Boolean> newOperatorEqual(String fieldName, Boolean fieldValue) {
        return new OperatorEqual(fieldName, fieldValue);
    }

    public static OperatorEqual<String> newOperatorEqual(String fieldName, String fieldValue) {
        return new OperatorEqual(fieldName, fieldValue);
    }

}
