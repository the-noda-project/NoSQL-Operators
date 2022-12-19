package gr.ds.unipi.noda.api.couchdb;

import gr.ds.unipi.noda.api.core.nosqldb.NoSqlDbConnector;
import gr.ds.unipi.noda.api.core.nosqldb.modifications.NoSqlDbDeletes;
import gr.ds.unipi.noda.api.core.operators.filterOperators.FilterOperator;

final class CouchDBDeletes extends NoSqlDbDeletes {
    private final CouchDBConnectionManager couchDBConnectionManager = CouchDBConnectionManager.getInstance();

    private CouchDBDeletes(NoSqlDbConnector noSqlDbConnector, String dataCollection) {
        super(noSqlDbConnector, dataCollection);
    }

    public static NoSqlDbDeletes newCouchDbDeletes(CouchDBConnector connector, String s) {
        return new CouchDBDeletes(connector, s);
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
}
