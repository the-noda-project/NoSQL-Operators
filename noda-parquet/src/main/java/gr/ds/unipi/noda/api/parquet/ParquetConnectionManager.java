package gr.ds.unipi.noda.api.parquet;

import gr.ds.unipi.noda.api.core.nosqldb.NoSqlDbConnectionManager;
import gr.ds.unipi.noda.api.core.nosqldb.NoSqlDbConnector;

final class ParquetConnectionManager extends NoSqlDbConnectionManager<Object> {

    private static final ParquetConnectionManager INSTANCE = new ParquetConnectionManager();

    private ParquetConnectionManager() {

    }

    public static ParquetConnectionManager getInstance() {
        return INSTANCE;
    }

    @Override
    public boolean closeConnection(NoSqlDbConnector noSqlDbConnector) {
        if (getConnections().containsKey(noSqlDbConnector)) {

            //write the command getConnections().get(noSqlDbConnector) to get the
            //object whose type is defined by the generic parameter of NoSqlDbConnectionManager
            // Get this object in order to close the connection.

            getConnections().remove(noSqlDbConnector);
        }
        return true;
    }

    @Override
    public boolean closeConnections() {
        getConnections().forEach((k, v) -> {

            //v is an object whose type is defined by the generic parameter of NoSqlDbConnectionManager
            //v should close the database connection.

        });
        getConnections().clear();
        return true;
    }
}
