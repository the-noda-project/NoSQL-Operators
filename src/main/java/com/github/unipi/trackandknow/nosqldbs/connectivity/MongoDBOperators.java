package com.github.unipi.trackandknow.nosqldbs.connectivity;

import com.github.unipi.trackandknow.nosqldbs.aggregateOperator.AggregateOperator;
import com.github.unipi.trackandknow.nosqldbs.aggregateOperator.OperatorMax;
import com.github.unipi.trackandknow.nosqldbs.filterOperator.FilterOperator;
import com.mongodb.client.MongoCursor;
import com.mongodb.spark.MongoSpark;
import com.mongodb.spark.config.ReadConfig;
import com.mongodb.spark.rdd.api.java.JavaMongoRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;
import org.bson.Document;
import org.bson.conversions.Bson;
import scala.collection.JavaConverters;
import scala.collection.Seq;

import java.util.*;

import static com.mongodb.client.model.Filters.eq;
import static java.util.Collections.singletonList;

final class MongoDBOperators implements NoSqlDbOperators {

    private final MongoDBConnectionManager mongoDBConnectionManager = MongoDBConnectionManager.getInstance();
    private final MongoDBConnector connector;
    private final String s;
    private final SparkSession sparkSession;
    private final List<Bson> stagesList;

    private MongoDBOperators(MongoDBConnector connector, String s, SparkSession sparkSession){
        this.connector = connector;
        this.s = s;
        this.sparkSession = sparkSession;
        stagesList = new ArrayList<>();
    }

    public static MongoDBOperators newMongoDBOperators(MongoDBConnector connector, String s, SparkSession sparkSession){
        return new MongoDBOperators(connector, s, sparkSession);
    }

    @Override
    public NoSqlDbOperators filter(FilterOperator filterOperator) {
        System.out.println(filterOperator.getJsonStringBuilder());
        stagesList.add(Document.parse(" { $match: " + filterOperator.getJsonStringBuilder() + " } "));
        return this;
    }

//    @Override
//    public void execute(){
//        MongoCursor<Document> cursor = mongoCollection.aggregate(stagesList).iterator();
//        try {
//            while (cursor.hasNext()) {
//                System.out.println(cursor.next().toJson());
//            }
//        } finally {
//            cursor.close();
//        }
//    }

    @Override
    public int count(){
        stagesList.add(Document.parse("{ $count: \"count\" }"));
        System.out.println("Database Name "+connector.getDatabase());
        System.out.println("111111111 "+connector.getDatabase());
        //System.out.println("mongoDBConnectionManager.getConnection(connector) "+mongoDBConnectionManager.getConnection(connector));
        return ((Document) mongoDBConnectionManager.getConnection(connector).getDatabase(connector.getDatabase()).getCollection(s).aggregate(stagesList).first()).getInteger("count",-10);
    }

