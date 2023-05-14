package gr.ds.unipi.noda.api.couchdb;

import com.google.gson.JsonObject;
import gr.ds.unipi.noda.api.core.operators.aggregateOperators.AggregateOperator;
import gr.ds.unipi.noda.api.core.operators.filterOperators.FilterOperator;
import org.apache.commons.lang3.StringEscapeUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Objects;
import java.util.stream.Collectors;

final class ViewQuery {
    final private ArrayList<FilterOperator<?>> filters;
    final private ArrayList<AggregateOperator<?>> aggregates;
    final private HashMap<String, String> sortFields;
    final private HashSet<String> groupFields;
    final private HashSet<String> projectFields;
    final private HashSet<String> valueFields;
    private boolean isGroup;
    private boolean isReduce;
    private int limit;

    public ViewQuery() {
        filters = new ArrayList<>();
        aggregates = new ArrayList<>();
        sortFields = new HashMap<>();
        groupFields = new HashSet<>();
        projectFields = new HashSet<>();
        valueFields = new HashSet<>();
        isGroup = false;
        isReduce = false;
        limit = -1;
    }

    public ViewQuery(ViewQuery another) {
        filters = new ArrayList<>(another.filters);
        aggregates = new ArrayList<>(another.aggregates);
        sortFields = new HashMap<>(another.sortFields);
        groupFields = new HashSet<>(another.groupFields);
        projectFields = new HashSet<>(another.projectFields);
        valueFields = new HashSet<>(another.valueFields);
        isGroup = another.isGroup;
        isReduce = another.isReduce;
        limit = another.limit;
    }

    public void addFilter(FilterOperator<?> filterOperator) {
        filters.add(filterOperator);
    }

    public void addAggregate(AggregateOperator<?> aggregateOperator) {
        aggregates.add(aggregateOperator);
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
        if (!(obj instanceof ViewQuery)) {
            return false;
        }

        ViewQuery viewQuery = (ViewQuery) obj;

        return viewQuery.filters.equals(this.filters) && viewQuery.aggregates.equals(this.aggregates) &&
                viewQuery.sortFields.equals(this.sortFields) && viewQuery.groupFields.equals(this.groupFields) &&
                viewQuery.valueFields.equals(this.valueFields) && viewQuery.projectFields.equals(this.projectFields);
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
                    .map(f -> (String) f.getOperatorExpression())
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

        for (AggregateOperator<?> op : aggregates) {
            String[] operatorExpression = (String[]) op.getOperatorExpression();
            assert operatorExpression.length == 2;

            String alias = StringEscapeUtils.escapeEcmaScript(op.getAlias());
            reduce.append('"').append(alias).append("\": ").append(operatorExpression[0]).append(",");
            rereduce.append('"').append(alias).append("\": ").append(operatorExpression[1]).append(",");
        }

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

        body.addProperty("reduce", isReduce);
        body.addProperty("include_docs", !isReduce);
        body.addProperty("descending", isSortDescending());

        if (limit >= 0) {
            body.addProperty("limit", limit);
        }

        if (isGroup) {
            body.addProperty("group", true);
            body.addProperty("group_level", groupFields.size());
        }

        return body;
    }

    private boolean isSortDescending() {
        boolean isSortDescending = sortFields.containsValue("descending");

        if (isSortDescending && sortFields.containsValue("ascending")) {
            throw new IllegalStateException("Multiple sorting fields with different sort orders");
        }

        return isSortDescending;
    }
}
