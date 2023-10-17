package gr.ds.unipi.noda.api.cassandra;

import com.datastax.oss.driver.api.core.CqlSession;
import gr.ds.unipi.noda.api.core.nosqldb.NoSqlDbConnectionManager;
import gr.ds.unipi.noda.api.core.nosqldb.NoSqlDbConnector;

final class CassandraConnectionManager extends NoSqlDbConnectionManager<CqlSession> {

    private static final CassandraConnectionManager INSTANCE = new CassandraConnectionManager();

    private CassandraConnectionManager() {

    }

    public static CassandraConnectionManager getInstance() {
        return INSTANCE;
    }

    @Override
    public boolean closeConnection(NoSqlDbConnector noSqlDbConnector) {
        if (getConnections().containsKey(noSqlDbConnector)) {

            //write the command getConnections().get(noSqlDbConnector) to get the
            //object whose type is defined by the generic parameter of NoSqlDbConnectionManager
            // Get this object in order to close the connection.
            getConnections().get(noSqlDbConnector).execute("DROP TABLE IF EXISTS filteredtable;");
            getConnections().get(noSqlDbConnector).close();
            getConnections().remove(noSqlDbConnector);
        }
        return true;
    }

    @Override
    public boolean closeConnections() {
        getConnections().forEach((k, v) -> {
            //v is an object whose type is defined by the generic parameter of NoSqlDbConnectionManager
            //v should close the database connection.
            v.close();
        });
        getConnections().clear();
        return true;
    }
}
