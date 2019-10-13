package gr.unipi.noda.api.redisearch;

import gr.unipi.noda.api.core.nosqldb.NoSqlDbConnectionManager;
import gr.unipi.noda.api.core.nosqldb.NoSqlDbConnector;
import io.redisearch.client.Client;

public class RediSearchConnectionManager extends NoSqlDbConnectionManager<Client> {
    private static final RediSearchConnectionManager INSTANCE = new RediSearchConnectionManager();
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

    static RediSearchConnectionManager getInstance() {
        return INSTANCE;
    }
}
