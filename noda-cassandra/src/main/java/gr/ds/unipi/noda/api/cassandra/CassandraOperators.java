package gr.ds.unipi.noda.api.cassandra;

import gr.ds.unipi.noda.api.core.nosqldb.NoSqlDbConnector;
import gr.ds.unipi.noda.api.core.nosqldb.NoSqlDbOperators;
import gr.ds.unipi.noda.api.core.nosqldb.NoSqlDbResults;
import gr.ds.unipi.noda.api.core.nosqldb.modifications.FieldValue;
import gr.ds.unipi.noda.api.core.operators.aggregateOperators.AggregateOperator;
import gr.ds.unipi.noda.api.core.operators.filterOperators.FilterOperator;
import gr.ds.unipi.noda.api.core.operators.joinOperators.JoinOperator;
import gr.ds.unipi.noda.api.core.operators.sortOperators.SortOperator;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;
import java.util.Optional;
import com.datastax.oss.driver.api.core.CqlSession;
import com.datastax.oss.driver.api.core.cql.*;
import com.datastax.oss.driver.api.core.CqlSession;
import java.util.ArrayList;
import java.util.Collections;

final class CassandraOperators extends NoSqlDbOperators {

    private final CassandraConnectionManager cassandraConnectionManager = CassandraConnectionManager.getInstance();
    //to access the database's object for connectivity, call cassandraConnectionManager.getConnection(getNoSqlDbConnector())
    //to access the defined name of collection or table, call  getDataCollection()
    //to access the SparkSession, call getSparkSession()
    private ArrayList<String> filterList;
    private ArrayList<String> aggregateList;

    private CassandraOperators(NoSqlDbConnector noSqlDbConnector, String dataCollection, SparkSession sparkSession) {
        super(noSqlDbConnector, dataCollection, sparkSession);
        this.filterList = new ArrayList<String>();
        this.aggregateList = new ArrayList<String>();
    }

    static CassandraOperators newCassandraOperators(NoSqlDbConnector noSqlDbConnector, String dataCollection, SparkSession sparkSession){
        return new CassandraOperators(noSqlDbConnector, dataCollection, sparkSession);
    }

    @Override
    public NoSqlDbOperators filter(FilterOperator filterOperator, FilterOperator... filterOperators) {
        FilterOperator[] filterOperatorsArray = new FilterOperator[filterOperators.length+1];
        filterOperatorsArray[0] = filterOperator;
        System.arraycopy(filterOperators, 0, filterOperatorsArray, 1, filterOperators.length);
        for(FilterOperator filtOper : filterOperatorsArray) {
            this.filterList.add(filtOper.getOperatorExpression().toString());
        }
        return this;
    }

    @Override
    public NoSqlDbOperators groupBy(String fieldName, String... fieldNames) {
        return null;
    }

    @Override
    public NoSqlDbOperators aggregate(AggregateOperator aggregateOperator, AggregateOperator... aggregateOperators) {
        AggregateOperator[] aggregateOperatorsArray = new AggregateOperator[aggregateOperators.length+1];
        aggregateOperatorsArray[0] = aggregateOperator;
        System.arraycopy(aggregateOperators, 0, aggregateOperatorsArray, 1, aggregateOperators.length);
        for(AggregateOperator aggrOper : aggregateOperatorsArray) {
            this.aggregateList.add(aggrOper.getOperatorExpression().toString());
        }
        return this;
    }

    @Override
    public NoSqlDbOperators distinct(String fieldName) {
        return null;
    }

    @Override
    public void printScreen() {
        StringBuilder query = new StringBuilder();
        //Create the select clause
        query.append("SELECT ");
        query.append(aggregateList.toString().replace("[", "").replace("]", ""));
        query.append(" FROM ");
        query.append(getDataCollection());
        query.append(" ");
        if(filterList.size() > 0) {
            query.append("WHERE ");
            //Create the where clause
            StringBuilder whereClause = new StringBuilder();
            for (String filterOperator : filterList){
                whereClause.append(filterOperator);
            }
            query.append(whereClause);
        }
        query.append(" ALLOW FILTERING;");
        //Print the results
        ResultSet rs = cassandraConnectionManager.getConnection(getNoSqlDbConnector()).execute(query.toString());
        System.out.println("THE RESULTS ARE:");
        for(com.datastax.oss.driver.api.core.cql.Row row : rs){
            System.out.println(row.getFormattedContents());
        }
    }

    @Override
    public Optional<Double> max(String fieldName) {
        //  EXECUTE QUERY HERE TO GET THE MAX
        return null;
    }

    @Override
    public Optional<Double> min(String fieldName) {
        return Optional.empty();
    }

    @Override
    public Optional<Double> sum(String fieldName) {
        return Optional.empty();
    }

    @Override
    public Optional<Double> avg(String fieldName) {
        return Optional.empty();
    }

    @Override
    public int count() {
        return 0;
    }

    @Override
    public NoSqlDbOperators sort(SortOperator sortOperator, SortOperator... sortingOperators) {
        return null;
    }

    @Override
    public NoSqlDbOperators limit(int limit) {
        return null;
    }

    @Override
    public NoSqlDbOperators project(String fieldName, String... fieldNames) {
        return null;
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
}
