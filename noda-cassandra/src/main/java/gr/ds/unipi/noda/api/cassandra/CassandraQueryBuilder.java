package gr.ds.unipi.noda.api.cassandra;
import java.lang.StringBuilder;
import java.util.ArrayList;
import java.util.StringJoiner;

public class CassandraQueryBuilder {

    private StringBuilder query;

    public CassandraQueryBuilder() {
        query = new StringBuilder();
        query.append("SELECT ");
    }

    public void addWildcard(){
        query.append(" * ");
    }

    public void addTable(String table) {
        query.append(" FROM ");
        query.append(table);
    }

    public void addWhereClause(StringJoiner filterList){
        query.append(" WHERE ");
        query.append(filterList.toString());
    }

    public void addAggregateFunctions(StringJoiner aggregateList){
       query.append(aggregateList.toString());
    }

    public void addAggregationFunction(String aggregateFunction){
        query.append(aggregateFunction);
    }

    public void addProjectionFields(StringJoiner projectionList){
        query.append(projectionList.toString());
    }

    public void addGroupClause(StringJoiner groupList){
        query.append(" GROUP BY ");
        query.append(groupList.toString());
    }

    public void addLimitClause(int limit){
        query.append(" LIMIT ");
        query.append(limit);
    }

    public void addOrderClause(StringJoiner orderList){
        query.append(" ORDER BY ");
        query.append(orderList.toString());
    }

    public String getQuery() {
        query.append(" ALLOW FILTERING;");
        return query.toString();
    }

    public void reset() {
        query = new StringBuilder("SELECT ");
    }
}