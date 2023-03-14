package gr.ds.unipi.noda.api.cassandra;
import java.util.StringJoiner;

public class CassandraQueryBuilderDirector {
    private CassandraQueryBuilder queryBuilder;
    private String tableName;

    public CassandraQueryBuilderDirector(CassandraQueryBuilder queryBuilder, String tableName) {
        this.queryBuilder = queryBuilder;
        this.tableName = tableName;
    }

    public String makeAggregationFunctionQuery(String aggregationFunction, StringJoiner filterList) {
        queryBuilder.reset();
        queryBuilder.addAggregationFunction(aggregationFunction);
        queryBuilder.addTable(tableName);
        if( filterList.length() > 0 ) {
            queryBuilder.addWhereClause(filterList);
        }
        return queryBuilder.getQuery();
    }

    public String makeFullQuery(StringJoiner fieldsList, StringJoiner aggregateList, StringJoiner filterList, StringJoiner groupByList, StringJoiner orderByList, int limit) {
        queryBuilder.reset();
        if( fieldsList.length() > 0 ) {
            queryBuilder.addProjectionFields(fieldsList);
        }else if( aggregateList.length() > 0 ) {
            queryBuilder.addAggregateFunctions(aggregateList);
        }else{
            queryBuilder.addWildcard();
        }
        queryBuilder.addTable(tableName);
        if( filterList.length() > 0 ) {
            queryBuilder.addWhereClause(filterList);
        }
        if( groupByList.length() > 0 ) {
            queryBuilder.addGroupClause(groupByList);
        }
        if( orderByList.length() > 0 ) {
            queryBuilder.addOrderClause(orderByList);
        }
        if( limit > 0 ) {
            queryBuilder.addLimitClause(limit);
        }
        return queryBuilder.getQuery();
    }

}
