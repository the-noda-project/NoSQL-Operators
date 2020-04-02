package gr.ds.unipi.noda.api.hbase;

import gr.ds.unipi.noda.api.core.nosqldb.NoSqlDbConnector;
import org.apache.hadoop.hbase.client.Connection;
import org.apache.hadoop.hbase.client.ConnectionFactory;
import org.apache.hadoop.conf.Configuration;


import java.io.IOException;
import java.util.Objects;

public final class HBaseConnector implements NoSqlDbConnector<Connection> {

    private final Configuration conf;

    private HBaseConnector(Configuration conf){
        this.conf = conf;
    }

    @Override
    public Connection createConnection() {
        try {
            return ConnectionFactory.createConnection(this.conf);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HBaseConnector that = (HBaseConnector) o;
        return Objects.equals(conf, that.conf);
    }

    @Override
    public int hashCode() {
        return Objects.hash(conf);
    }

    public static HBaseConnector newHBaseConnector(Configuration conf){
        return new HBaseConnector(conf);
    }
}
