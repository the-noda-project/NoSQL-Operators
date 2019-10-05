package gr.unipi.noda.api.redis;

import gr.unipi.noda.api.core.nosqldb.NoSqlDbConnector;
import io.redisearch.client.Client;

public final class RedisDBConnector implements NoSqlDbConnector<Client> {
    private final String host;
    private final int port;
    private final String username;
    private final String password;
    private String indexName;

    public RedisDBConnector(String host, int port, String username, String password, String indexName) {
        this.host = host;
        this.port = port;
        this.username = username;
        this.password = password;
        this.indexName = indexName;
    }

    @Override
    public Client createConnection() {
        return new Client(indexName, host, port);
    }

    public static RedisDBConnector newRedisDBConnector(String host, int port, String username, String password, String database) {
        return new RedisDBConnector(host, port, username, password, database);
    }

    public void setIndexName(String indexName) {
        this.indexName = indexName;
    }
}
