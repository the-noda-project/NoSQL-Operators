package gr.ds.unipi.noda.api.neo4j;

import gr.ds.unipi.noda.api.core.nosqldb.NoSqlDbConnector;
import gr.ds.unipi.noda.api.core.nosqldb.NoSqlDbOperators;
import gr.ds.unipi.noda.api.core.nosqldb.NoSqlDbResults;
import gr.ds.unipi.noda.api.core.operators.aggregateOperators.AggregateOperator;
import gr.ds.unipi.noda.api.core.operators.filterOperators.FilterOperator;
import gr.ds.unipi.noda.api.core.operators.joinOperators.JoinOperator;
import gr.ds.unipi.noda.api.core.operators.sortOperators.SortOperator;
import org.apache.spark.sql.*;
import org.neo4j.driver.Record;
import org.neo4j.driver.Result;
import org.neo4j.driver.Session;
import org.neo4j.spark.*;
import scala.Predef;
import scala.Tuple2;
import scala.collection.JavaConverters;

import java.util.*;


final class Neo4jOperators extends NoSqlDbOperators {

    private final Neo4jConnectionManager neo4jConnectionManager = Neo4jConnectionManager.getInstance();

    private final StringBuilder sb;
    private final boolean isTypeOfResultsList;
    private final boolean hasGroupBy;
    private final boolean hasAlreadyAggregate;


    private Neo4jOperators(NoSqlDbConnector connector, String s, SparkSession sparkSession) {
        super(connector, s, sparkSession);
        s.split(";");
        this.sb = new StringBuilder().append("MATCH " + "(s:" + s + ")");
        this.isTypeOfResultsList = true;
        this.hasGroupBy = false;
        this.hasAlreadyAggregate = false;

    }

    private Neo4jOperators(Neo4jOperators neo4jOperators, StringBuilder s, boolean isTypeOfResultsList, boolean hasGroupBy, boolean hasAlreadyAggregate) {
        super(neo4jOperators.getNoSqlDbConnector(), neo4jOperators.getDataCollection(), neo4jOperators.getSparkSession());
        this.sb = s;
        this.isTypeOfResultsList = isTypeOfResultsList;
        this.hasGroupBy = hasGroupBy;
        this.hasAlreadyAggregate = hasAlreadyAggregate;
    }

    static Neo4jOperators newNeo4jOperators(NoSqlDbConnector connector, String s, SparkSession sparkSession) {
        return new Neo4jOperators(connector, s, sparkSession);
    }

    private StringBuilder getStringBuilderCopy() {
        return new StringBuilder(sb);
    }

    @Override
    public NoSqlDbOperators filter(FilterOperator filterOperator, FilterOperator... filterOperators) {
        StringBuilder sbCopy = getStringBuilderCopy();
        filterOperator.getOperatorExpression();
        sbCopy.append(" WHERE ");

        if(filterOperators.length > 1) {
            for (FilterOperator fops : filterOperators) {

                sbCopy.append( fops.getOperatorExpression() + " WITH s");

            }
        } else {

            sbCopy.append( filterOperator.getOperatorExpression() + " WITH s");

        }

        return new Neo4jOperators(this, sbCopy, isTypeOfResultsList, hasGroupBy, hasAlreadyAggregate);
    }

    @Override
    public int count() {
        sb.append(" RETURN count(*)");
        System.out.println(sb);

        try {
            Session session = neo4jConnectionManager.getConnection(getNoSqlDbConnector()).session();
            Result result = session.run(sb.toString());
            Record record = result.next();
            session.close();
            System.out.println("Result: ");
            System.out.println(record);
        }finally {}

        return 0;
    }


    @Override
    public NoSqlDbOperators sort(SortOperator sortOperator, SortOperator... sortingOperators) {

        StringBuilder sbCopy = getStringBuilderCopy();
        sbCopy.append(" ");
        if(sortingOperators.length > 1) {
            for (SortOperator sops : sortingOperators) {
                sbCopy.append(sops.getOperatorExpression() + " WITH s");
            }
        } else {
            sbCopy.append(sortOperator.getOperatorExpression() + " WITH s");
            }

        return new Neo4jOperators(this, sbCopy, isTypeOfResultsList, hasGroupBy, hasAlreadyAggregate);
    }

    @Override
    public NoSqlDbOperators limit(int limit) {
        StringBuilder sbCopy = getStringBuilderCopy();
        sbCopy.append(" WITH * LIMIT " + limit);

        try {
            Session session = neo4jConnectionManager.getConnection(getNoSqlDbConnector()).session();
            Result result = session.run(sbCopy.toString());
            Record record = result.next();
            session.close();
            System.out.println("Result: ");
            System.out.println(record);
        }finally {}

        return new Neo4jOperators(this, sbCopy, isTypeOfResultsList, hasGroupBy, hasAlreadyAggregate);
    }

