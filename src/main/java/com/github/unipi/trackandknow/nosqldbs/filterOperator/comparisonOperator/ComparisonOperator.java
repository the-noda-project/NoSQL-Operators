package com.github.unipi.trackandknow.nosqldbs.filterOperator.comparisonOperator;

import com.github.unipi.trackandknow.nosqldbs.filterOperator.FilterOperator;

public abstract class ComparisonOperator<T> implements FilterOperator {

    private final String fieldName;
    private final T fieldValue;

    protected ComparisonOperator(String fieldName, T fieldValue) {
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
    }

    protected abstract String getOperatorJsonField();

    @Override
    public StringBuilder getJsonStringBuilder(){
        StringBuilder sb = new StringBuilder();
        sb.append("{ ");

        if(!getFieldName().contains(".")){
            sb.append(getFieldName());
        }
        else{
            sb.append("\"" + getFieldName() + "\"");
        }

        sb.append(": { $");
        sb.append(getOperatorJsonField());
        sb.append(": ");

        if((getFieldValue().getClass() == String.class)){
            sb.append("\"" + getFieldValue() + "\"");
        }
        else{
            sb.append(getFieldValue());
        }

        sb.append("} }");

        return sb;

    }

//    String getFieldName();
//    T getFieldValue();
//    int getComparisonOperatorId();
//
//    @Override
//    default StringBuilder getJsonStringBuilder(){
//        return formJsonStringOfComparisonOperator();
//    }
//
//    private StringBuilder formJsonStringOfComparisonOperator(){
//        StringBuilder sb = new StringBuilder();
//        sb.append("{ ");
//
//        if(!getFieldName().contains(".")){
//            sb.append(getFieldName());
//        }
//        else{
//            sb.append("\"" + getFieldName() + "\"");
//        }
//
//
//        switch(getComparisonOperatorId()){
//            case 0:
//                sb.append(": { $eq: ");
//                break;
//            case 1:
//                sb.append(": { $gt: ");
//                break;
//            case 2:
//                sb.append(": { $gte: ");
//                break;
//            case 3:
//                sb.append(": { $lt: ");
//                break;
//            case 4:
//                sb.append(": { $lte: ");
//                break;
//            case 5:
//                sb.append(": { $ne: ");
//                break;
//        }
//
//        if((getFieldValue().getClass() == String.class)){
//            sb.append("\"" + getFieldValue() + "\"");
//        }
//        else{
//            sb.append(getFieldValue());
//        }
//
//        sb.append("} }");
//
//        return sb;
//
//    }

    public String getFieldName() {
        return fieldName;
    }

    public T getFieldValue() {
        return fieldValue;
    }
}
