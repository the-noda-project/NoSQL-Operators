package gr.ds.unipi.noda.api.client.cassandra;

import java.net.UnknownHostException;

public class CassandraBuilderFactory {

    public CassandraSystem.Builder Builder(String keyspace) throws UnknownHostException {
        return new CassandraSystem.Builder(keyspace);
    }
    public CassandraSystem.Builder Builder(String username, String password, String keyspace) throws UnknownHostException {
        return new CassandraSystem.Builder(username, password, keyspace);
    }
}
