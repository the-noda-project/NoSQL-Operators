package com.github.unipi.trackandknow.nosqldbs;

import com.github.unipi.trackandknow.nosqldbs.mongodb.MongoDBConnector;
import com.github.unipi.trackandknow.nosqldbs.mongodb.MongoDBOperators;
import com.mongodb.MongoClient;

import java.util.HashSet;
import java.util.Set;

enum NoSqlDb {

    MONGODB{

         private final Set<String> connections = new HashSet<String>();

        @Override
        public Set<String> connections(){
            return connections;
        }

        @Override
        public NoSqlDbConnector noSqlDbConnector(String host, int port, String username, String password, String database){
            return MongoDBConnector.newMongoDBConnector(host, port, username, password, database);
        }

        @Override
        public NoSqlDbOperators noSqlDbOperators(Object connector, String database, String s){
            return MongoDBOperators.newMongoDBOperators(((MongoClient) connector).getDatabase(database).getCollection(s));
        }

        @Override
        public void disconnect(Object o){
            ((MongoClient) o).close();
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

    public abstract Set<String> connections();

    public abstract NoSqlDbConnector noSqlDbConnector(String host, int port, String username, String password, String database);

    public abstract NoSqlDbOperators noSqlDbOperators(Object connector, String database, String s);

    public abstract void disconnect(Object o);

    public String getDefaultHost(){
        return "localhost";
    }

    public abstract int getDefaultPort();

    public abstract String getDefaultDatabase();

    public abstract String getDefaultUsername();

    public abstract String getDefaultPassword();

}
