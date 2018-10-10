package com.github.unipi.trackandknow.nosqldbs.mongodb;

import com.github.unipi.trackandknow.nosqldbs.NoSqlDbOperators;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoDatabase;

public class MongoDBOperators<T> implements NoSqlDbOperators {

    private final MongoDatabase mongoDatabase;
    private final String collection;

    private MongoDBOperators(MongoDatabase mongoDatabase, String collection){
        this.mongoDatabase = mongoDatabase;
        this.collection = collection;
    }

    public static MongoDBOperators newMongoDBOperators(MongoDatabase mongoDatabase, String collection){
        return new MongoDBOperators(mongoDatabase, collection);
    }

    @Override
    public void scan(String column) {
        System.out.println(mongoDatabase.getCollection(collection).);
    }
}
