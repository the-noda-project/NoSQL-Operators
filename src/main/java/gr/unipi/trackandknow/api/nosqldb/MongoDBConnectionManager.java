package gr.unipi.trackandknow.api.nosqldb;

import com.mongodb.MongoClient;

final class MongoDBConnectionManager extends NoSqlDbConnectionManager<MongoClient> {

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
