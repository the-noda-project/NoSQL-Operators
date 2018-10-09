package com.github.unipi.trackandknow.nosqldbs;

import com.github.unipi.trackandknow.nosqldbs.mongodb.MongoDBConnectivity;

public enum NoSqlDb {

    MONGODB{
        @Override
        public NoSqlDbConnectivity noSqlDbConnectivity(String host, int port, String username, String password, String database){
            return MongoDBConnectivity.newMongoDB(host, port, username, password, database).connect();
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

    public abstract NoSqlDbConnectivity noSqlDbConnectivity(String host, int port, String username, String password, String database);

    public String getDefaultHost(){
        return "localhost";
    }

    public abstract int getDefaultPort();

    public abstract String getDefaultDatabase();

    public abstract String getDefaultUsername();

    public abstract String getDefaultPassword();

}
