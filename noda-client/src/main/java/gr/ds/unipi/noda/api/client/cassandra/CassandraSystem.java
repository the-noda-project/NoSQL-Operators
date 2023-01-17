package gr.ds.unipi.noda.api.client.cassandra;

import gr.ds.unipi.noda.api.cassandra.CassandraConnectionFactory;
import gr.ds.unipi.noda.api.cassandra.CassandraConnector;
import gr.ds.unipi.noda.api.client.NoSqlDbSystem;
import com.datastax.oss.driver.api.core.auth.ProgrammaticPlainTextAuthProvider;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.UnknownHostException;
public class CassandraSystem extends NoSqlDbSystem {

    private final CassandraConnector connector;

    @Override
    protected CassandraConnector getConnector() {
        return connector;
    }

    @Override
    public int getDefaultPort() {
        return 9042;
    }

    public static class Builder extends NoSqlDbSystem.Builder<Builder>{

        private final ProgrammaticPlainTextAuthProvider authProvider;
        private final String keyspace;
        private Inet4Address ipv4;
        public Builder(String keyspace) throws UnknownHostException {
            this.authProvider = new ProgrammaticPlainTextAuthProvider("cassandra","cassandra");
            this.keyspace = keyspace;
            this.ipv4 = (Inet4Address) Inet4Address.getByName("localhost");
        }

        public Builder(String username, String password, String keyspace) throws UnknownHostException {
            this.authProvider = new ProgrammaticPlainTextAuthProvider(username, password);
            this.keyspace = keyspace;
            this.ipv4 = (Inet4Address) Inet4Address.getByName("localhost");
        }

        public Builder ipv4Address(String ipv4) throws UnknownHostException {
            this.ipv4 = (Inet4Address) Inet4Address.getByName(ipv4);
            return this;
        }

        @Override
        public NoSqlDbSystem build() {
            return new CassandraSystem(this);
        }

        @Override
        protected Builder self() {
            return this;
        }
    }

    private CassandraSystem(Builder builder) {
        super(builder, new CassandraConnectionFactory());
        connector = CassandraConnector.newCassandraConnector(builder.authProvider, builder.keyspace, builder.ipv4);
    }
}
