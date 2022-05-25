package gr.ds.unipi.noda.api.client.couchdb;

import gr.ds.unipi.noda.api.client.NoSqlDbSystem;
import gr.ds.unipi.noda.api.core.nosqldb.NoSqlDbConnector;

public class CouchDBSystem extends NoSqlDbSystem {

    private final NoSqlDbConnector connector;

    @Override
    protected NoSqlDbConnector getConnector() {
        return connector;
    }

    @Override
    public int getDefaultPort() {
        return 0;
    }

    public static class Builder extends NoSqlDbSystem.Builder<Builder> {

        @Override
        public NoSqlDbSystem build() {
            return new CouchDBSystem(this);
        }

        @Override
        protected Builder self() {
            return this;
        }
    }

    private CouchDBSystem(Builder builder) {
        super(builder, null);
        connector = null;
    }
}
