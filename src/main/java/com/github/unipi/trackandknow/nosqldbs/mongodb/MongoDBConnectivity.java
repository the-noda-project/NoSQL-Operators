package com.github.unipi.trackandknow.nosqldbs.mongodb;

import com.github.unipi.trackandknow.nosqldbs.NoSqlDbConnectivity;
import com.github.unipi.trackandknow.nosqldbs.NoSqlDbOperators;
import com.github.unipi.trackandknow.nosqldbs.NoSqlDocumentDbConnectivity;
import com.mongodb.MongoClient;
import com.mongodb.ServerAddress;
import com.mongodb.MongoCredential;
import com.mongodb.MongoClientOptions;

import static com.github.unipi.trackandknow.nosqldbs.mongodb.MongoDBOperators.newMongoDBOperators;

public final class MongoDBConnectivity implements NoSqlDocumentDbConnectivity {

    private MongoDBConnectivity(String host, int port, String username, String password, String database) {

        MongoCredential credential = MongoCredential.createCredential(username, database, password.toCharArray());
        MongoClientOptions options = MongoClientOptions.builder().sslEnabled(true).build();
        MongoClient mongoClient = new MongoClient(new ServerAddress("host1", port), credential, options);
    }

    public MongoDBConnectivity connect() {

        return (NoSqlDbOperators) MongoDBConnectivity.newMongoDB("", "", "", 9).connect();
    }

    public NoSqlDbOperators operateOnCollection(String collection){
        return  MongoDBOperators.newMongoDBOperators("");
    }




    @Override
    public void disconnect() {

    }


    public static NoSqlDbConnectivity newMongoDB(String host, int port, String username, String password, String database) {
        return new MongoDBConnectivity(host, port, username, password, database);
    }


    @Override
    public NoSqlDbOperators operateOnCollection() {
        return null;
    }
}
