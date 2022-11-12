package gr.ds.unipi.noda.api.cassandra;

import gr.ds.unipi.noda.api.core.nosqldb.NoSqlDbConnector;

import java.util.List;
import java.util.Map;

public final class CassandraConnector implements NoSqlDbConnector<Object> {

    private final List<Map.Entry<String,Integer>> addresses;
    private final String username;
    private final String password;
    private final String database;

    private CassandraConnector(List<Map.Entry<String,Integer>> addresses, String username, String password, String database){
        this.addresses = addresses;
        this.username = username;
        this.password = password;
        this.database = database;
    }

    public static CassandraConnector newCassandraConnector(List<Map.Entry<String,Integer>> addresses, String username, String password, String database) {
        return new CassandraConnector(addresses, username, password, database);
    }


    @Override
    public Object createConnection() {
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
