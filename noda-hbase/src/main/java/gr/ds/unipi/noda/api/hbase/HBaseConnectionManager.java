package gr.ds.unipi.noda.api.hbase;

import gr.ds.unipi.noda.api.core.nosqldb.NoSqlDbConnectionManager;
import gr.ds.unipi.noda.api.core.nosqldb.NoSqlDbConnector;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.client.Connection;

import java.io.IOException;

final class HBaseConnectionManager extends NoSqlDbConnectionManager<Connection> {

    private static final HBaseConnectionManager INSTANCE = new HBaseConnectionManager();

    private HBaseConnectionManager() {

    }

    @Override
    public boolean closeConnection(NoSqlDbConnector noSqlDbConnector) {
        if (getConnections().containsKey(noSqlDbConnector)) {
            try {
                getConnections().get(noSqlDbConnector).close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            getConnections().remove(noSqlDbConnector);
        }
        return true;
    }

    @Override
    public boolean closeConnections() {
        getConnections().forEach((k, v) -> {
            try {
                v.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        getConnections().clear();
        return true;
    }

    public static HBaseConnectionManager getInstance() {
        return INSTANCE;
    }

    public Configuration getConfiguration(NoSqlDbConnector noSqlDbConnector) {
        return ((HBaseConnector) noSqlDbConnector).getConfiguration();
    }

}
