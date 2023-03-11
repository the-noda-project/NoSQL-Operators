package gr.ds.unipi.noda.api.yyydatabase;

import gr.ds.unipi.noda.api.core.nosqldb.NoSqlDbRecord;
import gr.ds.unipi.noda.api.core.nosqldb.NoSqlDbResults;

public class YYYDataBaseResults extends NoSqlDbResults<Object> {
    protected YYYDataBaseResults(Object noSqlDbResults) {
        super(noSqlDbResults);
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
