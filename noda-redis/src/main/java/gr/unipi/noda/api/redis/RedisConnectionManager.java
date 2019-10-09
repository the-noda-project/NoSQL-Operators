package gr.unipi.noda.api.redis;

import gr.unipi.noda.api.core.nosqldb.NoSqlDbConnectionManager;
import gr.unipi.noda.api.core.nosqldb.NoSqlDbConnector;
import io.redisearch.client.Client;

public final class RedisConnectionManager extends NoSqlDbConnectionManager<Client> {
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
        return false;
    }

    public static RedisConnectionManager getInstance() {
        return INSTANCE;
    }
}
