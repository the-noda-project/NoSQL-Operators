package com.github.unipi.trackandknow.nosqldbs.filteroperator.comparison;

import com.github.unipi.trackandknow.nosqldbs.filteroperator.FilterOperator;

public interface ComparisonOperator<T> extends FilterOperator {
    String getFieldName();
    T getFieldValue();
    int getComparisonOperatorId();

    @Override
    default StringBuilder getJsonStringBuilder(){
        return formJsonStringOfComparisonOperator();
    }

    private StringBuilder formJsonStringOfComparisonOperator(){
        StringBuilder sb = new StringBuilder();
        sb.append("{ ");

        if(!getFieldName().contains(".")){
            sb.append(getFieldName());
        }
        else{
            sb.append("\"" + getFieldName() + "\"");
        }


        switch(getComparisonOperatorId()){
            case 0:
                sb.append(": { $eq: ");
                break;
            case 1:
                sb.append(": { $gt: ");
                break;
            case 2:
                sb.append(": { $gte: ");
                break;
            case 3:
                sb.append(": { $lt: ");
                break;
            case 4:
                sb.append(": { $lte: ");
                break;
            case 5:
                sb.append(": { $ne: ");
                break;
        }

        sb.append(": { $eq: ");

        if((getFieldValue().getClass() == String.class)){
            sb.append("\"" + getFieldValue() + "\"");
        }
        else{
            sb.append(getFieldValue());
        }

        sb.append("} }");

        return sb;

    }

}
