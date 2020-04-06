package gr.ds.unipi.noda.api.hbase;

import gr.ds.unipi.noda.api.core.nosqldb.NoSqlDbConnectionManager;
import gr.ds.unipi.noda.api.core.nosqldb.NoSqlDbConnector;

final class YYYDataBaseConnectionManager extends NoSqlDbConnectionManager<Object> {

    private static final YYYDataBaseConnectionManager INSTANCE = new YYYDataBaseConnectionManager();

    private YYYDataBaseConnectionManager() {

    }

    public static YYYDataBaseConnectionManager getInstance() {
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
