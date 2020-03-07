package gr.ds.unipi.noda.api.neo4j;

import gr.ds.unipi.noda.api.core.nosqldb.NoSqlDbOperators;
import gr.ds.unipi.noda.api.core.operators.aggregateOperators.AggregateOperator;
import gr.ds.unipi.noda.api.core.operators.filterOperators.FilterOperator;
import gr.ds.unipi.noda.api.core.operators.sortOperators.SortOperator;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;


import java.util.*;

public final class Neo4jOperators implements NoSqlDbOperators {

    private final Neo4jConnectionManager neo4jConnectionManager = Neo4jConnectionManager.getInstance();
    private final Neo4jConnector connector;
    private final String s;
    private final SparkSession sparkSession;

    private Neo4jOperators(Neo4jConnector connector, String s, SparkSession sparkSession) {
        this.connector = connector;
        this.s = s;
        this.sparkSession = sparkSession;
    }

    public static Neo4jOperators newNeo4jOperators(Neo4jConnector connector, String s, SparkSession sparkSession) {
        return new Neo4jOperators(connector, s, sparkSession);
    }

    @Override
    public NoSqlDbOperators filter(FilterOperator filterOperator, FilterOperator... filterOperators) {

        return this;
    }

    @Override
    public int count() {
        return 0;
    }

    @Override
    public NoSqlDbOperators sort(SortOperator sortOperator, SortOperator... sortingOperators) {

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
