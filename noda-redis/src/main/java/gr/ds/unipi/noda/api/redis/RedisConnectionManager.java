package gr.ds.unipi.noda.api.redis;

import gr.ds.unipi.noda.api.core.nosqldb.NoSqlDbConnectionManager;
import gr.ds.unipi.noda.api.core.nosqldb.NoSqlDbConnector;
import redis.clients.jedis.JedisPool;

final class RedisConnectionManager extends NoSqlDbConnectionManager<JedisPool> {

    private static final RedisConnectionManager INSTANCE = new RedisConnectionManager();

    private RedisConnectionManager() {

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

    static RedisConnectionManager getInstance() {
        return INSTANCE;
    }



}