    @Override
    public double max(String fieldName){

        //System.out.println(Aggregates.match(Filter.parse(FilterOperators.gte("categories", 6).getJsonString())));
        //System.out.println(Aggregates.match(Filters.eq("categories", "Bakery")).toString());

        //stagesList.add(Document.parse(" { $project : {$max: \"id\"} }"));
        //mongoCollection.aggregate(stagesList).first();

        //stagesList.add(Aggregates.project(Document.parse("{$max: \"id\"}")));
        //stagesList.add(new Document("$match", Document.parse(FilterOperators.eq("r",4).getJsonString())));

        //stagesList.add(Document.parse("{ $group: { _id:null, max: { $max: \"$location.coordinates.1\" }} }"));


        stagesList.add(Document.parse("{ $group: { _id:null, "+ OperatorMax.newOperatorMax(fieldName).getJsonStringBuilder() +" } }"));



//        stagesList.add(Document.parse("{ $group: { _id:null, max: { $min: { $arrayElemAt: [ \"$location.coordinates\", 0 ] } }} }"));
//        stagesList.add(Document.parse("{ $project: { dfd: { $min: { $arrayElemAt: [ \"$location.coordinates\", 0 ] } }} }"));

        //System.out.println(Document.parse(" { $project: " + OperatorMax.newOperatorMax(fieldName,"max_"+fieldName).getJsonString() + " } "));
//        stagesList.add(Document.parse(" { $project: " + OperatorMax.newOperatorMax(fieldName,"maxf").getJsonString() + " } "));
//        stagesList.add(Document.parse("{ $count: \"maxf\" }"));
        //System.out.println(((Document) mongoCollection.aggregate(stagesList).first()).getString("maxf"));

        //System.out.println(new Document("$match", FilterOperators.eq("r",4).getJsonString()).toString());


//        MongoCursor<Document> cursor = mongoCollection.aggregate(stagesList).iterator();
//        try {
//            while (cursor.hasNext()) {
//                System.out.println(cursor.next().toJson());
//            }
//        } finally {
//            cursor.close();
//        }
//        System.out.println("dfddffdfd");

        //Aggregates.project()
        //stagesList.add(Document.parse(new Document("$project", AggregateOperators.max(fieldName).getJsonString()).toJson()));

        //System.out.println(new Document("$project", AggregateOperators.max(fieldName).getJsonString()));

        return ((Document) mongoDBConnectionManager.getConnection(connector).getDatabase(connector.getDatabase()).getCollection(s).aggregate(stagesList).first()).getDouble("max("+fieldName+")");
        //return 4;
    }

//    private FilterOperator getFilter(){
//
//        if(filterOperatorList.size()==0){
//            return null;
//        }
//        else if(filterOperatorList.size()==1){
//            return filterOperatorList.get(0);
//        }
//        else{
//            return FilterOperators.and((FilterOperator[]) filterOperatorList.stream().toArray());
//        }
//
//    }

//    @Override
//    public void aggregate(AggregateOperator... aggregateOperator){
//
//        List<Bson> bsonList = new ArrayList<>();
//        FilterOperator fop = getFilter();
//
//        if(fop != null){
//            bsonList.add(Document.parse("{ $match: {" + getFilter().getJsonString() + "} }"));
//        }
//
//        for(AggregateOperator aop : aggregateOperator){
//            bsonList.add(Document.parse(aop.getJsonString()));
//        }
//
//        mongoCollection.aggregate(bsonList);
//
//    }

    @Override
    public NoSqlDbOperators groupBy(String fieldName, AggregateOperator... aggregateOperator){

        StringBuilder sb =  new StringBuilder();

        sb.append("{ $group: ");

        sb.append("{ _id:");
        sb.append("\"" + "$" + fieldName + "\"");

        if(aggregateOperator.length != 0){
            for(AggregateOperator aop : aggregateOperator){
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
    public void project() {
        System.out.println(stagesList.toString());
    }

//    SparkSession spark = SparkSession.builder()
//            .master("local")
//            .appName("MongoSparkConnectorIntro")
//            .config("spark.mongodb.input.uri", "mongodb://127.0.0.1/test.myCollection")
//            .getOrCreate();

    @Override
    public Dataset<Row> toDataframe() {

        //System.setProperty("spark.mongodb.input.uri", "mongodb://1.1.1.1:27017/test.points");

//        SparkSession spark = SparkSession.builder()
//                .master("local")
//                .appName("MongoSparkConnectorIntro")
//                //.config("spark.mongodb.input.uri", "mongodb://1.1.1.1:27017/test.points ")
//                .getOrCreate();

        //JavaSparkContext jsc = new JavaSparkContext(spark.sparkContext());

//        System.setProperty("spark.mongodb.input.uri", "mongodb://localhost:27017/");
//        System.setProperty("spark.mongodb.input.database", "test");
//        System.setProperty("spark.mongodb.input.collection", "points");

        Map<String, String> readOverrides = new HashMap<>();
        readOverrides.put("spark.mongodb.input.uri", connector.getMongoURIForSparkSession());
        readOverrides.put("spark.mongodb.input.database", connector.getDatabase());
        readOverrides.put("spark.mongodb.input.collection", s);

//        readOverrides.put("collection", "points");





//        ReadConfig readConfig = ReadConfig.create(jsc).withOptions(readOverrides);
//        JavaMongoRDD<Document> customRdd = MongoSpark.load(jsc, readConfig);
        ReadConfig readConfig = ReadConfig.create(sparkSession).withOptions(readOverrides).withPipeline(JavaConverters.asScalaIteratorConverter(stagesList.iterator()).asScala().toSeq());




        return MongoSpark.loadAndInferSchema(sparkSession,readConfig);
        //return customRdd.toDF();

//
//
//        JavaSparkContext jsc = new JavaSparkContext(spark.sparkContext());
//
//        MongoSpark.load(spark,readConfig);
//        MongoSpark.load
//
//        JavaMongoRDD<Document> rdd = MongoSpark.load(jsc).withPipeline(stagesList);
//
//
//
//        return aggregatedRdd.toDF();


    }

}
