package gr.ds.unipi.noda.api.couchdb;

import gr.ds.unipi.noda.api.core.nosqldb.NoSqlDbConnector;
import okhttp3.Credentials;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

public final class CouchDBConnector implements NoSqlDbConnector<Connection> {
    private final HttpUrl serverUrl;
    private final String credentials;
    private final int connectTimeout;
    private final int readTimeout;

    private CouchDBConnector(HttpUrl serverUrl, String credentials, int connectTimeout, int readTimeout) {
        this.serverUrl = serverUrl;
        this.credentials = credentials;
        this.connectTimeout = connectTimeout;
        this.readTimeout = readTimeout;
    }

    public static CouchDBConnector newCouchDBConnector(List<Map.Entry<String, Integer>> addresses, String scheme, String username, String password, int connectTimeout, int readTimeout) {
        String host = addresses.get(0).getKey();
        int port = addresses.get(0).getValue();

        HttpUrl serverUrl = new HttpUrl.Builder().scheme(scheme).host(host).port(port).build();
        String credentials = Credentials.basic(username, password);

        return new CouchDBConnector(serverUrl, credentials, connectTimeout, readTimeout);
    }

    @Override
    public Connection createConnection() {
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(chain -> {
                    Request request = chain.request()
                            .newBuilder()
                            .addHeader("authorization", credentials)
                            .addHeader("accept", "application/json")
                            .build();

                    return chain.proceed(request);
                })
                .connectTimeout(connectTimeout, TimeUnit.SECONDS)
                .readTimeout(readTimeout, TimeUnit.SECONDS)
                .build();

        return new Connection(client, serverUrl);
    }

    @Override
    public int hashCode() {
        return Objects.hash(serverUrl, credentials);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CouchDBConnector connector = (CouchDBConnector) o;
        return Objects.equals(serverUrl, connector.serverUrl) && Objects.equals(credentials, connector.credentials);
    }
}
