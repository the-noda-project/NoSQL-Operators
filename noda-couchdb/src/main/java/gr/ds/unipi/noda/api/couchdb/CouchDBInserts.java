package gr.ds.unipi.noda.api.couchdb;

import gr.ds.unipi.noda.api.core.nosqldb.NoSqlDbConnector;
import gr.ds.unipi.noda.api.core.nosqldb.modifications.FieldValue;
import gr.ds.unipi.noda.api.core.nosqldb.modifications.NoSqlDbInserts;

final class CouchDBInserts extends NoSqlDbInserts {
    private final CouchDBConnectionManager couchDBConnectionManager = CouchDBConnectionManager.getInstance();

    private CouchDBInserts(NoSqlDbConnector noSqlDbConnector, String dataCollection) {
        super(noSqlDbConnector, dataCollection);
    }

    public static CouchDBInserts newCouchDbInserts(CouchDBConnector noSqlDbConnector, String dataCollection){
        return new CouchDBInserts(noSqlDbConnector, dataCollection);
    }

    @Override
    public NoSqlDbInserts flush() {
        return null;
    }

    @Override
    public NoSqlDbInserts insert(FieldValue fv, FieldValue... fvs) {
        return null;
    }
}
