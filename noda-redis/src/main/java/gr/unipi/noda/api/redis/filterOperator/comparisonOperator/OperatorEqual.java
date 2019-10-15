package gr.unipi.noda.api.redis.filterOperator.comparisonOperator;

import gr.unipi.noda.api.redis.StringPool;

class OperatorEqual<T> extends ComparisonOperator<T> {

    private OperatorEqual(String fieldName, T fieldValue) {
        super(fieldName, fieldValue, false);
    }

    @Override
    protected String getOperatorField() {
        if(getFieldValue() instanceof String)
            return getFieldValue().toString();
        else
            return StringPool.OPEN_BRACKET + getFieldValue() + StringPool.SPACE + getFieldValue() + StringPool.CLOSE_BRACKET;
    }

    @Override
    protected String getPostOperatorField() {
        return StringPool.DOUBLE_EQUAL;
    }

    public static OperatorEqual<Double> newOperatorEqual(String fieldName, Double fieldValue) {
        return new OperatorEqual<>(fieldName, fieldValue);
    }

    public static OperatorEqual<Integer> newOperatorEqual(String fieldName, Integer fieldValue) {
        return new OperatorEqual<>(fieldName, fieldValue);
    }

    public static OperatorEqual<Float> newOperatorEqual(String fieldName, Float fieldValue) {
        return new OperatorEqual<>(fieldName, fieldValue);
    }

    public static OperatorEqual<Short> newOperatorEqual(String fieldName, Short fieldValue) {
        return new OperatorEqual<>(fieldName, fieldValue);
    }

    public static OperatorEqual<Long> newOperatorEqual(String fieldName, Long fieldValue) {
        return new OperatorEqual<>(fieldName, fieldValue);
    }

    public static OperatorEqual<Boolean> newOperatorEqual(String fieldName, Boolean fieldValue) {
        return new OperatorEqual<>(fieldName, fieldValue);
    }

    public static OperatorEqual<String> newOperatorEqual(String fieldName, String fieldValue) {
        return new OperatorEqual<>(fieldName, fieldValue);
    }

}
