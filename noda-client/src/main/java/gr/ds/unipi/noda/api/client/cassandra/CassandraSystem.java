package gr.ds.unipi.noda.api.client.cassandra;

import com.datastax.oss.driver.api.core.auth.ProgrammaticPlainTextAuthProvider;
import gr.ds.unipi.noda.api.cassandra.CassandraConnectionFactory;
import gr.ds.unipi.noda.api.cassandra.CassandraConnector;
import gr.ds.unipi.noda.api.client.NoSqlDbSystem;

import java.net.Inet4Address;
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

    public static class Builder extends NoSqlDbSystem.Builder<Builder> {

        private final ProgrammaticPlainTextAuthProvider authProvider;
        private final String keyspace;
        private Inet4Address ipv4;
        private final String datacenter;
        private final String appConfigPath;

        public Builder(String appConfigPath) {
            this.authProvider = null;
            this.keyspace = "";
            this.ipv4 = null;
            this.datacenter = "";
            this.appConfigPath = appConfigPath;
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
        connector = CassandraConnector.newCassandraConnector(builder.authProvider, builder.datacenter, builder.keyspace, builder.ipv4, builder.appConfigPath);
    }
}
