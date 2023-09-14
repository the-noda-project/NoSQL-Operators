package gr.ds.unipi.noda.api.client.couchdb;

import gr.ds.unipi.noda.api.client.NoSqlDbSystem;
import gr.ds.unipi.noda.api.couchdb.CouchDBConnectionFactory;
import gr.ds.unipi.noda.api.couchdb.CouchDBConnector;

public class CouchDBSystem extends NoSqlDbSystem {

    private final CouchDBConnector connector;

    private CouchDBSystem(Builder builder) {
        super(builder, new CouchDBConnectionFactory());
        connector = CouchDBConnector.newCouchDBConnector(getAddresses(), builder.scheme, builder.username, builder.password, builder.connectTimeout, builder.readTimeout);
    }

    @Override
    protected CouchDBConnector getConnector() {
        return connector;
    }

    @Override
    public int getDefaultPort() {
        return 5984;
    }

    public static class Builder extends NoSqlDbSystem.Builder<Builder> {
        private final String username;
        private final String password;
        private String scheme = "http";
        private int connectTimeout = 10;
        private int readTimeout = 60;

        public Builder(String username, String password) {
            this.username = username;
            this.password = password;
        }

        public Builder scheme(String scheme) {
            this.scheme = scheme;
            return this;
        }

        public Builder connectTimeout(int connectTimeout) {
            this.connectTimeout = connectTimeout;
            return this;
        }

        public Builder readTimeout(int readTimeout) {
            this.readTimeout = readTimeout;
            return this;
        }

        @Override
        public NoSqlDbSystem build() {
            return new CouchDBSystem(this);
        }

        @Override
        protected Builder self() {
            return this;
        }
    }
}
