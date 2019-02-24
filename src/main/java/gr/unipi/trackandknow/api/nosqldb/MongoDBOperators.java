package gr.unipi.trackandknow.api.nosqldb;

import gr.unipi.trackandknow.api.aggregateOperator.*;
import gr.unipi.trackandknow.api.aggregateOperator.*;
import gr.unipi.trackandknow.api.filterOperator.FilterOperator;
import gr.unipi.trackandknow.api.filterOperator.geographicalOperator.GeographicalOperatorBasedOnSinglePoint;
import gr.unipi.trackandknow.api.filterOperator.geographicalOperator.OperatorNearestNeighbors;
import gr.unipi.trackandknow.api.sortOperator.SortOperator;
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

        if (filterOperator instanceof OperatorNearestNeighbors) {
            stagesList.add(Document.parse(filterOperator.getJsonStringBuilder().toString()));
        } else {
            stagesList.add(Document.parse(" { $match: " + filterOperator.getJsonStringBuilder() + " } "));
        }

        for (FilterOperator fops : filterOperators) {
            if (fops instanceof OperatorNearestNeighbors) {
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
        MongoCursor mc = mongoDBConnectionManager.getConnection(connector).getDatabase(connector.getDatabase()).getCollection(s).aggregate(stagesList).iterator();

        if(mc.hasNext()){
            return ((Document) mc.next()).getInteger("count", -10);
        }

        return 0;
    }

    @Override
    public NoSqlDbOperators sort(SortOperator sortOperator, SortOperator... sortingOperators) {

        StringBuilder sb = new StringBuilder();

        sb.append("{ $sort : ");
        sb.append("{ ");

        sb.append(sortOperator.getJsonStringBuilder());

        for (SortOperator so : sortingOperators) {
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
    public Optional<Double> max(String fieldName) {
        stagesList.add(Document.parse("{ $group: { _id:null, " + OperatorMax.newOperatorMax(fieldName).getJsonStringBuilder() + " } }"));
        MongoCursor mc = mongoDBConnectionManager.getConnection(connector).getDatabase(connector.getDatabase()).getCollection(s).aggregate(stagesList).iterator();
        if(mc.hasNext()){
            return Optional.of(((Document) mc.next()).getDouble("max_" + fieldName));
        }
        return Optional.empty();
    }

    @Override
    public Optional<Double> min(String fieldName) {
        stagesList.add(Document.parse("{ $group: { _id:null, " + OperatorMin.newOperatorMin(fieldName).getJsonStringBuilder() + " } }"));
        MongoCursor mc = mongoDBConnectionManager.getConnection(connector).getDatabase(connector.getDatabase()).getCollection(s).aggregate(stagesList).iterator();
        if(mc.hasNext()){
            return Optional.of(((Document) mc.next()).getDouble("min_" + fieldName));
        }
        return Optional.empty();    }

    @Override
    public Optional<Double> sum(String fieldName) {
        stagesList.add(Document.parse("{ $group: { _id:null, " + OperatorSum.newOperatorSum(fieldName).getJsonStringBuilder() + " } }"));
        MongoCursor mc = mongoDBConnectionManager.getConnection(connector).getDatabase(connector.getDatabase()).getCollection(s).aggregate(stagesList).iterator();
        if(mc.hasNext()){
            return Optional.of(((Document) mc.next()).getDouble("sum_" + fieldName));
        }
        return Optional.empty();    }

    @Override
    public Optional<Double> avg(String fieldName) {
        stagesList.add(Document.parse("{ $group: { _id:null, " + OperatorAvg.newOperatorAvg(fieldName).getJsonStringBuilder() + " } }"));
        MongoCursor mc = mongoDBConnectionManager.getConnection(connector).getDatabase(connector.getDatabase()).getCollection(s).aggregate(stagesList).iterator();
        if(mc.hasNext()){
            return Optional.of(((Document) mc.next()).getDouble("avg_" + fieldName));
        }
        return Optional.empty();    }

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
