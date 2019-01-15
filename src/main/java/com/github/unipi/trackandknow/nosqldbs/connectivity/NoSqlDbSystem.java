package com.github.unipi.trackandknow.nosqldbs.connectivity;

import org.apache.spark.sql.SparkSession;

import java.util.ArrayList;
import java.util.List;

public final class NoSqlDbSystem {

    public static class Builder {

        private final NoSqlDb nsdb;

        private String host;
        private int port;
        private String database; // the name of the database in which the user is defined
        private String username; // the user name
        private String password; // the password as a character array
        private SparkSession sparkSession;

        public Builder(NoSqlDb nsdb) {

            this.nsdb = nsdb;
            this.host = nsdb.getDefaultHost();
            this.port = nsdb.getDefaultPort();
            this.database = nsdb.getDefaultDatabase();
            this.username = nsdb.getDefaultUsername();
            this.password = nsdb.getDefaultPassword();
            this.sparkSession = null;
        }

        public Builder host(String host) {
            this.host = host;
            return this;
        }

        public Builder port(int port) {
            this.port = port;
            return this;
        }

        public Builder database(String database) {
            this.database = database;
            return this;
        }

        public Builder username(String username) {
            this.username = username;
            return this;
        }

        public Builder password(String password) {
            this.password = password;
            return this;
        }

        public Builder sparkSession(SparkSession sparkSession){
            this.sparkSession = sparkSession;
            return this;
        }

        public NoSqlDbSystem connect(){

            return new NoSqlDbSystem(nsdb,nsdb.createNoSqlDbConnector(host,port,username,password,database),sparkSession);
            //return new NoSqlDbSystem(nsdb, nsdb.noSqlDbConnector(host, port, username, password, database).getConnector(), database);
        }

    }

    private final NoSqlDb nsdb;
    private final NoSqlDbConnector connector;
    private final SparkSession sparkSession;


    private NoSqlDbSystem(NoSqlDb nsdb, NoSqlDbConnector connector, SparkSession sparkSession){
        this.nsdb = nsdb;
        this.connector = connector;
        this.sparkSession = sparkSession;

    }

    public void closeConnection(){
        nsdb.closeConnection(connector);
    }

    public NoSqlDbOperators operateOn(String s){
        return nsdb.noSqlDbOperators(connector,s,sparkSession);
    }

    public static Builder MongoDB(){
        return new NoSqlDbSystem.Builder(NoSqlDb.MONGODB);
    }

    public static void closeConnections(){
        toBeCleaned.forEach(noSqlDb -> noSqlDb.closeConnections());
    }

    private static final List<NoSqlDb> toBeCleaned = new ArrayList<>();

    public static void initialize(){
        //System.setProperty("spark.mongodb.input.uri", "mongodb://localhost:27017/database.collection");
        System.setProperty("spark.mongodb.input.uri", "mongodb://localhost:27017/");
        System.setProperty("spark.mongodb.input.database", "database");
        System.setProperty("spark.mongodb.input.collection", "collection");
        System.setProperty("spark.mongodb.input.partitioner", "MongoSinglePartitioner");
    }

}
