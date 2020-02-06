package gr.ds.unipi.noda.api.neo4j;

import gr.ds.unipi.noda.api.core.nosqldb.NoSqlDbConnector;

import java.util.Objects;

public final class Neo4jConnector implements NoSqlDbConnector<T> {

    private final String host;
    private final int port;
    private final String username;
    private final String password;
    private final String database;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Neo4jConnector that = (Neo4jConnector) o;
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

    private Neo4jConnector(String host, int port, String username, String password, String database) {
        this.host = host;
        this.port = port;
        this.username = username;
        this.password = password;
        this.database = database;
    }

    @Override
    public T createConnection() {
        return T;
    }

    public static Neo4jConnector newNeo4jConnector(String host, int port, String username, String password, String database) {
        return new Neo4jConnector(host, port, username, password, database);
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
