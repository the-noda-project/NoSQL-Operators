package gr.ds.unipi.noda.api.redis;

import gr.ds.unipi.noda.api.core.nosqldb.NoSqlDbConnectionManager;
import gr.ds.unipi.noda.api.core.nosqldb.NoSqlDbConnector;
import io.redisearch.client.Client;

public class RedisConnectionManager extends NoSqlDbConnectionManager<Client> {
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

    static RedisConnectionManager getInstance() {
        return INSTANCE;
    }
}
