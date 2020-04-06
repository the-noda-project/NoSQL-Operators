package gr.ds.unipi.noda.api.redisearch;


import java.util.Set;

public class RediSearchOptions {
    private final int poolSize;
    private final int timeout;
    private final String password;
    private final String master;
    private final Set<String> sentinels;
    private final boolean withSentinels;

    public RediSearchOptions(String master, Set<String> sentinels, int poolSize, int timeout, String password, boolean withSentinels) {
        this.poolSize = poolSize;
        this.timeout = timeout;
        this.password = password;
        this.master = master;
        this.sentinels = sentinels;
        this.withSentinels = withSentinels;
    }

    public static RediSearchOptions createCredential(int poolSize, int timeout, String password) {
        return new RediSearchOptions(null, null, poolSize, timeout, password, false);
    }

    public static RediSearchOptions createCredential(String master, Set<String> sentinels, int poolSize, int timeout, String password) {
        return new RediSearchOptions(master, sentinels, poolSize, timeout, password, true);
    }

    public int getPoolSize() {
        return poolSize;
    }

    public int getTimeout() {
        return timeout;
    }

    public String getPassword() {
        return password;
    }

    public String getMaster() {
        return master;
    }

    public Set<String> getSentinels() {
        return sentinels;
    }

    public boolean isWithSentinels() {
        return withSentinels;
    }
}
