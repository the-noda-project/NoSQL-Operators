package com.github.unipi.trackandknow.nosqldbs.nosqldbs;

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
//    @Override
//    public MongoClient getConnection(NoSqlDbConnector noSqlDbConnector) {
//
//        if (containsConnection(noSqlDbConnector)) {
//            return super.getConnection(noSqlDbConnector);
//        }
//
//        return addConnection(noSqlDbConnector,(MongoClient) noSqlDbConnector.createConnection());
//    }

    public static MongoDBConnectionManager getInstance() {
        return INSTANCE;
    }

}
