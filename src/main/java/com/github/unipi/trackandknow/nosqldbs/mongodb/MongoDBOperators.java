package com.github.unipi.trackandknow.nosqldbs.mongodb;

import com.github.unipi.trackandknow.nosqldbs.NoSqlDbOperators;

public class MongoDBOperators<T> implements NoSqlDbOperators<T> {

    private final String collection;

    private MongoDBOperators(String collection){
        this.collection = collection;
    }

    public static MongoDBOperators newMongoDBOperators(String collection){
        return new MongoDBOperators(collection);
    }

    @Override
    public T scan(String column) {
        return null;
    }
}
