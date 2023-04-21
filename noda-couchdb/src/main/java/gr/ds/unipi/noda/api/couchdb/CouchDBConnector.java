package gr.ds.unipi.noda.api.couchdb;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import gr.ds.unipi.noda.api.core.nosqldb.NoSqlDbConnector;
import okhttp3.Call;
import okhttp3.Credentials;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

public final class CouchDBConnector implements NoSqlDbConnector<CouchDBConnector.Connection> {
    private final static MediaType JSON = MediaType.get("application/json; charset=utf-8");
    private final static Gson GSON = new GsonBuilder().create();
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

    static class Connection {
        /**
         * The name of the internal CouchDB Design Document.
         */
        private final static String DESIGN_DOC = "noda";
        private final OkHttpClient client;
        private final HttpUrl serverUrl;

        Connection(OkHttpClient client, HttpUrl serverUrl) {
            this.client = client;
            this.serverUrl = serverUrl;
        }

        public View.Response allDocs(String db) throws IOException {
            try (Response res = post(db + "/_all_docs", Collections.singletonMap("include_docs", true)).execute()) {
                assert res.body() != null;
                return GSON.fromJson(res.body().charStream(), View.Response.class);
            }
        }

        public void bulkDocs(String db, List<JsonObject> docs) throws IOException {
            try (Response res = post(db + "/_bulk_docs", Collections.singletonMap("docs", docs)).execute()) {
                if (!res.isSuccessful()) {
                    assert res.body() != null;
                    System.err.println(res.body().string());
                }
            }
        }

        public View.Response execute(View view) throws IOException {
            // Create or update the internal design document if it doesn't exist
            ensureDesignDocIsUpdated(view);

            String path = view.getDatabase() + "/_design/" + DESIGN_DOC + "/_view/" + view.getName();
            try (Response res = post(path, view.getRequestBody()).execute()) {
                assert res.body() != null;

                if (!res.isSuccessful()) {
                    System.err.println(res.body().string());
                    return null;
                }

                return GSON.fromJson(res.body().charStream(), View.Response.class);
            }
        }

        public void close() {
            client.connectionPool().evictAll();
        }

        private void ensureDesignDocIsUpdated(View view) throws IOException {
            String path = view.getDatabase() + "/_design/" + DESIGN_DOC;
            DesignDoc designDoc;

            try (Response res = get(path).execute()) {
                if (res.code() == 404) {
                    // Create the new Design Document if not found...
                    designDoc = new DesignDoc();
                } else if (res.isSuccessful()) {
                    assert res.body() != null;
                    designDoc = GSON.fromJson(res.body().charStream(), DesignDoc.class);
                } else {
                    throw new IOException("Could not create internal CouchDB Design Document");
                }

                // ...skip if the view exists...
                if (designDoc.hasView(view)) {
                    return;
                }
            }

            /// ...or update the Design Document with the new view
            designDoc.addView(view);
            try (Response res = put(path, designDoc).execute()) {
                if (!res.isSuccessful()) {
                    assert res.body() != null;
                    System.err.println(res.body().string());
                }
            }
        }

        private Call get(String path) {
            HttpUrl url = serverUrl.newBuilder().addPathSegments(path).build();
            Request request = new Request.Builder().url(url).get().build();
            return client.newCall(request);
        }

        private Call put(String path, Object data) {
            HttpUrl url = serverUrl.newBuilder().addPathSegments(path).build();
            RequestBody body = RequestBody.create(GSON.toJson(data), JSON);
            Request request = new Request.Builder().url(url).put(body).build();
            return client.newCall(request);
        }

        private Call post(String path, Object data) {
            HttpUrl url = serverUrl.newBuilder().addPathSegments(path).build();
            RequestBody body = RequestBody.create(GSON.toJson(data), JSON);
            Request request = new Request.Builder().url(url).post(body).build();
            return client.newCall(request);
        }
    }
}
