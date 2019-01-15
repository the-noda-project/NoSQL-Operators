package com.github.unipi.trackandknow.nosqldbs.nosqldbs;

import org.apache.spark.sql.SparkSession;

enum NoSqlDb {

    MONGODB {
        @Override
        public NoSqlDbConnector createNoSqlDbConnector(String host, int port, String username, String password, String database) {
            return MongoDBConnector.newMongoDBConnector(host, port, username, password, database);
        }

        @Override
        public NoSqlDbOperators noSqlDbOperators(NoSqlDbConnector connector, String s, SparkSession sparkSession) {
            return MongoDBOperators.newMongoDBOperators((MongoDBConnector) connector, s, sparkSession);
        }

        @Override
        public void closeConnection(NoSqlDbConnector noSqlDbConnector) {
            MongoDBConnectionManager.getInstance().closeConnection(noSqlDbConnector);
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

        @Override
        public boolean closeConnections() {
            return MongoDBConnectionManager.getInstance().closeConnections();
        }
    };

    public abstract NoSqlDbConnector createNoSqlDbConnector(String host, int port, String username, String password, String database);

    public abstract NoSqlDbOperators noSqlDbOperators(NoSqlDbConnector connector, String s, SparkSession sparkSession);

    public abstract void closeConnection(NoSqlDbConnector noSqlDbConnector);

    public String getDefaultHost() {
        return "localhost";
    }

    public abstract int getDefaultPort();

    public abstract String getDefaultDatabase();

    public abstract String getDefaultUsername();

    public abstract String getDefaultPassword();

    public abstract boolean closeConnections();

}
