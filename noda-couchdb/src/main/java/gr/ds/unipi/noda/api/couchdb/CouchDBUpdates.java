package gr.ds.unipi.noda.api.couchdb;

import gr.ds.unipi.noda.api.core.nosqldb.NoSqlDbConnector;
import gr.ds.unipi.noda.api.core.nosqldb.modifications.FieldValue;
import gr.ds.unipi.noda.api.core.nosqldb.modifications.NoSqlDbUpdates;
import gr.ds.unipi.noda.api.core.operators.filterOperators.FilterOperator;

final class CouchDBUpdates extends NoSqlDbUpdates {
    private final CouchDBConnectionManager couchDBConnectionManager = CouchDBConnectionManager.getInstance();

    private CouchDBUpdates(NoSqlDbConnector noSqlDbConnector, String dataCollection) {
        super(noSqlDbConnector, dataCollection);
    }

    public static NoSqlDbUpdates newCouchDbUpdates(CouchDBConnector connector, String s) {
        return new CouchDBUpdates(connector, s);
    }

    @Override
    public NoSqlDbUpdates flush() {
        return null;
    }

    @Override
    public NoSqlDbUpdates update(FilterOperator filterOperator, FieldValue fv, FieldValue... fvs) {
        return null;
    }
}
