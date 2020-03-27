package gr.ds.unipi.noda.api.neo4j;

import gr.ds.unipi.noda.api.core.nosqldb.NoSqlDbOperators;
import javax.swing.text.Document;
import gr.ds.unipi.noda.api.core.operators.aggregateOperators.AggregateOperator;
import gr.ds.unipi.noda.api.core.operators.filterOperators.FilterOperator;
import gr.ds.unipi.noda.api.core.operators.sortOperators.SortOperator;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;
import org.neo4j.driver.Record;
import org.neo4j.driver.Result;
import org.neo4j.driver.Session;
import org.neo4j.driver.Transaction;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public final class Neo4jOperators implements NoSqlDbOperators {

    private final Neo4jConnectionManager neo4jConnectionManager = Neo4jConnectionManager.getInstance();
    private final Neo4jConnector connector;
    private final String s;
    private final SparkSession sparkSession;

    private final StringBuilder sb;
    private final String matchConstant;

    private Neo4jOperators(Neo4jConnector connector, String s, SparkSession sparkSession) {
        this.connector = connector;
        this.s = s;
        this.sparkSession = sparkSession;
        this.sb = new StringBuilder().append("MATCH " + "(s:" + s + ")");
        this.matchConstant = "";
    }

    public static Neo4jOperators newNeo4jOperators(Neo4jConnector connector, String s, SparkSession sparkSession) {
        return new Neo4jOperators(connector, s, sparkSession);
    }

    @Override
    public NoSqlDbOperators filter(FilterOperator filterOperator, FilterOperator... filterOperators) {

        sb.append(" WHERE ");

        if(filterOperators.length > 1) {
            for (FilterOperator fops : filterOperators) {

                sb.append( fops.getOperatorExpression() + " WITH s");

            }
        } else {

            sb.append( filterOperator.getOperatorExpression() + " WITH s");

        }

        return this;
    }

    @Override
    public int count() {
        return 0;
    }

    @Override
    public NoSqlDbOperators sort(SortOperator sortOperator, SortOperator... sortingOperators) {


        sb.append(" ");
        if(sortingOperators.length > 1) {
            for (SortOperator sops : sortingOperators) {
                sb.append(sops.getOperatorExpression() + " WITH s");
            }
        } else {
                sb.append(sortOperator.getOperatorExpression() + " WITH s");
            }

        return this;
    }

    @Override
    public NoSqlDbOperators limit(int limit) {
        return this;
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
    public NoSqlDbOperators groupBy(String fieldName, AggregateOperator... aggregateOperator) {
        return null;
    }

    @Override
    public NoSqlDbOperators distinct(String fieldName) {
        return groupBy(fieldName);
    }

    @Override
    public void printScreen() {

        sb.append(" RETURN s");

        System.out.println(sb);

        try(Session session = neo4jConnectionManager.getConnection(connector).session()) {

            Result result = session.run(sb.toString());

            System.out.println(result);

            List<Map<String,Object>> nodeList=  new ArrayList<>();


            while (result.hasNext())
            {
                Record record = result.next();
                nodeList.add(record.fields().get(0).value().asMap());
            }

            System.out.println("Results: ");

            nodeList.forEach((key) -> System.out.println(key));

            System.out.println("Number of results: " + nodeList.size());

        }

    }

    @Override
    public NoSqlDbOperators project(String fieldName, String... fieldNames) {
        return null;
    }

    @Override
    public Dataset<Row> toDataframe() {
        return null;
    }

}
