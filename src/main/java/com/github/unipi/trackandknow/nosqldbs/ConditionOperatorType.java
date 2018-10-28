package com.github.unipi.trackandknow.nosqldbs;

import com.mongodb.client.model.Filters;
import org.bson.Document;
import org.bson.conversions.Bson;

import static com.mongodb.client.model.Filters.and;

public enum ConditionOperatorType {
    GTE(2), AND(1);

    private final int value;

    ConditionOperatorType(int value){
        this.value = value;
    }

    public String getStringOperatorMongoDb(){

        String operator = null;

        switch (value){
            case 1:
                operator = "$lt";
                break;
            case 2:
                operator = "$lt";
                break;
            default:
                operator = "$lt";
        }

        return operator;

    }
}
