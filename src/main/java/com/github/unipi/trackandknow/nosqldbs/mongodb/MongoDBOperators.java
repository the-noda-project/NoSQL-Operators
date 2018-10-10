package com.github.unipi.trackandknow.nosqldbs.mongodb;

import com.github.unipi.trackandknow.nosqldbs.NoSqlDbOperators;
import com.mongodb.client.MongoClient;

public class MongoDBOperators<T> implements NoSqlDbOperators<T> {

    private final MongoClient mongoClient;
    private final String collection;

    private MongoDBOperators(MongoClient mongoClient, String collection){
        this.mongoClient = mongoClient;
        this.collection = collection;
    }

    public static MongoDBOperators newMongoDBOperators(MongoClient mongoClient, String collection){
        return new MongoDBOperators(mongoClient, collection);
    }

    @Override
    public T scan(String column) {
        return null;
    }
}
