package gr.ds.unipi.noda.api.hbase;

import gr.ds.unipi.noda.api.core.nosqldb.NoSqlDbConnectionManager;
import gr.ds.unipi.noda.api.core.nosqldb.NoSqlDbConnector;
import org.apache.hadoop.hbase.client.Connection;

public final class HBaseConnectionManager extends NoSqlDbConnectionManager<Connection> {

    private static final HBaseConnectionManager INSTANCE = new HBaseConnectionManager();

    private HBaseConnectionManager() {

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
