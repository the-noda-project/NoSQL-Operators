package com.github.unipi.trackandknow.nosqldbs.connection;

import com.github.unipi.trackandknow.nosqldbs.connection.NoSqlDbConnector;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;

import java.util.Objects;

public final class MongoDBConnector extends NoSqlDbConnector {

    private final String host;
    private final int port;
    private final String username;
    private final String password;
    private final String database;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MongoDBConnector that = (MongoDBConnector) o;
        return port == that.port &&
                Objects.equals(host, that.host) &&
                Objects.equals(username, that.username) &&
                Objects.equals(password, that.password) &&
                Objects.equals(database, that.database);
    }

    @Override
    public int hashCode() {
        return Objects.hash(host, port, username, password, database);
    }

    private MongoDBConnector(String host, int port, String username, String password, String database) {
        this.host = host;
        this.port = port;
        this.username = username;
        this.password = password;
        this.database = database;
    }

    @Override
    public Object createConnection(){

        MongoCredential credential = MongoCredential.createCredential(username, database, password.toCharArray());
        MongoClientOptions options = MongoClientOptions.builder()/*.sslEnabled(true)*/.build();
        return new MongoClient(new ServerAddress(host, port), credential, options);
    }

    public static NoSqlDbConnector newMongoDBConnector(String host, int port, String username, String password, String database) {
        return new MongoDBConnector(host, port, username, password, database);
    }

}
