package gr.ds.unipi.noda.api.couchdb;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import gr.ds.unipi.noda.api.couchdb.filterOperators.FilterStrategy;
import org.apache.commons.lang3.StringEscapeUtils;
import org.apache.commons.lang3.tuple.ImmutablePair;

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

    public void addSortField(String field, String direction) {
        sortFields.put(field, direction);
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

    public String getViewName() {
        return Integer.toString(hashCode());
    }

    @Override
    public int hashCode() {
        return Objects.hash(filters, aggregates, sortFields, groupFields, valueFields, projectFields);
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Query)) {
            return false;
        }

        Query query = (Query) obj;

        return query.filters.equals(this.filters) && query.aggregates.equals(this.aggregates) &&
                query.sortFields.equals(this.sortFields) && query.groupFields.equals(this.groupFields) &&
                query.valueFields.equals(this.valueFields) && query.projectFields.equals(this.projectFields);
    }

    public String getMapFunction() {
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
                    .map(FilterStrategy::getMapFilter)
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

    public String getReduceFunction() {
        StringBuilder sb = new StringBuilder(150);
        StringBuilder reduce = new StringBuilder(50);
        StringBuilder rereduce = new StringBuilder(50);

        aggregates.forEach((alias, expression) -> {
            String escapedAlias = StringEscapeUtils.escapeEcmaScript(alias);
            reduce.append('"').append(escapedAlias).append("\": ").append(expression.getLeft()).append(",");
            rereduce.append('"').append(escapedAlias).append("\": ").append(expression.getRight()).append(",");
        });

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
            Map<String, Object> selector = Collections.singletonMap("$and",
                    filters.stream().map(FilterStrategy::getMangoFilter).collect(Collectors.toList())
            );

            body.add("selector", gson.toJsonTree(selector));
            body.add("fields", gson.toJsonTree(projectFields));
        }

        if (limit >= 0) {
            body.addProperty("limit", limit);
        }

        return body;
    }

    public boolean isViewQuery() {
        return isGroup || isReduce || !sortFields.isEmpty();
    }

    public boolean isReduce() {
        return isReduce;
    }

    private boolean isSortDescending() {
        boolean isSortDescending = sortFields.containsValue("descending");

        if (isSortDescending && sortFields.containsValue("ascending")) {
            throw new IllegalStateException("Multiple sorting fields with different sort orders");
        }

        return isSortDescending;
    }
}
