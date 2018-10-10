package com.github.unipi.trackandknow.nosqldbs;

import com.github.unipi.trackandknow.nosqldbs.mongodb.MongoDBConnection;
import com.github.unipi.trackandknow.nosqldbs.mongodb.MongoDBOperators;
import com.mongodb.client.MongoClient;

public enum NoSqlDb {

    MONGODB{
        @Override
        public NoSqlDbConnection noSqlDbConnectivity(String host, int port, String username, String password, String database){
            return MongoDBConnection.newMongoDBConnection(host, port, username, password, database);
        }

        @Override
        public NoSqlDbOperators noSqlDbOperators(Object o, String e){
            return MongoDBOperators.newMongoDBOperators((MongoClient) o, e);
        }

        @Override
        public void disconnect(Object t){

        }

        @Override
        public int getDefaultPort(){
            return 27017;
        }

        @Override
        public String getDefaultDatabase(){
            return "";
        }

        @Override
        public String getDefaultUsername(){
            return "";
        }

        @Override
        public String getDefaultPassword(){
            return "";
        }

    };

    public abstract NoSqlDbConnection noSqlDbConnectivity(String host, int port, String username, String password, String database);

    public abstract NoSqlDbOperators noSqlDbOperators(Object t, String e);

    public abstract void disconnect(Object t);

    public String getDefaultHost(){
        return "localhost";
    }

    public abstract int getDefaultPort();

    public abstract String getDefaultDatabase();

    public abstract String getDefaultUsername();

    public abstract String getDefaultPassword();

}
