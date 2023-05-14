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
import java.io.Reader;
import java.util.Collections;
import java.util.HashMap;
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
        private final OkHttpClient client;
        private final HttpUrl serverUrl;
        private final HashMap<String, DesignDocument> designDocuments;

        Connection(OkHttpClient client, HttpUrl serverUrl) {
            this.client = client;
            this.serverUrl = serverUrl;
            this.designDocuments = new HashMap<>();
        }

        public ViewResponse allDocs(String db) throws IOException, CouchDBError {
            HttpUrl url = serverUrl.newBuilder()
                    .addPathSegment(db)
                    .addPathSegment("_all_docs")
                    .addQueryParameter("include_docs", "true")
                    .build();

            try (Response res = get(url).execute()) {
                assert res.body() != null;

                if (!res.isSuccessful()) {
                    throw new CouchDBError(res.body().charStream());
                }

                return GSON.fromJson(res.body().charStream(), ViewResponse.class);
            }
        }

        public void bulkDocs(String db, List<JsonObject> docs) throws IOException, CouchDBError {
            HttpUrl url = serverUrl.newBuilder().addPathSegment(db).addPathSegment("_bulk_docs").build();

            try (Response res = post(url, Collections.singletonMap("docs", docs)).execute()) {
                if (!res.isSuccessful()) {
                    assert res.body() != null;
                    throw new CouchDBError(res.body().charStream());
                }
            }
        }

        public ViewResponse runQuery(String db, ViewQuery viewQuery) throws IOException, CouchDBError {
            String viewName = viewQuery.getViewName();
            DesignDocument designDocument = getDesignDocument(db);

            if (!designDocument.hasView(viewName)) {
                designDocument.addView(viewName, viewQuery.getMapFunction(), viewQuery.getReduceFunction());
                updateDesignDocument(db, designDocument);
            }

            HttpUrl url = serverUrl.newBuilder()
                    .addPathSegment(db)
                    .addPathSegment("_design")
                    .addPathSegment(DesignDocument.NAME)
                    .addPathSegment("_view")
                    .addPathSegment(viewName)
                    .build();

            try (Response res = post(url, viewQuery.getRequestBody()).execute()) {
                assert res.body() != null;

                if (!res.isSuccessful()) {
                    throw new CouchDBError(res.body().charStream());
                }

                return GSON.fromJson(res.body().charStream(), ViewResponse.class);
            }
        }

        public void close() {
            client.connectionPool().evictAll();
        }

        private void updateDesignDocument(String db, DesignDocument designDocument) throws IOException, CouchDBError {
            HttpUrl url = serverUrl.newBuilder()
                    .addPathSegment(db)
                    .addPathSegment("_design")
                    .addPathSegment(DesignDocument.NAME)
                    .build();

            try (Response res = put(url, designDocument).execute()) {
                if (!res.isSuccessful()) {
                    assert res.body() != null;
                    throw new CouchDBError(res.body().charStream());
                }
            }
        }

        private DesignDocument getDesignDocument(String db) throws IOException, CouchDBError {
            if (designDocuments.containsKey(db)) {
                return designDocuments.get(db);
            }

            HttpUrl url = serverUrl.newBuilder()
                    .addPathSegment(db)
                    .addPathSegment("_design")
                    .addPathSegment(DesignDocument.NAME)
                    .build();

            try (Response res = get(url).execute()) {
                if (res.code() == 404) {
                    return new DesignDocument();
                }

                assert res.body() != null;

                if (!res.isSuccessful()) {
                    throw new CouchDBError(res.body().charStream());
                }

                designDocuments.put(db, GSON.fromJson(res.body().charStream(), DesignDocument.class));
                return designDocuments.get(db);
            }
        }

        private Call get(HttpUrl url) {
            Request request = new Request.Builder().url(url).get().build();
            return client.newCall(request);
        }

        private Call put(HttpUrl url, Object data) {
            RequestBody body = RequestBody.create(GSON.toJson(data), JSON);
            Request request = new Request.Builder().url(url).put(body).build();
            return client.newCall(request);
        }

        private Call post(HttpUrl url, Object data) {
            RequestBody body = RequestBody.create(GSON.toJson(data), JSON);
            Request request = new Request.Builder().url(url).post(body).build();
            return client.newCall(request);
        }
    }

    static class CouchDBError extends Exception {
        private final String error;
        private final String reason;

        CouchDBError(Reader reader) {
            JsonObject error = GSON.fromJson(reader, JsonObject.class);
            this.error = error.get("error").getAsString();
            this.reason = error.get("reason").getAsString();
        }

        @Override
        public String getMessage() {
            return error + ": " + reason;
        }
    }
}
