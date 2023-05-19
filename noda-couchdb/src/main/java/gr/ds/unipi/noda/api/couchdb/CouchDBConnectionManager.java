package gr.ds.unipi.noda.api.couchdb;

import gr.ds.unipi.noda.api.core.nosqldb.NoSqlDbConnectionManager;
import gr.ds.unipi.noda.api.core.nosqldb.NoSqlDbConnector;

final class CouchDBConnectionManager extends NoSqlDbConnectionManager<Connection> {
    private static final CouchDBConnectionManager INSTANCE = new CouchDBConnectionManager();

    private CouchDBConnectionManager() {

    }

    public static CouchDBConnectionManager getInstance() {
        return INSTANCE;
    }

    @Override
    public boolean closeConnection(NoSqlDbConnector noSqlDbConnector) {
        if (getConnections().containsKey(noSqlDbConnector)) {
            getConnections().get(noSqlDbConnector).close();
            getConnections().remove(noSqlDbConnector);
        }
        return true;
    }

    @Override
    public boolean closeConnections() {
        getConnections().forEach((k, v) -> v.close());
        getConnections().clear();
        return true;
    }
}
