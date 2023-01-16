package gr.ds.unipi.noda.api.cassandra;

import com.datastax.oss.driver.api.core.auth.ProgrammaticPlainTextAuthProvider;
import gr.ds.unipi.noda.api.core.nosqldb.NoSqlDbConnector;
import java.net.Inet4Address;

public final class CassandraConnector implements NoSqlDbConnector<Object> {

    private final ProgrammaticPlainTextAuthProvider authProvider;
    private final String keyspace;
    private final Inet4Address ipv4;

    private CassandraConnector(ProgrammaticPlainTextAuthProvider authProvider, String keyspace, Inet4Address ipv4){
        this.authProvider = authProvider;
        this.keyspace = keyspace;
        this.ipv4 =ipv4;
    }

    public static CassandraConnector newCassandraConnector(ProgrammaticPlainTextAuthProvider authProvider, String keyspace, Inet4Address ipv4){
        return new CassandraConnector(authProvider, keyspace, ipv4);
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
