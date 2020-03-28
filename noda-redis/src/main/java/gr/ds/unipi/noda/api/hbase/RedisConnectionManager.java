package gr.ds.unipi.noda.api.hbase;

import gr.ds.unipi.noda.api.core.nosqldb.NoSqlDbConnectionManager;
import gr.ds.unipi.noda.api.core.nosqldb.NoSqlDbConnector;

public final class RedisConnectionManager extends NoSqlDbConnectionManager<Object> {

    private static final RedisConnectionManager INSTANCE = new RedisConnectionManager();

    private RedisConnectionManager() {

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
