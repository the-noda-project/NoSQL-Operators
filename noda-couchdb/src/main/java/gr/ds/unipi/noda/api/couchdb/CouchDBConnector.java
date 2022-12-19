package gr.ds.unipi.noda.api.couchdb;

import com.google.gson.Gson;
import gr.ds.unipi.noda.api.core.nosqldb.NoSqlDbConnector;
import okhttp3.Credentials;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

public final class CouchDBConnector implements NoSqlDbConnector<CouchDBConnector.CouchDBConnection> {
    private final static MediaType JSON = MediaType.get("application/json; charset=utf-8");
    private final static Gson GSON = new Gson();
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
    public CouchDBConnection createConnection() {
        OkHttpClient client = new OkHttpClient.Builder().authenticator((route, response) -> response.request()
                        .newBuilder()
                        .header("authorization", credentials)
                        .build())
                .connectTimeout(connectTimeout, TimeUnit.SECONDS)
                .readTimeout(readTimeout, TimeUnit.SECONDS)
                .build();
        return new CouchDBConnection(client, serverUrl);
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

    static class CouchDBConnection {
        private final OkHttpClient client;
        private final HttpUrl serverUrl;
        private final Headers headers;

        CouchDBConnection(OkHttpClient client, HttpUrl serverUrl) {
            this.client = client;
            this.serverUrl = serverUrl;
            this.headers = new Headers.Builder().add("accept", "application/json").build();
        }

        public View.Response execute(View view) {
            try {
                // Create or update the internal design document if it doesn't exist
                ensureDesignDocIsUpdated(view);
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }

            HttpUrl url = resolveUrl(view.getDatabase(), "_design", "noda", "_view", view.getName());

            Request request = new Request.Builder().url(url)
                    .headers(headers)
                    .post(RequestBody.create(GSON.toJson(view.getRequestBody()), JSON))
                    .build();

            try (Response res = client.newCall(request).execute()) {
                assert res.body() != null;

                if (res.code() != 200) {
                    System.err.println(res.body().string());
                    return null;
                }

                return GSON.fromJson(res.body().charStream(), View.Response.class);
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
        }

        public void close() {
            client.connectionPool().evictAll();
        }

        private DesignDoc getDesignDoc(String db) throws IOException {
            HttpUrl url = resolveUrl(db, "_design", "noda");

            Request request = new Request.Builder().url(url).headers(headers).get().build();

            try (Response res = client.newCall(request).execute()) {
                if (res.code() != 200) {
                    return null;
                }

                assert res.body() != null;
                return GSON.fromJson(res.body().charStream(), DesignDoc.class);
            }
        }

        private void ensureDesignDocIsUpdated(View view) throws IOException {
            HttpUrl url = resolveUrl(view.getDatabase(), "_design", "noda");

            DesignDoc designDoc = getDesignDoc(view.getDatabase());
            if (designDoc == null) {
                designDoc = DesignDoc.createDesignDoc(view);
            } else if (!designDoc.views.containsKey(view.getName())) {
                designDoc.addView(view);
            } else {
                return;
            }

            Request request = new Request.Builder().url(url)
                    .headers(headers)
                    .put(RequestBody.create(GSON.toJson(designDoc), JSON))
                    .build();

            try (Response res = client.newCall(request).execute()) {
                if (res.code() != 201) {
                    assert res.body() != null;
                    throw new RuntimeException("Failed to create design document. " + res.body().string());
                }
            }
        }

        private HttpUrl resolveUrl(String... paths) {
            HttpUrl.Builder url = serverUrl.newBuilder();
            for (String path : paths) {
                url.addPathSegment(path);
            }
            return url.build();
        }
    }
}
