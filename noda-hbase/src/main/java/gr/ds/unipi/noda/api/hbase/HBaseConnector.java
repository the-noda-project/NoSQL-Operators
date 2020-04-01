package gr.ds.unipi.noda.api.hbase;

import gr.ds.unipi.noda.api.core.nosqldb.NoSqlDbConnector;
import org.apache.hadoop.hbase.client.Connection;
import org.apache.hadoop.hbase.client.ConnectionFactory;

import java.io.IOException;

public final class HBaseConnector implements NoSqlDbConnector<Connection> {
    @Override
    public Connection createConnection() {
        try {
            return ConnectionFactory.createConnection();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int hashCode() {
        return 0;
    }

    @Override
    public boolean equals(Object o) {
        return false;
    }
}
