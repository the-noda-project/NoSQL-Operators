package gr.ds.unipi.noda.api.client.cassandra;

public class CassandraBuilderFactory {
    public CassandraSystem.Builder Builder(String username, String password, String database) {
        return new CassandraSystem.Builder(username, password, database);
    }
}
