package gr.ds.unipi.noda.api.cassandra.filterOperators.comparisonOperators;

import java.util.Date;

final class OperatorGreaterThan<T> extends ComparisonOperator<T> {

    @Override
    public StringBuilder getOperatorExpression() {
        StringBuilder operation = new StringBuilder();
        operation.append(getFieldName());
        operation.append(">");
        if (getFieldValue().getClass().getSimpleName().equals("Date")) {
            String stringDate = getFieldValue().toString();
            String year = stringDate.split(" ")[5];
            String month = monthInt.get(stringDate.split(" ")[1]);
            String day = stringDate.split(" ")[2];
            operation.append('\'');
            operation.append(year);
            operation.append('-');
            operation.append(month);
            operation.append('-');
            operation.append(day);
            operation.append('\'');
        } else {
            operation.append(getFieldValue());
        }
        return operation;
    }

    private OperatorGreaterThan(String fieldName, T fieldValue) {
        super(fieldName, fieldValue);
    }

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
