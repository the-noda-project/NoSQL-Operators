package gr.ds.unipi.noda.api.mongo;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import gr.ds.unipi.noda.api.core.nosqldb.NoSqlDbConnector;

import java.util.Objects;

public final class MongoDBConnector implements NoSqlDbConnector<MongoClient> {

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
        return getPort() == that.getPort() &&
                Objects.equals(getHost(), that.getHost()) &&
                Objects.equals(username, that.username) &&
                Objects.equals(password, that.password) &&
                Objects.equals(getDatabase(), that.getDatabase());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getHost(), getPort(), username, password, getDatabase());
    }

    private MongoDBConnector(String host, int port, String username, String password, String database) {
        this.host = host;
        this.port = port;
        this.username = username;
        this.password = password;
        this.database = database;
    }

    @Override
    public MongoClient createConnection() {
        MongoCredential credential = MongoCredential.createCredential(username, getDatabase(), password.toCharArray());
        MongoClientOptions options = MongoClientOptions.builder()/*.sslEnabled(true)*/.build();
        return new MongoClient(new ServerAddress(getHost(), getPort()), credential, options);
    }

    public static MongoDBConnector newMongoDBConnector(String host, int port, String username, String password, String database) {
        return new MongoDBConnector(host, port, username, password, database);
    }

    public String getMongoURIForSparkSession() {
        return "mongodb://" + username + ":" + password + "@" + getHost() + ":" + getPort() + "/" + getDatabase() + ".";
    }

    public String getDatabase() {
        return database;
    }

    public String getHost() {
        return host;
    }

    public int getPort() {
        return port;
    }
}
