package gr.ds.unipi.noda.api.client.YYYDatabase;

import gr.ds.unipi.noda.api.client.NoSqlDbSys;
import gr.ds.unipi.noda.api.client.mongo.MongoDBSys;
import gr.ds.unipi.noda.api.core.nosqldb.NoSqlConnectionFactory;
import gr.ds.unipi.noda.api.core.nosqldb.NoSqlDbConnector;

public class YYYDatabaseSys extends NoSqlDbSys{

    private final NoSqlDbConnector connector;

    @Override
    protected NoSqlDbConnector getConnector() {
        return connector;
    }

    public static class Builder extends NoSqlDbSys.Builder<Builder>{

        @Override
        public NoSqlDbSys build() {
            return new YYYDatabaseSys(this);
        }

        @Override
        protected Builder self() {
            return this;
        }
    }

    private YYYDatabaseSys(Builder builder) {
        super(builder, null);
        connector = null;
    }
}
