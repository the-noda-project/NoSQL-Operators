package com.github.unipi.trackandknow;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.ServerAddress;
import com.mongodb.MongoCredential;
import com.mongodb.MongoClientOptions;

import java.util.Arrays;

public final class MongoDB implements DatabaseConnectivity {

    private final String username; // the user name
    private final char[] password; // the password as a character array
    private final String database; // the name of the database in which the user is defined
    private final int port;

    private MongoDB(String username, char[] password, String database, int port){
        this.username = username;
        this.password = password;
        this.database = database;
        this.port = port;

        MongoCredential credential = MongoCredential.createCredential(username, database, password);

        MongoClientOptions options = MongoClientOptions.builder().sslEnabled(true).build();

        MongoClient mongoClient = new MongoClient(new ServerAddress("host1", port), credential, options);

    }

    private void connect(){

    }

    public static MongoDB newMongoDB(String username, char[] password, String database, int port){
        return new MongoDB(username, password, database, port);
    }

    public static MongoDB newMongoDB(String username, char[] password, String database){
        return new MongoDB(username, password, database, 27017);
    }




}
