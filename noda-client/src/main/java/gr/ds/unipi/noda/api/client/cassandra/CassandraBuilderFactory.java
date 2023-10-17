package gr.ds.unipi.noda.api.client.cassandra;

public class CassandraBuilderFactory {

    public CassandraSystem.Builder Builder(String appConfigPath) {
        return new CassandraSystem.Builder(appConfigPath);
    }

}
