package gr.ds.unipi.noda.api.couchdb;

import com.google.gson.Gson;
import gr.ds.unipi.noda.api.core.nosqldb.NoSqlDbConnector;
import okhttp3.Credentials;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

public final class CouchDBConnector implements NoSqlDbConnector<CouchDBConnector.Connection> {
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

        public View.Response allDocs(String db) {
            HttpUrl url = resolveUrl(db, "_all_docs");

            Request request = new Request.Builder().url(url)
                    .post(RequestBody.create(GSON.toJson(Collections.singletonMap("include_docs", true)), JSON))
                    .build();

            try (Response res = client.newCall(request).execute()) {
                assert res.body() != null;

                return GSON.fromJson(res.body().charStream(), View.Response.class);
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
        }

        public void bulkDocs(String db, List<Map<String, Object>> docs) {
            HttpUrl url = resolveUrl(db, "_bulk_docs");

            Request request = new Request.Builder().url(url)
                    .post(RequestBody.create(GSON.toJson(Collections.singletonMap("docs", docs)), JSON))
                    .build();

            try (Response res = client.newCall(request).execute()) {
                if (!res.isSuccessful()) {
                    assert res.body() != null;
                    System.err.println(res.body().string());
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public View.Response execute(View view) {
            try {
                // Create or update the internal design document if it doesn't exist
                ensureDesignDocIsUpdated(view);
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }

            HttpUrl url = resolveUrl(view.getDatabase(), "_design", DESIGN_DOC, "_view", view.getName());

            Request request = new Request.Builder().url(url)
                    .post(RequestBody.create(GSON.toJson(view.getRequestBody()), JSON))
                    .build();

            try (Response res = client.newCall(request).execute()) {
                assert res.body() != null;

                if (!res.isSuccessful()) {
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

        private void ensureDesignDocIsUpdated(View view) throws IOException {
            DesignDoc designDoc;
            HttpUrl url = resolveUrl(view.getDatabase(), "_design", DESIGN_DOC);

            // Get the internal design document
            Request request = new Request.Builder().url(url).get().build();
            try (Response res = client.newCall(request).execute()) {
                if (res.code() == 404) {
                    // Create a new design document if it does not exist...
                    designDoc = DesignDoc.createDesignDoc(view);
                } else if (res.isSuccessful()) {
                    assert res.body() != null;
                    designDoc = GSON.fromJson(res.body().charStream(), DesignDoc.class);
                } else {
                    assert res.body() != null;
                    System.err.println(res.body().string());
                    return;
                }

                // ...skip if the view already exists...
                if (designDoc.views.containsKey(view.getName())) {
                    return;
                }

                // ...or update the existing one with the new view
                designDoc.addView(view);
            }

            url = resolveUrl(view.getDatabase(), "_design", DESIGN_DOC);
            request = new Request.Builder().url(url).put(RequestBody.create(GSON.toJson(designDoc), JSON)).build();

            try (Response res = client.newCall(request).execute()) {
                if (!res.isSuccessful()) {
                    assert res.body() != null;
                    System.err.println(res.body().string());
                }
            }
        }

        private HttpUrl resolveUrl(String... paths) {
            HttpUrl.Builder url = serverUrl.newBuilder();
            Arrays.stream(paths).forEach(url::addPathSegment);
            return url.build();
        }
    }
}
