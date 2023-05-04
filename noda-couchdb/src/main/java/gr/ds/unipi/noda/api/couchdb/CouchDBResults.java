package gr.ds.unipi.noda.api.couchdb;

import com.google.gson.JsonObject;
import gr.ds.unipi.noda.api.core.nosqldb.NoSqlDbResults;

import java.util.Iterator;

public class CouchDBResults extends NoSqlDbResults<Iterator<JsonObject>> {
    protected CouchDBResults(Iterator<JsonObject> noSqlDbResults) {
        super(noSqlDbResults);
    }

    @Override
    public boolean hasNextRecord() {
        return getNoSqlDbResults().hasNext();
    }

    @Override
    public CouchDBRecord getRecord() {
        return new CouchDBRecord(getNoSqlDbResults().next());
    }

    @Override
    public void close() {

    }
}
