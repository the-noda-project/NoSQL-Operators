package com.github.unipi.trackandknow.nosqldbs.aggregate;

import com.github.unipi.trackandknow.nosqldbs.Operator;

public interface AggregateOperator extends Operator {

    String getFieldName();
    String getAlias();

    AggregateOperator as(String alias);

    int getAggregateOperatorId();

    @Override
    default StringBuilder getJsonStringBuilder(){
        return formJsonStringOfAggregateOperator();
    }

    private StringBuilder formJsonStringOfAggregateOperator(){

        StringBuilder sb = new StringBuilder();
        sb.append(getAlias());

        switch(getAggregateOperatorId()){
            case 0:
                sb.append(": { $max: ");
                break;
        }
        sb.append("\"$");
        sb.append(getFieldName());
        sb.append("\"");
        sb.append(" }");

        return sb;
    }

}
