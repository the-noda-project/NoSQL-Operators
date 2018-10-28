package com.github.unipi.trackandknow.nosqldbs;

import com.mongodb.client.model.Filters;
import org.bson.Document;
import org.bson.conversions.Bson;

import static com.mongodb.client.model.Filters.and;

public enum ConditionOperatorType {
    GTE(2), AND(1);

    private final int value;

    private ConditionOperatorType(int value){
        this.value = value;
    }

    public Bson getOperatorForMongoDb(){
        new Document().;
        Bson bson = Filters.and();
        switch (value){
            case 1:
                bson = ;

                break;
            case 2:

                break;
            default:
                bson = null;
        }
        return null;

    }
}
