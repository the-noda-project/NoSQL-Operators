package gr.ds.unipi.noda.api.parquet;

import gr.ds.unipi.noda.api.core.nosqldb.NoSqlDbConnector;
import gr.ds.unipi.noda.api.core.nosqldb.modifications.FieldValue;
import gr.ds.unipi.noda.api.core.nosqldb.modifications.NoSqlDbUpdates;
import gr.ds.unipi.noda.api.core.operators.filterOperators.FilterOperator;

final class ParquetUpdates extends NoSqlDbUpdates {

    private final ParquetConnectionManager parquetConnectionManager = ParquetConnectionManager.getInstance();

    protected ParquetUpdates(NoSqlDbConnector noSqlDbConnector, String dataCollection) {
        super(noSqlDbConnector, dataCollection);
    }

    @Override
    public NoSqlDbUpdates flush() {
        return null;
    }

    @Override
    public NoSqlDbUpdates update(FilterOperator filterOperator, FieldValue fv, FieldValue... fvs) {
        return null;
    }

    public static ParquetUpdates newParquetUpdate(NoSqlDbConnector noSqlDbConnector, String dataCollection){
        return new ParquetUpdates(noSqlDbConnector, dataCollection);
    }
}
