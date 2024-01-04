package gr.ds.unipi.noda.api.parquet;

import gr.ds.unipi.noda.api.core.nosqldb.NoSqlDbConnector;
import gr.ds.unipi.noda.api.core.nosqldb.modifications.NoSqlDbDeletes;
import gr.ds.unipi.noda.api.core.operators.filterOperators.FilterOperator;

final class ParquetDeletes extends NoSqlDbDeletes {

    private final ParquetConnectionManager parquetConnectionManager = ParquetConnectionManager.getInstance();

    protected ParquetDeletes(NoSqlDbConnector noSqlDbConnector, String dataCollection) {
        super(noSqlDbConnector, dataCollection);
    }

    @Override
    public NoSqlDbDeletes flush() {
        return null;
    }

    @Override
    public NoSqlDbDeletes delete(String... fields) {
        return null;
    }

    @Override
    public NoSqlDbDeletes delete(FilterOperator fop, String... fields) {
        return null;
    }

    public static ParquetDeletes newParquetDelete(NoSqlDbConnector noSqlDbConnector, String dataCollection){
        return new ParquetDeletes(noSqlDbConnector, dataCollection);
    }
}
