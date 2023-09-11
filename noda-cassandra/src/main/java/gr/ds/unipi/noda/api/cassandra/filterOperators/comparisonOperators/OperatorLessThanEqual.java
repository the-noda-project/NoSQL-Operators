package gr.ds.unipi.noda.api.cassandra.filterOperators.comparisonOperators;

import java.util.Date;

final class OperatorLessThanEqual<T> extends ComparisonOperator<T> {

    @Override
    public StringBuilder getOperatorExpression() {
        StringBuilder operation = new StringBuilder();
        operation.append(getFieldName());
        operation.append("<=");
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

    private OperatorLessThanEqual(String fieldName, T fieldValue) {
        super(fieldName, fieldValue);
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

    public static OperatorLessThanEqual<Date> newOperatorLessThanEqual(String fieldName, Date fieldValue) {
        return new OperatorLessThanEqual(fieldName, fieldValue);
    }

}
