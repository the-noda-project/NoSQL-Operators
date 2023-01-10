package gr.ds.unipi.noda.api.client.cassandra;

import gr.ds.unipi.noda.api.cassandra.CassandraConnector;
import gr.ds.unipi.noda.api.client.NoSqlDbSystem;

public class CassandraSystem extends NoSqlDbSystem {

    private final CassandraConnector connector;

    @Override
    protected CassandraConnector getConnector() {
        return connector;
    }

    @Override
    public int getDefaultPort() {
        return 5984;
    }

    public static class Builder extends NoSqlDbSystem.Builder<Builder> {
        private final String username;
        private final String password;
        private final String database;

        public Builder(String username, String password, String database) {
            this.username = username;
            this.password = password;
            this.database = database;
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
        super(builder, null);
        connector = CassandraConnector.newCassandraConnector();
    }
}
