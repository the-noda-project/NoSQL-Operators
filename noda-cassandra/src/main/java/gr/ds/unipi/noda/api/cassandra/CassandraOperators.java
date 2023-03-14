package gr.ds.unipi.noda.api.cassandra;

import gr.ds.unipi.noda.api.core.nosqldb.NoSqlDbConnector;
import gr.ds.unipi.noda.api.core.nosqldb.NoSqlDbOperators;
import gr.ds.unipi.noda.api.core.nosqldb.NoSqlDbResults;
import gr.ds.unipi.noda.api.core.operators.Operator;
import gr.ds.unipi.noda.api.core.operators.aggregateOperators.AggregateOperator;
import gr.ds.unipi.noda.api.core.operators.filterOperators.FilterOperator;
import gr.ds.unipi.noda.api.core.operators.joinOperators.JoinOperator;
import gr.ds.unipi.noda.api.core.operators.sortOperators.SortOperator;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;

import java.util.List;
import java.util.Optional;
import java.util.StringJoiner;

final class CassandraOperators extends NoSqlDbOperators {

    private final CassandraConnectionManager cassandraConnectionManager = CassandraConnectionManager.getInstance();
    //to access the database's object for connectivity, call cassandraConnectionManager.getConnection(getNoSqlDbConnector())
    //to access the defined name of collection or table, call  getDataCollection()
    //to access the SparkSession, call getSparkSession()
    private StringJoiner filterList;
    private StringJoiner aggregateList;
    private StringJoiner groupByFieldsList;
    private StringJoiner orderByFieldsList;
    private int limit = 0;
    private StringJoiner projectFieldList;
    private CassandraQueryBuilder queryBuilder;
    private CassandraQueryBuilderDirector queryDirector;


    private CassandraOperators(NoSqlDbConnector noSqlDbConnector, String dataCollection, SparkSession sparkSession) {
        super(noSqlDbConnector, dataCollection, sparkSession);
        this.filterList = new StringJoiner(" AND ");
        this.aggregateList = new StringJoiner(" , ");
        this.groupByFieldsList = new StringJoiner(" , ");
        this.orderByFieldsList = new StringJoiner(" , ");
        this.limit = 0;
        this.projectFieldList = new StringJoiner(" , ");
        this.queryBuilder = new CassandraQueryBuilder();
        this.queryDirector = new CassandraQueryBuilderDirector(this.queryBuilder, getDataCollection());
    }

    static CassandraOperators newCassandraOperators(NoSqlDbConnector noSqlDbConnector, String dataCollection, SparkSession sparkSession){
        return new CassandraOperators(noSqlDbConnector, dataCollection, sparkSession);
    }

    @Override
    public NoSqlDbOperators filter(FilterOperator filterOperator, FilterOperator... filterOperators) {
        expandList(filterOperators,filterOperator,this.filterList);
        return this;
    }

    @Override
    public NoSqlDbOperators groupBy(String fieldName, String... fieldNames) {
        expandList(fieldNames,fieldName,this.groupByFieldsList);
        return this;
    }

    @Override
    public NoSqlDbOperators aggregate(AggregateOperator aggregateOperator, AggregateOperator... aggregateOperators) {
        expandList(aggregateOperators,aggregateOperator,this.aggregateList);
        return this;
    }

    @Override
    public NoSqlDbOperators distinct(String fieldName) {
        throw new UnsupportedOperationException("The distinct operator is not supported by Cassandra");
    }

    @Override
    public void printScreen() {
        String query = queryDirector.makeFullQuery(projectFieldList, aggregateList, filterList, groupByFieldsList, orderByFieldsList, limit);
        List<com.datastax.oss.driver.api.core.cql.Row> results = cassandraConnectionManager.getConnection(getNoSqlDbConnector()).execute(query).all();
        System.out.println("The results of the query are:");
        for (com.datastax.oss.driver.api.core.cql.Row row : results) {
            System.out.println(row.getFormattedContents());
        }
    }

    @Override
    public Optional<Double> max(String fieldName) {
        String query = queryDirector.makeAggregationFunctionQuery("MAX("+fieldName+")",filterList);
        String result = cassandraConnectionManager.getConnection(getNoSqlDbConnector()).execute(query).one().getFormattedContents();
        filterList = new StringJoiner(" AND ");
        return Optional.of(Double.parseDouble(formatResult(result)));
    }

    @Override
    public Optional<Double> min(String fieldName) {
        String query = queryDirector.makeAggregationFunctionQuery("MIN("+fieldName+")",filterList);
        String result = cassandraConnectionManager.getConnection(getNoSqlDbConnector()).execute(query).one().getFormattedContents();
        filterList = new StringJoiner(" AND ");
        return Optional.of(Double.parseDouble(formatResult(result)));
    }

    @Override
    public Optional<Double> sum(String fieldName) {
        String query = queryDirector.makeAggregationFunctionQuery("SUM("+fieldName+")",filterList);
        String result = cassandraConnectionManager.getConnection(getNoSqlDbConnector()).execute(query).one().getFormattedContents();
        filterList = new StringJoiner(" AND ");
        return Optional.of(Double.parseDouble(formatResult(result)));
    }

    @Override
    public Optional<Double> avg(String fieldName) {
        String query = queryDirector.makeAggregationFunctionQuery("AVG("+fieldName+")",filterList);
        String result = cassandraConnectionManager.getConnection(getNoSqlDbConnector()).execute(query).one().getFormattedContents();
        filterList = new StringJoiner(" AND ");
        return Optional.of(Double.parseDouble(formatResult(result)));
    }

    @Override
    public int count() {
        String query = queryDirector.makeAggregationFunctionQuery("COUNT(*)",filterList);
        String result = cassandraConnectionManager.getConnection(getNoSqlDbConnector()).execute(query).one().getFormattedContents();
        filterList = new StringJoiner(" AND ");
        return Integer.parseInt(formatResult(result));
    }

    @Override
    public NoSqlDbOperators sort(SortOperator sortOperator, SortOperator... sortingOperators) {
        expandList(sortingOperators,sortOperator,this.orderByFieldsList);
        return this;
    }

    @Override
    public NoSqlDbOperators limit(int limit) {
        this.limit = limit;
        return this;
    }

    @Override
    public NoSqlDbOperators project(String fieldName, String... fieldNames) {
        expandList(fieldNames, fieldName, this.projectFieldList);
        return this;
    }

    @Override
    public Dataset<Row> toDataframe() {
        return null;
    }

    @Override
    public NoSqlDbOperators join(NoSqlDbOperators noSqlDbOperators, JoinOperator jo) {
        return null;
    }

    @Override
    public NoSqlDbResults getResults() {
        return null;
    }

    private static StringJoiner expandList(Operator[] array, Operator elem, StringJoiner list){
        Operator[] newArray = new Operator[array.length+1];
        newArray[0] = elem;
        System.arraycopy(array, 0, newArray, 1, array.length);
        for(Operator o : newArray){
            list.add(o.getOperatorExpression().toString());
        }
        return list;
    }

    private static StringJoiner expandList(String[] array, String elem, StringJoiner list){
        String[] newArray = new String[array.length+1];
        newArray[0] = elem;
        System.arraycopy(array, 0, newArray, 1, array.length);
        for(String o : newArray){
            list.add(o);
        }
        return list;
    }

    private static String formatResult(String result){
        return result.split(":")[1].replace("]","");
    }

}
