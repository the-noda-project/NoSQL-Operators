package com.github.unipi.trackandknow.nosqldbs.mongodb;

import com.github.unipi.trackandknow.nosqldbs.NoSqlDbOperators;
import com.github.unipi.trackandknow.nosqldbs.filteroperator.FilterOperator;
import com.mongodb.client.MongoCollection;

import static com.mongodb.client.model.Filters.eq;

public class MongoDBOperators implements NoSqlDbOperators {

    private final MongoCollection mongoCollection;

    private MongoDBOperators(MongoCollection mongoCollection){
        this.mongoCollection = mongoCollection;
    }

    public static MongoDBOperators newMongoDBOperators(MongoCollection mongoCollection){
        return new MongoDBOperators(mongoCollection);
    }

    @Override
    public NoSqlDbOperators filter(FilterOperator filterOperator) {
        filterOperator.getJsonString();
        return this;
    }


}
