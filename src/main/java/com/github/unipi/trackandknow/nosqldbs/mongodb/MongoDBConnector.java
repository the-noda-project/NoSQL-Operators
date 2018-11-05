package com.github.unipi.trackandknow.nosqldbs.mongodb;

import com.github.unipi.trackandknow.nosqldbs.*;
import com.mongodb.MongoClient;
import com.mongodb.ServerAddress;
import com.mongodb.MongoCredential;
import com.mongodb.MongoClientOptions;
import com.mongodb.client.MongoDatabase;

public final class MongoDBConnector implements NoSqlDbConnector {

    private final MongoClient mongoClient;

    private MongoDBConnector(String host, int port, String username, String password, String database) {

        MongoCredential credential = MongoCredential.createCredential(username, database, password.toCharArray());
        MongoClientOptions options = MongoClientOptions.builder()/*.sslEnabled(true)*/.build();
        mongoClient = new MongoClient(new ServerAddress(host, port), credential, options);

    }

    @Override
    public Object getConnector(){
        return mongoClient;
    }

    public static NoSqlDbConnector newMongoDBConnector(String host, int port, String username, String password, String database) {
        return new MongoDBConnector(host, port, username, password, database);
    }

}
