package com.github.unipi.trackandknow;

import com.mongodb.MongoClient;
import com.mongodb.ServerAddress;
import com.mongodb.MongoCredential;
import com.mongodb.MongoClientOptions;

public final class MongoDB implements NoSqlDbConnectivity {

    private final String username; // the user name
    private final char[] password; // the password as a character array
    private final String database; // the name of the database in which the user is defined
    private final int port;

    private MongoDB(String host, String username, char[] password, String database, int port){
        this.username = username;
        this.password = password;
        this.database = database;
        this.port = port;

        MongoCredential credential = MongoCredential.createCredential(username, database, password);

        MongoClientOptions options = MongoClientOptions.builder().sslEnabled(true).build();

        MongoClient mongoClient = new MongoClient(new ServerAddress("host1", port), credential, options);

    }

    protected void connect(){

    }

    @Override
    public void disconnect() {

    }

    @Override
    public int getDefaultPort() {
        return 27017;
    }

    @Override
    public String getDefaultDatabase() {
        return "";
    }

    @Override
    public String getDefaultUsername() {
        return "";
    }

    @Override
    public String getDefaultPassword() {
        return "";
    }

    public static MongoDB newMongoDB(String username, char[] password, String database, int port){
        return new MongoDB(username, password, database, port);
    }

    public static MongoDB newMongoDB(String username, char[] password, String database){
        return new MongoDB(username, password, database, 27017);
    }




}
