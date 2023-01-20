package gr.ds.unipi.noda.api.cassandra;

import gr.ds.unipi.noda.api.core.nosqldb.NoSqlDbConnector;
import gr.ds.unipi.noda.api.core.nosqldb.NoSqlDbOperators;
import gr.ds.unipi.noda.api.core.operators.aggregateOperators.AggregateOperator;
import gr.ds.unipi.noda.api.core.operators.filterOperators.FilterOperator;
import gr.ds.unipi.noda.api.core.operators.joinOperators.JoinOperator;
import gr.ds.unipi.noda.api.core.operators.sortOperators.SortOperator;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;
import java.util.Optional;import com.datastax.oss.driver.api.core.CqlSession;
import com.datastax.oss.driver.api.core.cql.*;
import com.datastax.oss.driver.api.core.CqlSession;
import java.util.ArrayList;
import java.util.Collections;

final class CassandraOperators extends NoSqlDbOperators {

    private final CassandraConnectionManager cassandraConnectionManager = CassandraConnectionManager.getInstance();
    //to access the database's object for connectivity, call cassandraConnectionManager.getConnection(getNoSqlDbConnector())
    //to access the defined name of collection or table, call  getDataCollection()
    //to access the SparkSession, call getSparkSession()
    private ArrayList<String> stageList;

    private CassandraOperators(NoSqlDbConnector noSqlDbConnector, String dataCollection, SparkSession sparkSession) {
        super(noSqlDbConnector, dataCollection, sparkSession);
        this.stageList = new ArrayList<String>();
    }

    static CassandraOperators newCassandraOperators(NoSqlDbConnector noSqlDbConnector, String dataCollection, SparkSession sparkSession){
        return new CassandraOperators(noSqlDbConnector, dataCollection, sparkSession);
    }

    @Override
    public NoSqlDbOperators filter(FilterOperator filterOperator, FilterOperator... filterOperators) {
        this.stageList.add(filterOperator.getOperatorExpression().toString()); //To fix this make all the operators return a String
        return this;
    }

    @Override
    public NoSqlDbOperators groupBy(String fieldName, String... fieldNames) {
        return null;
    }

    @Override
    public NoSqlDbOperators aggregate(AggregateOperator aggregateOperator, AggregateOperator... aggregateOperators) {
        return null;
    }

    @Override
    public NoSqlDbOperators distinct(String fieldName) {
        return null;
    }

    @Override
    public void printScreen() {
        StringBuilder query = new StringBuilder();
        query.append("SELECT * FROM ");
        query.append(getDataCollection().replace("[","").replace("]",""));
        query.append(" WHERE ");
        Collections.reverse(this.stageList);
        for(String operation : this.stageList){
            ResultSet rs = cassandraConnectionManager.getConnection(getNoSqlDbConnector()).execute((new StringBuilder(query).append(operation)).toString());
            for(com.datastax.oss.driver.api.core.cql.Row row : rs){
                System.out.println(row.getInt("id")+" "+row.getString("rndText"));
            }
        }
    }

    @Override
    public Optional<Double> max(String fieldName) {
        return Optional.empty();
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
}
