package gr.ds.unipi.noda.api.couchdb;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;
import gr.ds.unipi.noda.api.couchdb.filterOperators.FilterStrategy;
import org.apache.commons.lang3.StringEscapeUtils;
import org.apache.commons.lang3.tuple.ImmutablePair;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

final class Query {
    final private ArrayList<FilterStrategy> filters;
    final private HashMap<String, ImmutablePair<String, String>> aggregates;
    final private HashMap<String, String> sortFields;
    final private HashSet<String> groupFields;
    final private HashSet<String> projectFields;
    final private HashSet<String> valueFields;
    private boolean isGroup;
    private boolean isReduce;
    private int limit;

    public Query() {
        filters = new ArrayList<>();
        aggregates = new HashMap<>();
        sortFields = new HashMap<>();
        groupFields = new HashSet<>();
        projectFields = new HashSet<>();
        valueFields = new HashSet<>();
        isGroup = false;
        isReduce = false;
        limit = -1;
    }

    public Query(Query other) {
        filters = new ArrayList<>(other.filters);
        aggregates = new HashMap<>(other.aggregates);
        sortFields = new HashMap<>(other.sortFields);
        groupFields = new HashSet<>(other.groupFields);
        projectFields = new HashSet<>(other.projectFields);
        valueFields = new HashSet<>(other.valueFields);
        isGroup = other.isGroup;
        isReduce = other.isReduce;
        limit = other.limit;
    }

    public void addFilter(FilterStrategy filter) {
        filters.add(filter);
    }

    public void addAggregate(String alias, ImmutablePair<String, String> aggregate) {
        aggregates.put(alias, aggregate);
    }

    public void addSortField(ImmutablePair<String, String> sort) {
        sortFields.put(sort.getLeft(), sort.getRight());
    }

    public void addGroupField(String field) {
        groupFields.add(field);
    }

    public void addProjectField(String field) {
        projectFields.add(field);
    }

    public void addValueField(String field) {
        valueFields.add(field);
    }

    public void setGroup(boolean isGroup) {
        this.isGroup = isGroup;
    }

