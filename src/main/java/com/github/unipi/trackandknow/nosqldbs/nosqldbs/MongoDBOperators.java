package com.github.unipi.trackandknow.nosqldbs.nosqldbs;

import com.github.unipi.trackandknow.nosqldbs.aggregateOperator.*;
import com.github.unipi.trackandknow.nosqldbs.filterOperator.FilterOperator;
import com.github.unipi.trackandknow.nosqldbs.filterOperator.geographicalOperator.GeographicalOperatorBasedOnSinglePoint;
import com.github.unipi.trackandknow.nosqldbs.sortOperator.SortingOperator;
import com.mongodb.client.MongoCursor;
import com.mongodb.spark.MongoSpark;
import com.mongodb.spark.config.ReadConfig;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;
import org.bson.Document;
import org.bson.conversions.Bson;
import scala.collection.JavaConversions;

import java.util.*;

final class MongoDBOperators implements NoSqlDbOperators {

    private final MongoDBConnectionManager mongoDBConnectionManager = MongoDBConnectionManager.getInstance();
    private final MongoDBConnector connector;
    private final String s;
    private final SparkSession sparkSession;
    private final List<Bson> stagesList;

    private MongoDBOperators(MongoDBConnector connector, String s, SparkSession sparkSession) {
        this.connector = connector;
        this.s = s;
        this.sparkSession = sparkSession;
        stagesList = new ArrayList<>();
    }

    public static MongoDBOperators newMongoDBOperators(MongoDBConnector connector, String s, SparkSession sparkSession) {
        return new MongoDBOperators(connector, s, sparkSession);
    }

    @Override
    public NoSqlDbOperators filter(FilterOperator filterOperator, FilterOperator... filterOperators) {

        if (filterOperator instanceof GeographicalOperatorBasedOnSinglePoint) {
            stagesList.add(Document.parse(filterOperator.getJsonStringBuilder().toString()));
        } else {
            stagesList.add(Document.parse(" { $match: " + filterOperator.getJsonStringBuilder() + " } "));
        }

        for (FilterOperator fops : filterOperators) {

            if (fops instanceof GeographicalOperatorBasedOnSinglePoint) {
                stagesList.add(Document.parse(fops.getJsonStringBuilder().toString()));
            } else {
                stagesList.add(Document.parse(" { $match: " + fops.getJsonStringBuilder() + " } "));
            }

        }

        return this;
    }

    @Override
    public int count() {
        stagesList.add(Document.parse("{ $count: \"count\" }"));
        return ((Document) mongoDBConnectionManager.getConnection(connector).getDatabase(connector.getDatabase()).getCollection(s).aggregate(stagesList).first()).getInteger("count", -10);
    }

    @Override
    public NoSqlDbOperators sort(SortingOperator sortingOperator, SortingOperator... sortingOperators) {

        StringBuilder sb = new StringBuilder();

        sb.append("{ $sort : ");
        sb.append("{ ");

        sb.append(sortingOperator.getJsonStringBuilder());

        for (SortingOperator so : sortingOperators) {
            sb.append(", ");
            sb.append(so.getJsonStringBuilder());
        }

        sb.append(" } }");

        stagesList.add(Document.parse(sb.toString()));

        return this;
    }

    @Override
    public NoSqlDbOperators limit(int limit) {
        stagesList.add(Document.parse("{ $limit: " + limit + " }"));
        return this;
    }

    @Override
    public double max(String fieldName) {
        stagesList.add(Document.parse("{ $group: { _id:null, " + OperatorMax.newOperatorMax(fieldName).getJsonStringBuilder() + " } }"));
        return ((Document) mongoDBConnectionManager.getConnection(connector).getDatabase(connector.getDatabase()).getCollection(s).aggregate(stagesList).first()).getDouble("max_" + fieldName);
    }

    @Override
    public double min(String fieldName) {
        stagesList.add(Document.parse("{ $group: { _id:null, " + OperatorMin.newOperatorMin(fieldName).getJsonStringBuilder() + " } }"));
        return ((Document) mongoDBConnectionManager.getConnection(connector).getDatabase(connector.getDatabase()).getCollection(s).aggregate(stagesList).first()).getDouble("min_" + fieldName);
    }

    @Override
    public double sum(String fieldName) {
        stagesList.add(Document.parse("{ $group: { _id:null, " + OperatorSum.newOperatorSum(fieldName).getJsonStringBuilder() + " } }"));
        return ((Document) mongoDBConnectionManager.getConnection(connector).getDatabase(connector.getDatabase()).getCollection(s).aggregate(stagesList).first()).getDouble("sum_" + fieldName);
    }

    @Override
    public double avg(String fieldName) {
        stagesList.add(Document.parse("{ $group: { _id:null, " + OperatorAvg.newOperatorAvg(fieldName).getJsonStringBuilder() + " } }"));
        return ((Document) mongoDBConnectionManager.getConnection(connector).getDatabase(connector.getDatabase()).getCollection(s).aggregate(stagesList).first()).getDouble("avg_" + fieldName);
    }

    @Override
    public NoSqlDbOperators groupBy(String fieldName, AggregateOperator... aggregateOperator) {

        StringBuilder sb = new StringBuilder();

        sb.append("{ $group: ");

        sb.append("{ _id:");
        sb.append("\"" + "$" + fieldName + "\"");

        if (aggregateOperator.length != 0) {
            for (AggregateOperator aop : aggregateOperator) {
                sb.append(", " + aop.getJsonStringBuilder());
            }
        }

        sb.append(" } }");

        stagesList.add(Document.parse(sb.toString()));

        return this;
    }

    @Override
    public NoSqlDbOperators distinct(String fieldName) {
        return groupBy(fieldName);
    }

    @Override
    public void printScreen() {
        MongoCursor<Document> cursor = mongoDBConnectionManager.getConnection(connector).getDatabase(connector.getDatabase()).getCollection(s).aggregate(stagesList).iterator();
        try {
            while (cursor.hasNext()) {
                System.out.println(cursor.next().toJson());
            }
        } finally {
            cursor.close();
        }
    }

    @Override
    public NoSqlDbOperators project(String fieldName, String... fieldNames) {

        StringBuilder sb = new StringBuilder();
        sb.append("{ $project : { ");

        sb.append("_id : 0, ");

        sb.append(fieldName + " : 1");

        for (String s : fieldNames) {
            sb.append(", ");
            sb.append(fieldName + " : 1");
        }

        sb.append(" } }");

        stagesList.add(Document.parse(sb.toString()));

        return this;

    }

    @Override
    public Dataset<Row> toDataframe() {

        Map<String, String> readOverrides = new HashMap<>();
        readOverrides.put("spark.mongodb.input.uri", connector.getMongoURIForSparkSession());
        readOverrides.put("spark.mongodb.input.database", connector.getDatabase());
        readOverrides.put("spark.mongodb.input.collection", s);

        ReadConfig readConfig = ReadConfig.create(sparkSession).withOptions(readOverrides).withPipeline(JavaConversions.asScalaBuffer(Collections.unmodifiableList(stagesList)).toSeq());

        return MongoSpark.loadAndInferSchema(sparkSession, readConfig);

    }

}
