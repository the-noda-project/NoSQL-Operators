package gr.ds.unipi.noda.api.client.parquet;

import gr.ds.unipi.noda.api.client.NoSqlDbSystem;
import gr.ds.unipi.noda.api.core.nosqldb.NoSqlDbConnector;
import gr.ds.unipi.noda.api.parquet.ParquetConnectionFactory;
import gr.ds.unipi.noda.api.parquet.ParquetConnector;

public class ParquetSystem extends NoSqlDbSystem {

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
            return new ParquetSystem(this);
        }

        @Override
        protected Builder self() {
            return this;
        }
    }

    private ParquetSystem(Builder builder) {
        super(builder, new ParquetConnectionFactory());
        connector = ParquetConnector.newParquetConnector();
    }
}
