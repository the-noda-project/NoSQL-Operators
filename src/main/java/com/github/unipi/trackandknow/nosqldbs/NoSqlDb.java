package com.github.unipi.trackandknow.nosqldbs;

import com.github.unipi.trackandknow.nosqldbs.connection.Connector;
import com.github.unipi.trackandknow.nosqldbs.mongodb.MongoDBConnector;
import com.github.unipi.trackandknow.nosqldbs.mongodb.MongoDBOperators;
import com.mongodb.MongoClient;
import com.mongodb.spark.MongoConnector;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public enum NoSqlDb {

    MONGODB{

         private final Map<MongoConnector,MongoClient> connections = new HashMap<>();

        @Override
        public NoSqlDbConnector createNoSqlDbConnector(String host, int port, String username, String password, String database){
            return MongoDBConnector.newMongoDBConnector(host, port, username, password, database);
        }

        @Override
        public NoSqlDbOperators noSqlDbOperators(Connector connector, String s){
            return MongoDBOperators.newMongoDBOperators(MONGODB, connector, s);
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

        @Override
        public boolean hasOpenConnection(Connector connector) {
            return connections.containsKey(connector);
        }

        @Override
        public Object getConnectionOfConnector(Connector connector) {
            return connections.get(connector);
        }

        @Override
        public boolean createConnection(Connector connector) {

            return connections.put(connector,);
        }

        @Override
        public boolean closeConnections() {
            connections.forEach((k,v)->{
                v.close();
            });
            connections.remove()
            return true;
        }

    };

    public abstract NoSqlDbConnector createNoSqlDbConnector(String host, int port, String username, String password, String database);

    public abstract NoSqlDbOperators noSqlDbOperators(Connector connector, String s);

    public abstract void disconnect(Object o);

    public String getDefaultHost(){
        return "localhost";
    }

    public abstract int getDefaultPort();

    public abstract String getDefaultDatabase();

    public abstract String getDefaultUsername();

    public abstract String getDefaultPassword();

    public abstract boolean hasOpenConnection(Connector connector);

    public abstract Object getConnectionOfConnector(Connector connector);

    public abstract boolean createConnection(Connector connector);

    public abstract boolean closeConnections();

}
