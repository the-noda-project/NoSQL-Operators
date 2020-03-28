package gr.ds.unipi.noda.api.redis;

import gr.ds.unipi.noda.api.core.nosqldb.NoSqlDbConnector;
import org.apache.hadoop.hbase.client.ConnectionFactory;

public final class HBaseConnector implements NoSqlDbConnector<Object> {
    @Override
    public Object createConnection() {
        return ConnectionFactory.createConnection();
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
