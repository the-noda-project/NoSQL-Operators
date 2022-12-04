package gr.ds.unipi.noda.api.core.nosqldb.modifications;

import java.util.Date;

public class FieldValue<T> {

    private final String field;
    private final T value;

    private FieldValue(String field, T value){
        this.field = field;
        this.value = value;
    }

    public String getField() {
        return field;
    }

    public T getValue() {
        return value;
    }

    public static FieldValue<Double> newFieldValue(String fieldName, Double fieldValue) {
        return new FieldValue(fieldName, fieldValue);
    }

    public static FieldValue<Integer> newFieldValue(String fieldName, Integer fieldValue) {
        return new FieldValue(fieldName, fieldValue);
    }

    public static FieldValue<Float> newFieldValue(String fieldName, Float fieldValue) {
        return new FieldValue(fieldName, fieldValue);
    }

    public static FieldValue<Short> newFieldValue(String fieldName, Short fieldValue) {
        return new FieldValue(fieldName, fieldValue);
    }

    public static FieldValue<Long> newFieldValue(String fieldName, Long fieldValue) {
        return new FieldValue(fieldName, fieldValue);
    }

    public static FieldValue<Date> newFieldValue(String fieldName, Date fieldValue) {
        return new FieldValue(fieldName, fieldValue);
    }

    public static FieldValue<Boolean> newFieldValue(String fieldName, Boolean fieldValue) {
        return new FieldValue(fieldName, fieldValue);
    }

    public static FieldValue<String> newOFieldValue(String fieldName, String fieldValue) {
        return new FieldValue(fieldName, fieldValue);
    }

    public static FieldValue<Double[]> newFieldValue(String fieldName, Double[] fieldValue) {
        return new FieldValue(fieldName, fieldValue);
    }

    public static FieldValue<Integer[]> newFieldValue(String fieldName, Integer[] fieldValue) {
        return new FieldValue(fieldName, fieldValue);
    }

    public static FieldValue<Float[]> newFieldValue(String fieldName, Float[] fieldValue) {
        return new FieldValue(fieldName, fieldValue);
    }

    public static FieldValue<Short[]> newFieldValue(String fieldName, Short[] fieldValue) {
        return new FieldValue(fieldName, fieldValue);
    }

    public static FieldValue<Long[]> newFieldValue(String fieldName, Long[] fieldValue) {
        return new FieldValue(fieldName, fieldValue);
    }

    public static FieldValue<Date[]> newFieldValue(String fieldName, Date[] fieldValue) {
        return new FieldValue(fieldName, fieldValue);
    }

    public static FieldValue<Boolean[]> newFieldValue(String fieldName, Boolean[] fieldValue) {
        return new FieldValue(fieldName, fieldValue);
    }

    public static FieldValue<String[]> newOFieldValue(String fieldName, String[] fieldValue) {
        return new FieldValue(fieldName, fieldValue);
    }
}
