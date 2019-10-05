package gr.unipi.noda.api.mongo.filterOperator.comparisonOperator;

import java.util.Date;

public class OperatorEqual<T> extends ComparisonOperator<T> {

    private OperatorEqual(String fieldName, T fieldValue) {

        super(fieldName, fieldValue);
    }

    @Override
    protected String getOperatorJsonField() {
        return "eq";
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
