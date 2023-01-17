package gr.ds.unipi.noda.api.cassandra;

import com.datastax.oss.driver.api.core.CqlSession;
import com.datastax.oss.driver.api.core.cql.*;
import com.datastax.oss.driver.api.core.auth.ProgrammaticPlainTextAuthProvider;
import gr.ds.unipi.noda.api.core.nosqldb.NoSqlDbConnector;
import java.net.Inet4Address;
import java.net.InetSocketAddress;

public final class CassandraConnector implements NoSqlDbConnector<CqlSession> {

    private final ProgrammaticPlainTextAuthProvider authProvider;
    private final String keyspace;
    private final Inet4Address ipv4;
    private final String datacenter;

    private CassandraConnector(ProgrammaticPlainTextAuthProvider authProvider, String datacenter, String keyspace, Inet4Address ipv4){
        this.authProvider = authProvider;
        this.datacenter = datacenter;
        this.keyspace = keyspace;
        this.ipv4 =ipv4;
    }

    public static CassandraConnector newCassandraConnector(ProgrammaticPlainTextAuthProvider authProvider, String datacenter, String keyspace, Inet4Address ipv4){
        return new CassandraConnector(authProvider, datacenter, keyspace, ipv4);
    }

    @Override
    public CqlSession createConnection() {
        try{
            CqlSession session = CqlSession.builder().withAuthProvider(this.authProvider).withLocalDatacenter(this.datacenter).addContactPoint(new InetSocketAddress(this.ipv4,9042)).build();
            return session;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
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
