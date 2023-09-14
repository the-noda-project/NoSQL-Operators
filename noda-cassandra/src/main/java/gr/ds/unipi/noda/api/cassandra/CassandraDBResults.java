package gr.ds.unipi.noda.api.cassandra;

import com.datastax.oss.driver.api.core.cql.ResultSet;
import gr.ds.unipi.noda.api.core.nosqldb.NoSqlDbRecord;
import gr.ds.unipi.noda.api.core.nosqldb.NoSqlDbResults;

public class CassandraDBResults extends NoSqlDbResults<ResultSet> {

    protected CassandraDBResults(ResultSet resultSet) {
        super(resultSet);
    }

    @Override
    public boolean hasNextRecord() {
        return !(getNoSqlDbResults().getAvailableWithoutFetching() == 0 && getNoSqlDbResults().isFullyFetched());
    }

    @Override
    public NoSqlDbRecord getRecord() {
        return new CassandraDBRecord(this.getNoSqlDbResults().one());
    }

    @Override
    public void close() {

    }
}
