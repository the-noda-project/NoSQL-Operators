package gr.unipi.noda.api.core.nosqldb;

import org.apache.spark.sql.SparkSession;

public interface NoSqlConnectionFactory {
    NoSqlDbConnector createNoSqlDbConnector(String host, int port, String username, String password, String database);

    NoSqlDbOperators noSqlDbOperators(NoSqlDbConnector connector, String s, SparkSession sparkSession);

    void closeConnection(NoSqlDbConnector noSqlDbConnector);

    default String getDefaultHost() {
        return "localhost";
    }

    int getDefaultPort();

    String getDefaultDatabase();

    String getDefaultUsername();

    String getDefaultPassword();

    boolean closeConnections();
}
