package gr.ds.unipi.noda.api.core.nosqldb;

import java.util.HashMap;
import java.util.Map;

public abstract class NoSqlDbConnectionManager<T> {

    private final Map<NoSqlDbConnector<T>, T> connections;

    protected NoSqlDbConnectionManager() {
        connections = new HashMap<>();
    }

    protected Map<NoSqlDbConnector<T>, T> getConnections() {
        return connections;
    }

    public T getConnection(NoSqlDbConnector<T> noSqlDbConnector) {
        return connections.computeIfAbsent(noSqlDbConnector, NoSqlDbConnector::createConnection);
    }

    public abstract boolean closeConnection(NoSqlDbConnector<T> noSqlDbConnector);

    public abstract boolean closeConnections();

}
