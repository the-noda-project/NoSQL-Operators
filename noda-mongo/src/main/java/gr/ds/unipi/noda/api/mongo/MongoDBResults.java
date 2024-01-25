package gr.ds.unipi.noda.api.mongo;

import com.mongodb.client.MongoCursor;
import gr.ds.unipi.noda.api.core.nosqldb.NoSqlDbRecord;
import gr.ds.unipi.noda.api.core.nosqldb.NoSqlDbResults;
import org.bson.Document;

public class MongoDBResults extends NoSqlDbResults<MongoCursor<Document>> {

    protected MongoDBResults(MongoCursor<Document> batchRecords) {
        super(batchRecords);
    }

    @Override
    public boolean hasNextRecord() {
        return getNoSqlDbResults().hasNext();
    }

    @Override
    public NoSqlDbRecord getRecord() {
        return new MongoDBRecord(getNoSqlDbResults().next());
    }

    @Override
    public void close() {
        getNoSqlDbResults().close();
    }

}
