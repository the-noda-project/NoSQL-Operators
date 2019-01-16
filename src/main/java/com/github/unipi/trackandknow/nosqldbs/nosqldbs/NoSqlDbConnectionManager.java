package com.github.unipi.trackandknow.nosqldbs.nosqldbs;

import java.util.HashMap;
import java.util.Map;

abstract class NoSqlDbConnectionManager<T> {

    private final Map<NoSqlDbConnector, T> connections;

    protected NoSqlDbConnectionManager() {
        connections = new HashMap<>();
    }

    protected Map<NoSqlDbConnector, T> getConnections() {
        return connections;
    }

    public T getConnection(NoSqlDbConnector noSqlDbConnector) {

        if (connections.containsKey(noSqlDbConnector)) {
            return connections.get(noSqlDbConnector);
        }

        connections.put(noSqlDbConnector, (T) noSqlDbConnector.createConnection());

        return connections.get(noSqlDbConnector);

    }

    public abstract boolean closeConnection(NoSqlDbConnector noSqlDbConnector);

    public abstract boolean closeConnections();


//    protected T addConnection(NoSqlDbConnector noSqlDbConnector,T t){
//        return connections.put(noSqlDbConnector, t);
//    }
//
//    protected boolean containsConnection(NoSqlDbConnector noSqlDbConnector){
//        return connections.containsKey(noSqlDbConnector);
//    }

}
