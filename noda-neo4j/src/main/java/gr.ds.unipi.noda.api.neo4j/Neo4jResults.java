package gr.ds.unipi.noda.api.neo4j;

import gr.ds.unipi.noda.api.core.nosqldb.NoSqlDbRecord;
import gr.ds.unipi.noda.api.core.nosqldb.NoSqlDbResults;
import org.neo4j.driver.Result;

public class Neo4jResults extends NoSqlDbResults<Result> {

    protected Neo4jResults(Result noSqlDbResults) {
        super(noSqlDbResults);
    }

    @Override
    public boolean hasNextRecord() {
        return getNoSqlDbResults().hasNext();
    }

    @Override
    public NoSqlDbRecord getRecord() {
        return new Neo4jRecord(getNoSqlDbResults().next());
    }

    @Override
    public void close() {

    }
}
