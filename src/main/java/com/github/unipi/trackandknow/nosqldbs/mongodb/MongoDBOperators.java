package com.github.unipi.trackandknow.nosqldbs.mongodb;

import com.github.unipi.trackandknow.nosqldbs.ConditionOperator;
import com.github.unipi.trackandknow.nosqldbs.ConditionOperatorType;
import com.github.unipi.trackandknow.nosqldbs.NoSqlDbOperators;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.conversions.Bson;
import com.mongodb.client.model.Filters;

import static com.mongodb.client.model.Filters.eq;

public class MongoDBOperators<T> implements NoSqlDbOperators {

    private final MongoCollection mongoCollection;

    private MongoDBOperators(MongoCollection mongoCollection){
        this.mongoCollection = mongoCollection;
    }

    public static MongoDBOperators newMongoDBOperators(MongoCollection mongoCollection){
        return new MongoDBOperators(mongoCollection);
    }

    @Override
    public NoSqlDbOperators filter(ConditionOperator conditionOperator) {
        if (conditionOperator.getConditionOperatorType() == ConditionOperatorType.AND ||
                conditionOperator.getConditionOperatorType() == ConditionOperatorType.AND) {

        }


        ConditionOperatorType conditionOperatorType = conditionOperator.getConditionOperatorType();

        if(conditionOperator.getConditionOperatorChildren() == null){

        }
        else{

        }

        else(){
            conditionOperator.getConditionOperatorType().getOperatorForMongoDb();
        }

        conditionOperator.getConditionOperatorType()
        mongoCollection.find(eq("h", 3)).filter()
    }


}
