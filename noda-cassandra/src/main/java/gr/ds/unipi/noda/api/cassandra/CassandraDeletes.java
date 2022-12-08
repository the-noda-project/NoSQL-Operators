package gr.ds.unipi.noda.api.cassandra;

import gr.ds.unipi.noda.api.core.nosqldb.NoSqlDbConnector;
import gr.ds.unipi.noda.api.core.nosqldb.modifications.NoSqlDbDeletes;
import gr.ds.unipi.noda.api.core.operators.filterOperators.FilterOperator;

final class CassandraDeletes extends NoSqlDbDeletes {

    private final CassandraConnectionManager cassandraConnectionManager = CassandraConnectionManager.getInstance();

    protected CassandraDeletes(NoSqlDbConnector noSqlDbConnector, String dataCollection) {
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

    public static CassandraDeletes newCassandraDelete(NoSqlDbConnector noSqlDbConnector, String dataCollection){
        return new CassandraDeletes(noSqlDbConnector, dataCollection);
    }
}
