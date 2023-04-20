package gr.ds.unipi.noda.api.client.cassandra;

import java.net.UnknownHostException;

public class CassandraBuilderFactory {

    public CassandraSystem.Builder Builder(String datacenter, String keyspace) throws UnknownHostException {
        return new CassandraSystem.Builder(datacenter, keyspace);
    }
    public CassandraSystem.Builder Builder(String username, String password, String datacenter, String keyspace) throws UnknownHostException {
        return new CassandraSystem.Builder(username, password, datacenter, keyspace);
    }

    public CassandraSystem.Builder Builder(String appConfigPath){
        return new CassandraSystem.Builder(appConfigPath);
    }

}
