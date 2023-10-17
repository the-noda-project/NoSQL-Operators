package gr.ds.unipi.noda.api.cassandra.filterOperators.comparisonOperators;

import java.util.Date;

final class OperatorGreaterThanEqual<T> extends ComparisonOperator<T> {

    @Override
    public StringBuilder getOperatorExpression() {
        StringBuilder operation = new StringBuilder();
        operation.append(getFieldName());
        operation.append(">=");
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

    private OperatorGreaterThanEqual(String fieldName, T fieldValue) {
        super(fieldName, fieldValue);
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
