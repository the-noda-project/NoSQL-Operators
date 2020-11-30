package gr.ds.unipi.noda.api.neo4j;

import gr.ds.unipi.noda.api.core.nosqldb.NoSqlDbConnector;
import gr.ds.unipi.noda.api.core.nosqldb.NoSqlDbOperators;
import gr.ds.unipi.noda.api.core.operators.aggregateOperators.AggregateOperator;
import gr.ds.unipi.noda.api.core.operators.filterOperators.FilterOperator;
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
//    private final String matchConstant;
    private Boolean isTypeOfResultsList;
    private Boolean hasGroupBy;
    private Boolean hasAlreadyAggregate;


    private Neo4jOperators(NoSqlDbConnector connector, String s, SparkSession sparkSession) {
        super(connector, s, sparkSession);
        this.sb = new StringBuilder().append("MATCH " + "(s:" + s + ")");
//        this.matchConstant = "";
        this.isTypeOfResultsList = true;
        this.hasGroupBy = false;
        this.hasAlreadyAggregate = false;

    }

    static Neo4jOperators newNeo4jOperators(NoSqlDbConnector connector, String s, SparkSession sparkSession) {
        return new Neo4jOperators(connector, s, sparkSession);
    }

    @Override
    public NoSqlDbOperators filter(FilterOperator filterOperator, FilterOperator... filterOperators) {
        filterOperator.getOperatorExpression();
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
        sb.append(" WITH * LIMIT " + limit);
        System.out.println(sb);

        try {
            Session session = neo4jConnectionManager.getConnection(getNoSqlDbConnector()).session();
            Result result = session.run(sb.toString());
            Record record = result.next();
            session.close();
            System.out.println("Result: ");
            System.out.println(record);
        }finally {}

        return this;
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

            sb.append(" WITH s." + fieldName + " as " + fieldName );

            if(fieldNames.length != 0) {
                Integer i = 0;

                for (String fie: fieldNames) {
                    i++;
                    sb.append(", s." + fie + " AS " + fie);
                }
            }


//                if(aop.getOperatorExpression() != "count" ){
//                    sb.append(", " + aop.getOperatorExpression() + " AS M" + i);
//                } else {
//                    sb.append(", " + aop.getOperatorExpression() + "(s." + fieldName + ")" + " AS M" + i);
//                }

            this.hasGroupBy = true;
            this.isTypeOfResultsList = false;
//        }

        return this;
    }

    @Override
    public NoSqlDbOperators aggregate(AggregateOperator aggregateOperator, AggregateOperator... aggregateOperators) {

        if(this.hasGroupBy == false && this.hasAlreadyAggregate == false ) {
                sb.append(" WITH " + aggregateOperator.getOperatorExpression() + " as " + aggregateOperator.getAlias());
        } else {
                sb.append(", " + aggregateOperator.getOperatorExpression() + " as " + aggregateOperator.getAlias());
        }

        if(aggregateOperators.length != 0) {
            for (AggregateOperator aggro : aggregateOperators) {
                    sb.append(", " + aggro.getOperatorExpression() + " as " + aggro.getAlias() );
            }
        }

        this.isTypeOfResultsList = false;
        this.hasAlreadyAggregate = true;
        return this;
    }

    @Override
    public NoSqlDbOperators distinct(String fieldName) {
        return groupBy(fieldName);
    }

    @Override
    public void printScreen() {

        sb.append(" RETURN *");

        System.out.println(sb);


//        if(getNoSqlDbConnector() instanceof Neo4jConnector){
//            System.out.println("true");
//        }
//        else{
//            System.out.println("false");
//        }

        try {

            Session session = neo4jConnectionManager.getConnection(getNoSqlDbConnector()).session();

            Result result = session.run(sb.toString());

//            System.out.println("edw" +result);

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
        sb.append(" RETURN s.car_Id AS car_Id, toString(s.location) AS location, s.Timestamp AS Timestamp");
        System.out.println(sb);


        Neo4JavaSparkContext neo = Neo4JavaSparkContext.neo4jContext(getSparkSession().sparkContext());
        long maxId = 50L;
        Dataset<Row> o = neo.queryDF(sb.toString(), Collections.singletonMap("maxId", maxId));

//        o.toJSON().show();
        o.show();

        o.printSchema();

        System.out.println("--------------------: " + o);

//        return o.sort("`s.secondTimestamp`");
        return o;
    }


}
