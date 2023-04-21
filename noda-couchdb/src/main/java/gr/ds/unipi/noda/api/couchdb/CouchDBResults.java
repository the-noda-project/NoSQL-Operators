package gr.ds.unipi.noda.api.couchdb;

import gr.ds.unipi.noda.api.core.nosqldb.NoSqlDbResults;

import java.util.Iterator;

public class CouchDBResults extends NoSqlDbResults<Iterator<View.Response.Row>> {
    protected CouchDBResults(Iterator<View.Response.Row> noSqlDbResults) {
        super(noSqlDbResults);
    }

    @Override
    public boolean hasNextRecord() {
        return getNoSqlDbResults().hasNext();
    }

    @Override
    public CouchDBRecord getRecord() {
        return new CouchDBRecord(getNoSqlDbResults().next().doc);
    }

    @Override
    public void close() {

    }
}
