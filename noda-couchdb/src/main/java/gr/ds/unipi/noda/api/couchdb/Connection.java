package gr.ds.unipi.noda.api.couchdb;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

import java.io.IOException;
import java.io.Reader;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;

final class Connection {
    final private static MediaType JSON = MediaType.get("application/json; charset=utf-8");
    final private static Gson GSON = new Gson();
    final private OkHttpClient client;
    final private HttpUrl serverUrl;

    Connection(OkHttpClient client, HttpUrl serverUrl) {
        this.client = client;
        this.serverUrl = serverUrl;
    }

    public AbstractResponse runQuery(String db, Query query) throws IOException, CouchDBError {
        if (query.isViewQuery()) {
            return queryView(db, query);
        } else {
            return queryFind(db, query);
        }
    }

    public ViewResponse queryView(String db, Query query) throws IOException, CouchDBError {
        HttpUrl url = serverUrl.newBuilder()
                .addPathSegment(db)
                .addPathSegments("_design/NODA/_view")
                .addPathSegment(query.getViewName())
                .build();

        HttpUrl designDocUrl = serverUrl.newBuilder().addPathSegment(db).addPathSegments("_design/NODA").build();
        query.prepareViewQuery(clazz -> {
            Request prepareRequest = new Request.Builder().url(designDocUrl).get().build();
            try (Response res = client.newCall(prepareRequest).execute()) {
                assert res.body() != null;

                if (res.code() == 404) {
                    return null;
                } else if (!res.isSuccessful()) {
                    throw new CouchDBError(res.body().charStream());
                }

                return GSON.fromJson(res.body().charStream(), clazz);
            }
        }, designDocument -> {
            RequestBody prepareBody = RequestBody.create(GSON.toJson(designDocument), JSON);
            Request prepareRequest = new Request.Builder().url(designDocUrl).put(prepareBody).build();
            try (Response res = client.newCall(prepareRequest).execute()) {
                if (!res.isSuccessful()) {
                    assert res.body() != null;
                    throw new CouchDBError(res.body().charStream());
                }
            }
        });

        RequestBody body = RequestBody.create(GSON.toJson(query.getRequestBody()), JSON);
        Request request = new Request.Builder().url(url).post(body).build();

        try (Response res = client.newCall(request).execute()) {
            assert res.body() != null;

            if (!res.isSuccessful()) {
                throw new CouchDBError(res.body().charStream());
            }

            return GSON.fromJson(res.body().charStream(), ViewResponse.class);
        }
    }

    public FindResponse queryFind(String db, Query query) throws IOException, CouchDBError {
        HttpUrl url = serverUrl.newBuilder().addPathSegment(db).addPathSegment("_find").build();

        RequestBody body = RequestBody.create(GSON.toJson(query.getRequestBody()), JSON);
        Request request = new Request.Builder().url(url).post(body).build();

        try (Response res = client.newCall(request).execute()) {
            assert res.body() != null;

            if (!res.isSuccessful()) {
                throw new CouchDBError(res.body().charStream());
            }

            return GSON.fromJson(res.body().charStream(), FindResponse.class);
        }
    }

    public void bulkDocs(String db, Collection<JsonObject> bulkDocs) throws IOException, CouchDBError {
        HttpUrl url = serverUrl.newBuilder().addPathSegment(db).addPathSegment("_bulk_docs").build();

        Map<String, Collection<JsonObject>> docs = Collections.singletonMap("docs", bulkDocs);
        RequestBody body = RequestBody.create(GSON.toJson(docs), JSON);
        Request request = new Request.Builder().url(url).post(body).build();

        try (Response res = client.newCall(request).execute()) {
            if (!res.isSuccessful()) {
                assert res.body() != null;
                throw new CouchDBError(res.body().charStream());
            }
        }
    }

    public void close() {
        client.connectionPool().evictAll();
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

    static abstract class AbstractResponse {
        abstract public int getTotalRows();
    }

    static class ViewResponse extends AbstractResponse {
        @SerializedName("total_rows")
        public Integer totalRows;
        public List<Row> rows;

        @Override
        public int getTotalRows() {
            if (totalRows != null) {
                return totalRows;
            } else {
                return rows.size();
            }
        }

        static class Row {
            String id;
            JsonElement key;
            JsonElement value;
            JsonObject doc;
        }
    }

    static class FindResponse extends AbstractResponse {
        List<JsonObject> docs;

        @Override
        public int getTotalRows() {
            return docs.size();
        }
    }
}
