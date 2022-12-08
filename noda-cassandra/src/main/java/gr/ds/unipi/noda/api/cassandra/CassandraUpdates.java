package gr.ds.unipi.noda.api.cassandra;

import gr.ds.unipi.noda.api.core.nosqldb.NoSqlDbConnector;
import gr.ds.unipi.noda.api.core.nosqldb.modifications.FieldValue;
import gr.ds.unipi.noda.api.core.nosqldb.modifications.NoSqlDbUpdates;
import gr.ds.unipi.noda.api.core.operators.filterOperators.FilterOperator;

final class CassandraUpdates extends NoSqlDbUpdates {

    private final CassandraConnectionManager cassandraConnectionManager = CassandraConnectionManager.getInstance();

    protected CassandraUpdates(NoSqlDbConnector noSqlDbConnector, String dataCollection) {
        super(noSqlDbConnector, dataCollection);
    }

    @Override
    public NoSqlDbUpdates flush() {
        return null;
    }

    @Override
    public NoSqlDbUpdates update(FilterOperator filterOperator, FieldValue fv, FieldValue... fvs) {
        return null;
    }

    public static CassandraUpdates newCassandraUpdate(NoSqlDbConnector noSqlDbConnector, String dataCollection){
        return new CassandraUpdates(noSqlDbConnector, dataCollection);
    }
}
