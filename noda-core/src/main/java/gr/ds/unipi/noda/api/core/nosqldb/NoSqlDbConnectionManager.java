package gr.ds.unipi.noda.api.core.nosqldb;

import java.util.HashMap;
import java.util.Map;

public abstract class NoSqlDbConnectionManager<T> {

    private final Map<NoSqlDbConnector, T> connections;

    protected NoSqlDbConnectionManager() {
        connections = new HashMap<>();
    }

    protected Map<NoSqlDbConnector, T> getConnections() {
        return connections;
    }

    public T getConnection(NoSqlDbConnector<T> noSqlDbConnector) {

        if (connections.containsKey(noSqlDbConnector)) {
            return connections.get(noSqlDbConnector);
        }

        connections.put(noSqlDbConnector, noSqlDbConnector.createConnection());

        return connections.get(noSqlDbConnector);

    }

    public abstract boolean closeConnection(NoSqlDbConnector noSqlDbConnector);

    public abstract boolean closeConnections();

}
