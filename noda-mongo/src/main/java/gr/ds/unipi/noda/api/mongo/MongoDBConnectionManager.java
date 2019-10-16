package gr.ds.unipi.noda.api.mongo;

import com.mongodb.MongoClient;
import gr.ds.unipi.noda.api.core.nosqldb.NoSqlDbConnectionManager;
import gr.ds.unipi.noda.api.core.nosqldb.NoSqlDbConnector;

public final class MongoDBConnectionManager extends NoSqlDbConnectionManager<MongoClient> {

    private static final MongoDBConnectionManager INSTANCE = new MongoDBConnectionManager();

    private MongoDBConnectionManager() {

    }

    public boolean closeConnection(NoSqlDbConnector noSqlDbConnector) {
        if (getConnections().containsKey(noSqlDbConnector)) {
            getConnections().get(noSqlDbConnector).close();
            getConnections().remove(noSqlDbConnector);
        }
        return true;
    }

    public boolean closeConnections() {
        getConnections().forEach((k, v) -> {
            v.close();
        });
        getConnections().clear();
        return true;
    }

    public static MongoDBConnectionManager getInstance() {
        return INSTANCE;
    }

}
