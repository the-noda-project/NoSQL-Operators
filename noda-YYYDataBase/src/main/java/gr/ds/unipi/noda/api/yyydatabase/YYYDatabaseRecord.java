package gr.ds.unipi.noda.api.yyydatabase;

import gr.ds.unipi.noda.api.core.nosqldb.NoSqlDbRecord;
import gr.ds.unipi.noda.api.core.nosqldb.NoSqlDbResults;

public class YYYDatabaseRecord extends NoSqlDbResults<Object> {
    protected YYYDatabaseRecord(Object batchRecords) {
        super(batchRecords);
    }

    @Override
    public boolean hasNextRecord() {
        return false;
    }

    @Override
    public NoSqlDbRecord getRecord() {
        return null;
    }

    @Override
    public void close() {

    }
}
