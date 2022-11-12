package gr.ds.unipi.noda.api.cassandra;

import gr.ds.unipi.noda.api.core.nosqldb.NoSqlDbConnectionManager;
import gr.ds.unipi.noda.api.core.nosqldb.NoSqlDbConnector;

final class CassandraConnectionManager extends NoSqlDbConnectionManager<Object> {

    private static final CassandraConnectionManager INSTANCE = new CassandraConnectionManager();

    private CassandraConnectionManager() {

    }

    public static CassandraConnectionManager getInstance() {
        return INSTANCE;
    }

    @Override
    public boolean closeConnection(NoSqlDbConnector noSqlDbConnector) {
        return false;
    }

    @Override
    public boolean closeConnections() {
        return false;
    }
}
