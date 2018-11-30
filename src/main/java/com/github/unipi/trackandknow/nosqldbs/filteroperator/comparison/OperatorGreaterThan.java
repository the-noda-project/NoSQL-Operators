package com.github.unipi.trackandknow.nosqldbs.filteroperator.comparison;

public class OperatorGreaterThan<T extends Number> implements ComparisonOperator<T> {

    private final String fieldName;
    private final T fieldValue;

    @Override
    public String getFieldName() {
        return fieldName;
    }

    @Override
    public T getFieldValue() {
        return fieldValue;
    }

    @Override
    public int getComparisonOperatorId() {
        return 1;
    }

    private OperatorGreaterThan(String fieldName, T fieldValue) {
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;

    }

    public static <T extends Number> OperatorGreaterThan newOperatorGreaterThan(String fieldName, T fieldValue) {
        return new OperatorGreaterThan(fieldName, fieldValue);
    }

//    @Override
//    public StringBuilder getJsonString() {
//
//        StringBuilder sb = new StringBuilder();
//        sb.append("{ ");
//
//        if(!fieldName.contains(".")){
//            sb.append(fieldName);
//        }
//        else{
//            sb.append("\"" + fieldName + "\"");
//        }
//
//        sb.append(": { $gt: ");
//
//        if((fieldValue.getClass() == String.class)){
//            sb.append("\"" + fieldValue + "\"");
//        }
//        else{
//            sb.append(fieldValue);
//        }
//
//        sb.append("} }");
//
//        return sb;
//
////        return "{ " + ((!fieldName.contains(".")) ? fieldName : "\"" + fieldName + "\"") +
////                ": { $gt: " + fieldValue + " } }";
//    }

}
