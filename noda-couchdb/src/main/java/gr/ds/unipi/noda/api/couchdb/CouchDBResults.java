package gr.ds.unipi.noda.api.couchdb;

import gr.ds.unipi.noda.api.core.nosqldb.NoSqlDbResults;

public class CouchDBResults extends NoSqlDbResults<Object> {
    protected CouchDBResults(Object noSqlDbResults) {
        super(noSqlDbResults);
    }

    @Override
    public boolean hasNextRecord() {
        return false;
    }

    @Override
    public CouchDBRecord getRecord() {
        return null;
    }

    @Override
    public void close() {

    }
}
