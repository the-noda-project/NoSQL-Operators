package gr.ds.unipi.noda.api.cassandra.filterOperators.comparisonOperators;

import java.util.Date;

final class OperatorLessThan<T> extends ComparisonOperator<T> {

    @Override
    public StringBuilder getOperatorExpression() {
        StringBuilder operation = new StringBuilder();
        operation.append(getFieldName());
        operation.append("<");
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

    private OperatorLessThan(String fieldName, T fieldValue) {
        super(fieldName, fieldValue);
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
