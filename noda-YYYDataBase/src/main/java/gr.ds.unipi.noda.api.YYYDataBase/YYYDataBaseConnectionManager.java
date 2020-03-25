package gr.ds.unipi.noda.api.YYYDataBase;

import gr.ds.unipi.noda.api.core.nosqldb.NoSqlDbConnectionManager;
import gr.ds.unipi.noda.api.core.nosqldb.NoSqlDbConnector;

public final class YYYDataBaseConnectionManager extends NoSqlDbConnectionManager<Object> {
    @Override
    public boolean closeConnection(NoSqlDbConnector noSqlDbConnector) {
        return false;
    }

    @Override
    public boolean closeConnections() {
        return false;
    }
}
