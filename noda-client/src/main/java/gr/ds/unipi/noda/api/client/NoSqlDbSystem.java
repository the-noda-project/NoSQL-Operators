package gr.ds.unipi.noda.api.client;

import gr.ds.unipi.noda.api.core.nosqldb.NoSqlConnectionFactory;
import gr.ds.unipi.noda.api.core.nosqldb.NoSqlDbConnector;
import gr.ds.unipi.noda.api.core.nosqldb.NoSqlDbOperators;
import org.apache.spark.sql.SparkSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public final class NoSqlDbSystem {

    private static final Logger logger = LoggerFactory.getLogger(NoSqlDbSystem.class);

    public static class Builder {

        private final NoSqlConnectionFactory nsdb;

        private String host;
        private int port;
        private String database; // the name of the database in which the user is defined
        private String username; // the user name
        private String password; // the password as a character array
        private SparkSession sparkSession;

        public Builder(NoSqlConnectionFactory nsdb) {

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

        public Builder sparkSession(SparkSession sparkSession) {
            this.sparkSession = sparkSession;
            return this;
        }

        public NoSqlDbSystem build() {

            return new NoSqlDbSystem(nsdb, nsdb.createNoSqlDbConnector(host, port, username, password, database), sparkSession);
        }

    }

    private final NoSqlConnectionFactory nsdb;
    private final NoSqlDbConnector connector;
    private final SparkSession sparkSession;


    private NoSqlDbSystem(NoSqlConnectionFactory nsdb, NoSqlDbConnector connector, SparkSession sparkSession) {
        this.nsdb = nsdb;
        this.connector = connector;
        this.sparkSession = sparkSession;

    }

    public static Builder MongoDB() {
        NoSqlConnectionFactory noSqlConnectionFactory = null;
        try {
            Class<?> mongoClass = Class.forName("gr.ds.unipi.noda.api.mongo.MongoDBConnectionFactory");
            noSqlConnectionFactory = (NoSqlConnectionFactory) mongoClass.newInstance();
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            logger.error("noda-mongo dependency is missing from the classpath. \n {}", e.toString());
        }

        return new NoSqlDbSystem.Builder(noSqlConnectionFactory);
    }

    public static Builder RediSearch() {
        NoSqlConnectionFactory noSqlConnectionFactory = null;
        try {
            Class<?> rediSearchClass = Class.forName("gr.ds.unipi.noda.api.redisearch.RediSearchConnectionFactory");
            noSqlConnectionFactory = (NoSqlConnectionFactory) rediSearchClass.newInstance();
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            logger.error("noda-redisearch dependency is missing from the classpath. \n {}", e.toString());
        }

        return new NoSqlDbSystem.Builder(noSqlConnectionFactory);
    }

    public static Builder Neo4j() {
        NoSqlConnectionFactory noSqlConnectionFactory = null;
        try {
            Class<?> redisClass = Class.forName("gr.ds.unipi.noda.api.neo4j.Neo4jConnectionFactory");
            noSqlConnectionFactory = (NoSqlConnectionFactory) redisClass.newInstance();
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            logger.error("noda-neo4j dependency is missing from the classpath. \n {}", e.toString());
        }

        return new NoSqlDbSystem.Builder(noSqlConnectionFactory);
    }

    public void closeConnection() {
        nsdb.closeConnection(connector);
    }

    public NoSqlDbOperators operateOn(String s) {
        return nsdb.noSqlDbOperators(connector, s, sparkSession);
    }

    public static Builder builder(NoSqlConnectionFactory dbType) {
        return new NoSqlDbSystem.Builder(dbType);
    }

    public static void closeConnections() {
        toBeCleaned.forEach(NoSqlConnectionFactory::closeConnections);
    }

    private static final List<NoSqlConnectionFactory> toBeCleaned = new ArrayList<>();

    public static void initialize() {
        System.setProperty("spark.mongodb.input.uri", "mongodb://localhost:27017/");
        System.setProperty("spark.mongodb.input.database", "database");
        System.setProperty("spark.mongodb.input.collection", "collection");
        System.setProperty("spark.mongodb.input.partitioner", "MongoSinglePartitioner");
    }

}