package gr.ds.unipi.noda.api.cassandra;

import com.datastax.oss.driver.api.core.CqlIdentifier;
import com.datastax.oss.driver.api.core.cql.Row;
import com.datastax.oss.driver.api.core.metadata.schema.ClusteringOrder;
import com.datastax.oss.driver.api.core.metadata.schema.ColumnMetadata;
import com.datastax.oss.driver.shaded.guava.common.collect.Streams;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CassandraQueryBuilder {

    public static final ArrayList<String> emptyClause = new ArrayList<>();
    private StringBuilder query;

    public CassandraQueryBuilder() {
        query = new StringBuilder();
    }

    public void addSelectClause(ArrayList<String> selectClauseList, ArrayList<String> selectClauseAggregate) {
        query.append("SELECT ");
        if (selectClauseList.isEmpty() && selectClauseAggregate.isEmpty()) {
            query.append(" * ");
        } else {
            ArrayList<String> selectClauseElements = new ArrayList<>();
            selectClauseElements.addAll(selectClauseList);
            selectClauseElements.addAll(selectClauseAggregate);
            query.append(String.join(" , ", selectClauseElements));
        }
        query.append(" FROM ");
    }

    public void addUSOSelectClause(ArrayList<String> tableColumns, ArrayList<String> selectClauseListUSO) {
        query.append("SELECT ");
        ArrayList<String> selectClauseElements = new ArrayList<>();
        selectClauseElements.addAll(tableColumns);
        selectClauseElements.addAll(selectClauseListUSO);
        query.append(String.join(" , ", selectClauseElements));
        query.append(" FROM ");
    }

    public void addGeoSelectClause(ArrayList<String> tableColumns, ArrayList<String> selectClauseListUSO, ArrayList<String> selectClauseListGeo) {
        query.append("SELECT ");
        ArrayList<String> selectClauseElements = new ArrayList<>();
        selectClauseElements.addAll(tableColumns);
        selectClauseElements.addAll(selectClauseListUSO);
        query.append(String.join(" , ", selectClauseElements));
        query.append(" , ");
        query.append(String.join(" , ", selectClauseListGeo));
        query.append(" FROM ");
    }

    public void addCreateTableClause() {
        query.append("CREATE TABLE ");
    }

    public void addInsertIntoClause() {
        query.append("INSERT INTO ");
    }

    public void addCreateMVClause(String materializedViewName) {
        query.append("CREATE MATERIALIZED VIEW IF NOT EXISTS ");
        query.append(materializedViewName);
        query.append(" AS ");
    }

    public void addTable(String table) {
        query.append(" ").append(table).append(" ");
    }

    public void addNewTableColumns(Map<CqlIdentifier, ColumnMetadata> columns, List<ColumnMetadata> partitionKeys, Map<ColumnMetadata, ClusteringOrder> clusteringKeys) {
        query.append('(');
        query.append(Streams.zip(columns.keySet().stream(), columns.values().stream(), (k, v) -> k.asCql(true) + " " + v.getType().asCql(true, true)).collect(Collectors.joining(",")));
        query.append(", PRIMARY KEY ((");
        query.append(partitionKeys.stream().map(partCol -> partCol.getName().asCql(true)).collect(Collectors.joining(",")));
        query.append(')');
        if (!clusteringKeys.isEmpty()) {
            query.append(',');
            query.append(clusteringKeys.keySet().stream().map(clusterKey -> clusterKey.getName().asCql(true)).collect(Collectors.joining(",")));
        }
        query.append(')');
        query.append(')');
        if (!clusteringKeys.isEmpty()) {
            query.append("WITH CLUSTERING ORDER BY(");
            query.append(Streams.zip(clusteringKeys.keySet().stream(), clusteringKeys.values().stream(), (k, v) -> k.getName().asCql(true) + " " + v.name()).collect(Collectors.joining(",")));
            query.append(')');
        }
    }

    public void addMVPrimaryKeys(List<String> primaryKeys) {
        query.append("PRIMARY KEY (");
        query.append(String.join(",", primaryKeys));
        query.append(")");
    }

    public void addWhereClause(List<String> whereClauseList) {
        query.append(String.join(" ", " WHERE ", String.join(" AND ", whereClauseList)));
    }

    public void addGroupByClause(ArrayList<String> groupByClauseList) {
        query.append(String.join(" ", " GROUP BY", String.join(",", groupByClauseList)));
    }

    public void addOrderByClause(ArrayList<String> orderByClauseList) {
        query.append(String.join(" ", " ORDER BY", String.join(",", orderByClauseList)));
    }

    public void addLimit(int limit) {
        query.append(String.join(" ", " LIMIT ", String.valueOf(limit)));
    }

    public void addInsertFilteredRow(Map<CqlIdentifier, ColumnMetadata> columns, Row USORow) {
        query.append('(');
        query.append(columns.keySet().stream().map(column -> column.asCql(true)).collect(Collectors.joining(",")));
        query.append(") VALUES (");
        query.append(IntStream.range(0, columns.size()).mapToObj(i -> USORow.getFormattedContents().split(", ")[i].split("^(.*?):")[1]).collect(Collectors.joining(",")));
        query.append(')');
    }

    public void addAllowFiltering() {
        query.append(" ALLOW FILTERING;");
    }

    public String getQuery() {
        return query.toString();
    }

    public void reset() {
        query = new StringBuilder();
    }
}