    public void setReduce(boolean isReduce) {
        this.isReduce = isReduce;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public boolean isReduce() {
        return isReduce;
    }

    public boolean isGroup() {
        return isGroup;
    }

    public boolean isViewQuery() {
        return isGroup || isReduce || !sortFields.isEmpty() || !groupFields.isEmpty() || !aggregates.isEmpty();
    }

    public String prepareViewQuery(GetDesignDocumentCall getDesignDocumentCall, UpdateDesignDocumentCall updateDesignDocumentCall) throws IOException, Connection.CouchDBError {
        String mapFunction = createMapFunction();
        String reduceFunction = createReduceFunction();
        String viewName = Integer.toString(Objects.hash(mapFunction, reduceFunction));

        DesignDocument designDocument = getDesignDocumentCall.getDesignDocument(DesignDocument.class);
        if (designDocument == null) {
            designDocument = new DesignDocument();
        }

        // Update the design document if the current view query does not exist.
        if (!designDocument.hasView(viewName)) {
            designDocument.addView(viewName, mapFunction, reduceFunction);
            updateDesignDocumentCall.updateDesignDocument(designDocument);
        }

        return viewName;
    }

    public JsonObject getRequestBody() {
        JsonObject body = new JsonObject();
        Gson gson = new Gson();

        if (isViewQuery()) {
            body.addProperty("reduce", isReduce);
            body.addProperty("include_docs", !isReduce);
            body.addProperty("descending", isSortDescending());

            if (isGroup) {
                body.addProperty("group", true);
                body.addProperty("group_level", groupFields.size());
            }
        } else {
            if (!filters.isEmpty()) {
                Map<String, Object> selector = Collections.singletonMap("$and",
                        filters.stream().map(FilterStrategy::asFindFilter).collect(Collectors.toList())
                );
                body.add("selector", gson.toJsonTree(selector));
            } else {
                body.add("selector", gson.toJsonTree(Collections.emptyMap()));
            }

            if (!projectFields.isEmpty()) {
                body.add("fields", gson.toJsonTree(projectFields));
            }
        }

        if (limit >= 0) {
            body.addProperty("limit", limit);
        }

        return body;
    }

    private String createMapFunction() {
        StringBuilder sb = new StringBuilder(100);
        HashSet<String> keys = new HashSet<>();
        HashSet<String> values = new HashSet<>();

        // Note, sorting only works without grouping
        if (groupFields.isEmpty()) {
            keys.addAll(sortFields.keySet());
        } else {
            keys.addAll(groupFields);
        }

        values.addAll(valueFields);
        values.addAll(projectFields);

        sb.append("function(doc) {");

        if (!filters.isEmpty()) {
            String filter = filters.stream()
                    .map(FilterStrategy::asMapFilter)
                    .collect(Collectors.joining(" && "));

            sb.append("if (").append(filter).append(") ");
        }

        sb.append("{ emit(");

        if (keys.isEmpty()) {
            sb.append("null");
        } else {
            sb.append("[");
            for (String key : keys) {
                sb.append("doc[\"").append(StringEscapeUtils.escapeEcmaScript(key)).append("\"],");
            }
            sb.deleteCharAt(sb.lastIndexOf(","));
            sb.append("]");
        }

        sb.append(", ");

        if (values.isEmpty()) {
            sb.append("null");
        } else {
            sb.append("{");
            for (String val : values) {
                sb.append('"')
                        .append(StringEscapeUtils.escapeEcmaScript(val))
                        .append("\": doc[\"")
                        .append(StringEscapeUtils.escapeEcmaScript(val))
                        .append("\"],");
            }
            sb.deleteCharAt(sb.lastIndexOf(","));
            sb.append("}");
        }

        sb.append(");}}");

        return sb.toString();
    }

    private String createReduceFunction() {
        StringBuilder sb = new StringBuilder(150);
        StringBuilder reduce = new StringBuilder(50);
        StringBuilder rereduce = new StringBuilder(50);

        aggregates.forEach((alias, expression) -> {
            String escapedAlias = StringEscapeUtils.escapeEcmaScript(alias);
            reduce.append('"').append(escapedAlias).append("\": ").append(expression.getLeft()).append(",");
            rereduce.append('"').append(escapedAlias).append("\": ").append(expression.getRight()).append(",");
        });

        // Add node length information that is useful in some aggregate operators
        reduce.append("__nodeLength: values.length,");

        for (String field : projectFields) {
            reduce.append('"').append(field).append("\": values.map(a => a[\"").append(field).append("\"]),");
            rereduce.append('"').append(field).append("\": values.flatMap(a => a[\"").append(field).append("\"]),");
        }

        sb.append("function(keys, values, rereduce) { if (rereduce) { return {")
                .append(rereduce)
                .append("}} else { return {")
                .append(reduce)
                .append("}}}");

        return sb.toString();
    }

    private boolean isSortDescending() {
        boolean isSortDescending = sortFields.containsValue("descending");

        if (isSortDescending && sortFields.containsValue("ascending")) {
            throw new IllegalStateException("Multiple sorting fields with different sort orders");
        }

        return isSortDescending;
    }

    interface UpdateDesignDocumentCall {
        void updateDesignDocument(DesignDocument designDocument) throws IOException, Connection.CouchDBError;
    }

    interface GetDesignDocumentCall {
        DesignDocument getDesignDocument(Class<DesignDocument> clazz) throws IOException, Connection.CouchDBError;
    }

    static class DesignDocument {
        public String _id;
        public String _rev;

        public Map<String, View> views = new HashMap<>();

        public boolean hasView(String viewName) {
            return views.containsKey(viewName);
        }

        public void addView(String viewName, String mapFunction, String reduceFunction) {
            views.put(viewName, new View(mapFunction, reduceFunction));
        }
    }

    static class View {
        @SerializedName("map")
        public String mapFunction;
        @SerializedName("reduce")
        public String reduceFunction;

        View(String map, String reduce) {
            mapFunction = map;
            reduceFunction = reduce;
        }
    }
}
