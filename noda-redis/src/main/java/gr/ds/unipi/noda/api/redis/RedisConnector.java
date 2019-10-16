package gr.ds.unipi.noda.api.redis;

import gr.ds.unipi.noda.api.core.nosqldb.NoSqlDbConnector;
import io.redisearch.client.Client;

public class RedisConnector implements NoSqlDbConnector<Client> {
    private final String host;
    private final int port;
    private final String username;
    private final String password;
    private String indexName;

    private RedisConnector(String host, int port, String username, String password, String indexName) {
        this.host = host;
        this.port = port;
        this.username = username;
        this.password = password;
        this.indexName = indexName;
    }

    @Override
    public Client createConnection() {
        return new Client(indexName, host, port, 500, 100, password);
    }

    static RedisConnector newRedisConnector(String host, int port, String username, String password, String database) {
        return new RedisConnector(host, port, username, password, database);
    }

    void setIndexName(String indexName) {
        this.indexName = indexName;
    }
}
