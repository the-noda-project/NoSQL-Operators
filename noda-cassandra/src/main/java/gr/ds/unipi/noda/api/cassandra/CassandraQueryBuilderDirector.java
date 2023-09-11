package gr.ds.unipi.noda.api.cassandra;

import com.datastax.oss.driver.api.core.CqlIdentifier;
import com.datastax.oss.driver.api.core.CqlSession;
import com.datastax.oss.driver.api.core.cql.Row;
import com.datastax.oss.driver.api.core.metadata.schema.ClusteringOrder;
import com.datastax.oss.driver.api.core.metadata.schema.ColumnMetadata;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CassandraQueryBuilderDirector {
    private final CassandraQueryBuilder queryBuilder;
    private final String keyspace;
    private final String table;

    public CassandraQueryBuilderDirector(CassandraQueryBuilder queryBuilder, String keyspace, String table) {
        this.queryBuilder = queryBuilder;
        this.keyspace = keyspace;
        this.table = table;
    }

    public String makeAggregationFunctionQuery(ArrayList<String> selectClauseAggregate, ArrayList<String> whereClause) {
        queryBuilder.reset();
        queryBuilder.addSelectClause(CassandraQueryBuilder.emptyClause, selectClauseAggregate);
        queryBuilder.addTable(table);
        queryBuilder.addWhereClause(whereClause);
        queryBuilder.addAllowFiltering();
        return queryBuilder.getQuery();
    }

    public String makeFullSelectQuery(ArrayList<String> selectClauseList, ArrayList<String> selectClauseAggregate, ArrayList<String> whereClauseList, ArrayList<String> groupByClauseList, ArrayList<String> orderByClauseList, int limit) {
        queryBuilder.reset();
        queryBuilder.addSelectClause(selectClauseList, selectClauseAggregate);
        queryBuilder.addTable(table);
        if (!whereClauseList.isEmpty())
            queryBuilder.addWhereClause(whereClauseList);
        if (!groupByClauseList.isEmpty())
            queryBuilder.addGroupByClause(groupByClauseList);
        if (!orderByClauseList.isEmpty())
            queryBuilder.addOrderByClause(orderByClauseList);
        if (limit > 0)
            queryBuilder.addLimit(limit);
        queryBuilder.addAllowFiltering();
        return queryBuilder.getQuery();
    }

    public String makeUsoQuery(ArrayList<String> selectClauseListUSO, ArrayList<String> whereClauseList, CqlSession session) {
        queryBuilder.reset();
        ArrayList<String> tableColumns = (ArrayList<String>) session.getMetadata().getKeyspace(keyspace).get().getTable(table).get().getColumns().keySet().stream().map(column -> column.asCql(true)).collect(Collectors.toList());
        queryBuilder.addUSOSelectClause(tableColumns, selectClauseListUSO);
        queryBuilder.addTable(table);
        if (!whereClauseList.isEmpty()) {
            queryBuilder.addWhereClause(whereClauseList);
            queryBuilder.addAllowFiltering();
        }
        return queryBuilder.getQuery();
    }

    public String makeFilteredTableQuery(Map<CqlIdentifier, ColumnMetadata> columns, List<ColumnMetadata> partitionKeys, Map<ColumnMetadata, ClusteringOrder> clusteringKeys) {
        queryBuilder.reset();
        queryBuilder.addCreateTableClause();
        queryBuilder.addTable("filteredTable");
        queryBuilder.addNewTableColumns(columns, partitionKeys, clusteringKeys);
        return queryBuilder.getQuery();
    }

    public String makeInsertQuery(Map<CqlIdentifier, ColumnMetadata> columns, Row USORow) {
        queryBuilder.reset();
        queryBuilder.addInsertIntoClause();
        queryBuilder.addTable("filteredTable");
        queryBuilder.addInsertFilteredRow(columns, USORow);
        return queryBuilder.getQuery();
    }

    public String makeApplyRestOfOperationsQuery(ArrayList<String> selectClauseList, ArrayList<String> selectClauseAggregate, ArrayList<String> whereClauseList, ArrayList<String> groupByClauseList, ArrayList<String> orderByClauseList, int limit) {
        queryBuilder.reset();
        queryBuilder.addSelectClause(selectClauseList, selectClauseAggregate);
        queryBuilder.addTable("filteredTable");
        if (!whereClauseList.isEmpty())
            queryBuilder.addWhereClause(whereClauseList);
        if (!groupByClauseList.isEmpty())
            queryBuilder.addGroupByClause(groupByClauseList);
        if (!orderByClauseList.isEmpty())
            queryBuilder.addOrderByClause(orderByClauseList);
        if (limit > 0)
            queryBuilder.addLimit(limit);
        queryBuilder.addAllowFiltering();
        return queryBuilder.getQuery();
    }

    public String makeMVQuery(String column, CqlSession session) {
        queryBuilder.reset();
        queryBuilder.addCreateMVClause(table + "_mv");
        queryBuilder.addSelectClause(new ArrayList<>(), new ArrayList<>());
        queryBuilder.addTable(table);
        ArrayList<String> mvWhereClause = new ArrayList<>();
        mvWhereClause.add(column + " IS NOT NULL");
        mvWhereClause.addAll(session.getMetadata().getKeyspace(keyspace).get().getTable(table).get().getPrimaryKey().stream().map(columnMetadata -> columnMetadata.getName().asCql(true) + " IS NOT NULL ").collect(Collectors.toList()));
        queryBuilder.addWhereClause(mvWhereClause);
        ArrayList<String> primaKeysMV = new ArrayList<>();
        primaKeysMV.add(column);
        primaKeysMV.addAll(session.getMetadata().getKeyspace(keyspace).get().getTable(table).get().getPrimaryKey().stream().map(columnMetadata -> columnMetadata.getName().asCql(true)).collect(Collectors.toList()));
        queryBuilder.addMVPrimaryKeys(primaKeysMV);
        return queryBuilder.getQuery();
    }

    public String makeGeoQuery(ArrayList<String> selectClauseListUSO, ArrayList<String> selectClauseListGeo, ArrayList<String> whereClauseList, CqlSession session) {
        queryBuilder.reset();
        ArrayList<String> tableColumns = (ArrayList<String>) session.getMetadata().getKeyspace(keyspace).get().getTable(table).get().getColumns().keySet().stream().map(column -> column.asCql(true)).collect(Collectors.toList());
        queryBuilder.addGeoSelectClause(tableColumns, selectClauseListUSO, selectClauseListGeo);
        queryBuilder.addTable(table + "_mv");
        if (!whereClauseList.isEmpty())
            queryBuilder.addWhereClause(whereClauseList);
        queryBuilder.addAllowFiltering();
        return queryBuilder.getQuery();
    }
}
