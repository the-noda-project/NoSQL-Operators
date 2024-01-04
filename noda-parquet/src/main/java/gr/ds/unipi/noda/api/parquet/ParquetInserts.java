package gr.ds.unipi.noda.api.parquet;

import gr.ds.unipi.noda.api.core.nosqldb.NoSqlDbConnector;
import gr.ds.unipi.noda.api.core.nosqldb.modifications.FieldValue;
import gr.ds.unipi.noda.api.core.nosqldb.modifications.NoSqlDbInserts;

public final class ParquetInserts extends NoSqlDbInserts {

    private final ParquetConnectionManager parquetConnectionManager = ParquetConnectionManager.getInstance();

    protected ParquetInserts(NoSqlDbConnector noSqlDbConnector, String dataCollection) {
        super(noSqlDbConnector, dataCollection);
    }

    @Override
    public NoSqlDbInserts flush() {
        return null;
    }

    @Override
    public NoSqlDbInserts insert(FieldValue fv, FieldValue... fvs) {
        return null;
    }

    public static ParquetInserts newParquetInsert(NoSqlDbConnector noSqlDbConnector, String dataCollection){
        return new ParquetInserts(noSqlDbConnector, dataCollection);
    }
}
