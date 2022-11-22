package gr.ds.unipi.noda.api.client.yyydatabase;

import gr.ds.unipi.noda.api.client.NoSqlDbSystem;
import gr.ds.unipi.noda.api.core.nosqldb.NoSqlDbConnector;
import gr.ds.unipi.noda.api.yyydatabase.YYYDataBaseConnectionFactory;
import gr.ds.unipi.noda.api.yyydatabase.YYYDataBaseConnector;

public class YYYDatabaseSystem extends NoSqlDbSystem {

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
            return new YYYDatabaseSystem(this);
        }

        @Override
        protected Builder self() {
            return this;
        }
    }

    private YYYDatabaseSystem(Builder builder) {
        super(builder, new YYYDataBaseConnectionFactory());
        connector = YYYDataBaseConnector.newYYYDataBaseConnector();
    }
}
