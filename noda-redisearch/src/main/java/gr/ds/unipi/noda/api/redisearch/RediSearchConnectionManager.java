package gr.ds.unipi.noda.api.redisearch;

import gr.ds.unipi.noda.api.core.nosqldb.NoSqlDbConnectionManager;
import gr.ds.unipi.noda.api.core.nosqldb.NoSqlDbConnector;
import redis.clients.jedis.JedisPool;

final class RediSearchConnectionManager extends NoSqlDbConnectionManager<JedisPool> {
    private static final RediSearchConnectionManager INSTANCE = new RediSearchConnectionManager();

    private RediSearchConnectionManager() {
    }

    @Override
    public boolean closeConnection(NoSqlDbConnector noSqlDbConnector) {
        if (getConnections().containsKey(noSqlDbConnector)) {
            getConnections().get(noSqlDbConnector).close();
            getConnections().remove(noSqlDbConnector);
        }
        return true;
    }

    @Override
    public boolean closeConnections() {
        getConnections().forEach((k, v) -> {
            v.close();
        });
        getConnections().clear();
        return true;
    }

    static RediSearchConnectionManager getInstance() {
        return INSTANCE;
    }
}