    @Override
    public Optional<Double> max(String fieldName) {
        sb.append(" RETURN max(s." + fieldName + ")");
        System.out.println(sb);

        try {
            Session session = neo4jConnectionManager.getConnection(getNoSqlDbConnector()).session();
            Result result = session.run(sb.toString());
            Record record = result.next();
            session.close();
            System.out.println("Result: ");
            System.out.println(record);
        }finally {}

        return Optional.empty();
    }

    @Override
    public Optional<Double> min(String fieldName) {
        sb.append(" RETURN min(s." + fieldName + ")");
        System.out.println(sb);

        try {
            Session session = neo4jConnectionManager.getConnection(getNoSqlDbConnector()).session();
            Result result = session.run(sb.toString());
            Record record = result.next();
            session.close();
            System.out.println("Result: ");
            System.out.println(record);
        }finally {}

        return Optional.empty();
    }

    @Override
    public Optional<Double> sum(String fieldName) {
        sb.append(" RETURN sum(s." + fieldName + ")");
        System.out.println(sb);

        try {
            Session session = neo4jConnectionManager.getConnection(getNoSqlDbConnector()).session();
            Result result = session.run(sb.toString());
            Record record = result.next();
            session.close();
            System.out.println("Result: ");
            System.out.println(record);
        }finally {}

        return Optional.empty();
    }

    @Override
    public Optional<Double> avg(String fieldName) {
        sb.append(" RETURN avg(s." + fieldName + ")");
        System.out.println(sb);

        try {
            Session session = neo4jConnectionManager.getConnection(getNoSqlDbConnector()).session();
            Result result = session.run(sb.toString());
            Record record = result.next();
            session.close();
            System.out.println("Result: ");
            System.out.println(record);
        }finally {}

        return Optional.empty();
    }

    @Override
    public NoSqlDbOperators groupBy(String fieldName, String... fieldNames) {
        StringBuilder sbCopy = getStringBuilderCopy();
        sbCopy.append(" WITH s." + fieldName + " as " + fieldName );

            if(fieldNames.length != 0) {
                Integer i = 0;

                for (String fie: fieldNames) {
                    i++;
                    sbCopy.append(", s." + fie + " AS " + fie);
                }
            }

        return new Neo4jOperators(this, sbCopy, false, true, hasAlreadyAggregate);
    }

    @Override
    public NoSqlDbOperators aggregate(AggregateOperator aggregateOperator, AggregateOperator... aggregateOperators) {
        StringBuilder sbCopy = getStringBuilderCopy();
        if(this.hasGroupBy == false && this.hasAlreadyAggregate == false ) {
            sbCopy.append(" WITH " + aggregateOperator.getOperatorExpression() + " as " + aggregateOperator.getAlias());
        } else {
            sbCopy.append(", " + aggregateOperator.getOperatorExpression() + " as " + aggregateOperator.getAlias());
        }

        if(aggregateOperators.length != 0) {
            for (AggregateOperator aggro : aggregateOperators) {
                sbCopy.append(", " + aggro.getOperatorExpression() + " as " + aggro.getAlias() );
            }
        }

        return new Neo4jOperators(this, sbCopy, false, hasGroupBy, true);
    }

    @Override
    public NoSqlDbOperators distinct(String fieldName) {
        return groupBy(fieldName);
    }

    @Override
    public void printScreen() {

        sb.append(" RETURN *");

        System.out.println(sb);

        try {

            Session session = neo4jConnectionManager.getConnection(getNoSqlDbConnector()).session();

            Result result = session.run(sb.toString());

            List<Object> nodeList = new ArrayList<>();

            if(this.isTypeOfResultsList == true){
                while (result.hasNext()) {
                    Record record = result.next();
                    nodeList.add(record.fields().get(0).value().asMap());
                }
            } else {
                while (result.hasNext()) {
                    Record record = result.next();
                    nodeList.add(record.fields());
                }
            }

            session.close();
            System.out.println("Results: ");

            nodeList.forEach((key) -> System.out.println(key));

            System.out.println("Number of results: " + nodeList.size());


        }finally {}

    }

    @Override
    public NoSqlDbOperators project(String fieldName, String... fieldNames) {
        return null;
    }

    public static scala.collection.immutable.Map<String, Object> toScalaMap(HashMap<String, Object> m) {
        return JavaConverters.mapAsScalaMapConverter(m).asScala().toMap(
                Predef.<Tuple2<String, Object>>conforms());

    }


    @Override
    public Dataset<Row> toDataframe() {
        //ΤODO  inside dataframe method use must put the name of the columns
        StringBuilder sbCopy = getStringBuilderCopy();
        sbCopy.append(" RETURN s.vehicle AS vehicle, toString(s.location) AS location, s.date AS date");
        System.out.println(sbCopy);

        //next line commented due to spark-neo4j library connector change
//        Neo4JavaSparkContext neo = Neo4JavaSparkContext.neo4jContext(getSparkSession().sparkContext());
//        long maxId = 50L;
//        Dataset<Row> o = neo.queryDF(sbCopy.toString(), Collections.singletonMap("maxId", maxId));
//
//        o.show();
//
//        o.printSchema();
//
//        System.out.println("--------------------: " + o);
//
//        return o;
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
