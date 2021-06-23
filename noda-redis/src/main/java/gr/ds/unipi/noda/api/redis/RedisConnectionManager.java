package gr.ds.unipi.noda.api.redis;

import gr.ds.unipi.noda.api.core.nosqldb.NoSqlDbConnectionManager;
import gr.ds.unipi.noda.api.core.nosqldb.NoSqlDbConnector;
import redis.clients.jedis.Pipeline;

import java.util.Map;

final class RedisConnectionManager extends NoSqlDbConnectionManager<Map<String, Pipeline>> {

    private static final RedisConnectionManager INSTANCE = new RedisConnectionManager();

    private RedisConnectionManager() {

    }

    @Override
    public boolean closeConnection(NoSqlDbConnector noSqlDbConnector) {
        if (getConnections().containsKey(noSqlDbConnector)) {
            getConnections().get(noSqlDbConnector).forEach((s,k)->k.close());

            ((RedisConnector) noSqlDbConnector).closeConnection();

            getConnections().remove(noSqlDbConnector);
        }
        return true;
    }

    @Override
    public boolean closeConnections() {
        getConnections().forEach((k, v) -> {
            v.forEach((s,p)->p.close());
            ((RedisConnector) k).closeConnection();
        });
        getConnections().clear();
        return true;
    }

    static RedisConnectionManager getInstance() {
        return INSTANCE;
    }



}
