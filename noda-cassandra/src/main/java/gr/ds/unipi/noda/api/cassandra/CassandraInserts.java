package gr.ds.unipi.noda.api.cassandra;

import gr.ds.unipi.noda.api.core.nosqldb.NoSqlDbConnector;
import gr.ds.unipi.noda.api.core.nosqldb.modifications.FieldValue;
import gr.ds.unipi.noda.api.core.nosqldb.modifications.NoSqlDbInserts;

public final class CassandraInserts extends NoSqlDbInserts {

    private final CassandraConnectionManager cassandraConnectionManager = CassandraConnectionManager.getInstance();

    protected CassandraInserts(NoSqlDbConnector noSqlDbConnector, String dataCollection) {
        super(noSqlDbConnector, dataCollection);
    }

    @Override
    public NoSqlDbInserts flush() {
        return null;
    }

    @Override
    public NoSqlDbInserts insert(FieldValue fv, FieldValue... fvs) {
        return null;
    }

    public static CassandraInserts newCassandraInsert(NoSqlDbConnector noSqlDbConnector, String dataCollection){
        return new CassandraInserts(noSqlDbConnector, dataCollection);
    }
}
