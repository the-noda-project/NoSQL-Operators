package gr.ds.unipi.noda.api.mongo;

import com.mongodb.MongoClient;
import com.mongodb.MongoDriverInformation;
import com.mongodb.client.MongoCursor;
import com.mongodb.spark.MongoSpark;
import com.mongodb.spark.config.ReadConfig;
import gr.ds.unipi.noda.api.core.nosqldb.NoSqlDbConnector;
import gr.ds.unipi.noda.api.core.nosqldb.NoSqlDbOperators;
import gr.ds.unipi.noda.api.core.operators.aggregateOperators.AggregateOperator;
import gr.ds.unipi.noda.api.core.operators.filterOperators.FilterOperator;
import gr.ds.unipi.noda.api.core.operators.sortOperators.SortOperator;
import gr.ds.unipi.noda.api.core.nosqldb.NoSQLExpression;
import gr.ds.unipi.noda.api.mongo.filterOperators.geoperators.geographicalOperators.MongoDBGeographicalOperatorFactory;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;
import org.bson.BsonDocument;
import org.bson.Document;
import org.bson.conversions.Bson;
import scala.collection.JavaConversions;

import java.util.*;

final class MongoDBOperators extends NoSqlDbOperators {

    private final MongoDBConnectionManager mongoDBConnectionManager = MongoDBConnectionManager.getInstance();
    private final List<Bson> stagesList;
    private final String database;
    private final String uriSparkSession;

    private MongoDBOperators(NoSqlDbConnector connector, String s, SparkSession sparkSession) {
        super(connector, s, sparkSession);
        stagesList = new ArrayList<>();
        MongoDBConnector mongoDBConnector = ((MongoDBConnector) connector);
        database = mongoDBConnector.getDatabase();
        uriSparkSession = mongoDBConnector.getMongoURIForSparkSession();
    }

    private MongoDBOperators(MongoDBOperators mongoDBOperators, List<Bson> stagesList){
        super(mongoDBOperators.getNoSqlDbConnector(), mongoDBOperators.getDataCollection(), mongoDBOperators.getSparkSession());
        this.stagesList = stagesList;
        this.database = mongoDBOperators.getDatabase();
        this.uriSparkSession = mongoDBOperators.getUriSparkSession();
    }

    private String getDatabase(){
        return database;
    }

    private String getUriSparkSession(){
        return uriSparkSession /*+ getDataCollection()*/;
    }

    static MongoDBOperators newMongoDBOperators(NoSqlDbConnector connector, String s, SparkSession sparkSession) {
        return new MongoDBOperators(connector, s, sparkSession);
    }

    private void formExpressionOfNoSQL(){
        StringBuilder expression = new StringBuilder();

        expression.append("db."+getDataCollection()+".aggregate([ ");
        stagesList.forEach(i-> {
            i.toBsonDocument(BsonDocument.class, MongoClient.getDefaultCodecRegistry()).toJson();
            expression.append(", ");
        });
        if(expression.lastIndexOf(", ") != -1){
            expression.deleteCharAt(expression.lastIndexOf(", "));
        }
        expression.append(" )]");

        NoSQLExpression.INSTANCE.setExpression(expression.toString());
    }

    @Override
    public NoSqlDbOperators filter(FilterOperator filterOperator, FilterOperator... filterOperators) {
        List<Bson> sl =new ArrayList<>(stagesList);
        if (MongoDBGeographicalOperatorFactory.isOperatorGeoNearestNeighbor(filterOperator)) {
            sl.add(Document.parse(filterOperator.getOperatorExpression().toString()));
        } else {
            sl.add(Document.parse(" { $match: " + filterOperator.getOperatorExpression() + " } "));
        }

        for (FilterOperator fops : filterOperators) {
            if (MongoDBGeographicalOperatorFactory.isOperatorGeoNearestNeighbor(fops)) {
                sl.add(Document.parse(fops.getOperatorExpression().toString()));
            } else {
                sl.add(Document.parse(" { $match: " + fops.getOperatorExpression() + " } "));
            }
        }
        return new MongoDBOperators(this, sl);
    }

    @Override
    public int count() {
        stagesList.add(Document.parse("{ $count: \"count\" }"));
        MongoCursor mc = mongoDBConnectionManager.getConnection(getNoSqlDbConnector()).getDatabase(database).getCollection(getDataCollection()).aggregate(stagesList).iterator();

        formExpressionOfNoSQL();

        if (mc.hasNext()) {
            return ((Document) mc.next()).getInteger("count", -10);
        }

        return 0;
    }

    @Override
    public NoSqlDbOperators sort(SortOperator sortOperator, SortOperator... sortingOperators) {

        List<Bson> sl =new ArrayList<>(stagesList);

        StringBuilder sb = new StringBuilder();

        sb.append("{ $sort : ");
        sb.append("{ ");

        sb.append(sortOperator.getOperatorExpression());

        for (SortOperator so : sortingOperators) {
            sb.append(", ");
            sb.append(so.getOperatorExpression());
        }

        sb.append(" } }");

        sl.add(Document.parse(sb.toString()));

        return new MongoDBOperators(this, sl);
    }

    @Override
    public NoSqlDbOperators limit(int limit) {
        List<Bson> sl =new ArrayList<>(stagesList);
        sl.add(Document.parse("{ $limit: " + limit + " }"));
        return new MongoDBOperators(this, sl);
    }

    @Override
    public Optional<Double> max(String fieldName) {
        stagesList.add(Document.parse("{ $group: { _id:null, " + AggregateOperator.aggregateOperator.newOperatorMax(fieldName).getOperatorExpression() + " } }"));
        MongoCursor mc = mongoDBConnectionManager.getConnection(getNoSqlDbConnector()).getDatabase(database).getCollection(getDataCollection()).aggregate(stagesList).iterator();

        formExpressionOfNoSQL();

        if (mc.hasNext()) {
            return Optional.of(((Document) mc.next()).getDouble("max_" + fieldName));
        }
        return Optional.empty();
    }

    @Override
    public Optional<Double> min(String fieldName) {
        stagesList.add(Document.parse("{ $group: { _id:null, " + AggregateOperator.aggregateOperator.newOperatorMin(fieldName).getOperatorExpression() + " } }"));
        MongoCursor mc = mongoDBConnectionManager.getConnection(getNoSqlDbConnector()).getDatabase(database).getCollection(getDataCollection()).aggregate(stagesList).iterator();

        formExpressionOfNoSQL();

        if (mc.hasNext()) {
            return Optional.of(((Document) mc.next()).getDouble("min_" + fieldName));
        }
        return Optional.empty();
    }

    @Override
    public Optional<Double> sum(String fieldName) {
        stagesList.add(Document.parse("{ $group: { _id:null, " + AggregateOperator.aggregateOperator.newOperatorSum(fieldName).getOperatorExpression() + " } }"));
        MongoCursor mc = mongoDBConnectionManager.getConnection(getNoSqlDbConnector()).getDatabase(database).getCollection(getDataCollection()).aggregate(stagesList).iterator();

        formExpressionOfNoSQL();

        if (mc.hasNext()) {
            return Optional.of(((Document) mc.next()).getDouble("sum_" + fieldName));
        }
        return Optional.empty();
    }

    @Override
    public Optional<Double> avg(String fieldName) {
        stagesList.add(Document.parse("{ $group: { _id:null, " + AggregateOperator.aggregateOperator.newOperatorAvg(fieldName).getOperatorExpression() + " } }"));
        MongoCursor mc = mongoDBConnectionManager.getConnection(getNoSqlDbConnector()).getDatabase(database).getCollection(getDataCollection()).aggregate(stagesList).iterator();

        formExpressionOfNoSQL();

        if (mc.hasNext()) {
            return Optional.of(((Document) mc.next()).getDouble("avg_" + fieldName));
        }
        return Optional.empty();
    }

    @Override
    public NoSqlDbOperators groupBy(String fieldName, String... fieldNames) {
        List<Bson> sl =new ArrayList<>(stagesList);

        StringBuilder sb = new StringBuilder();

        sb.append("{ $group: ");
        sb.append("{ _id: {");

        sb.append(fieldName + ": " + "\"" + "$" + fieldName + "\"");

        if (fieldNames.length != 0) {
            for (String fn : fieldNames) {
                sb.append(",");
                sb.append(fieldName + ": " + "\"" + "$" + fieldName + "\"");
            }
        }

        sb.append("}");

        sb.append(" } }");

        sl.add(Document.parse(sb.toString()));

        return new MongoDBOperators(this, sl);
    }

    @Override
    public NoSqlDbOperators aggregate(AggregateOperator aggregateOperator, AggregateOperator... aggregateOperators) {
        List<Bson> sl =new ArrayList<>(stagesList);

        if (sl.size() > 0 && ((Document) sl.get(sl.size() - 1)).containsKey("$group")) {

            StringBuilder sb = new StringBuilder();

            Document document = (Document) sl.get(sl.size() - 1);
            String json = document.toJson();
            sb.append(json, 0, json.length() - 3);

            sb.append(aggregateOperator.getOperatorExpression());

            if (aggregateOperators.length != 0) {
                for (AggregateOperator aop : aggregateOperators) {
                    sb.append(", " + aop.getOperatorExpression());
                }
            }

            sb.append(" } }");
            sl.add(Document.parse(sb.toString()));

        } else {
            StringBuilder sb = new StringBuilder();
            sb.append("{ $group: ");

            sb.append("{ _id: null ");

            sb.append(", " + aggregateOperator.getOperatorExpression());

            if (aggregateOperators.length != 0) {
                for (AggregateOperator aop : aggregateOperators) {
                    sb.append(", " + aop.getOperatorExpression());
                }
            }

            sb.append(" } }");
            sl.add(Document.parse(sb.toString()));
        }

        return new MongoDBOperators(this, sl);
    }

    @Override
    public NoSqlDbOperators distinct(String fieldName) {
        return groupBy(fieldName);
    }

    @Override
    public void printScreen() {
        MongoCursor<Document> cursor = mongoDBConnectionManager.getConnection(getNoSqlDbConnector()).getDatabase(database).getCollection(getDataCollection()).aggregate(stagesList).iterator();

        formExpressionOfNoSQL();

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
        List<Bson> sl =new ArrayList<>(stagesList);

        StringBuilder sb = new StringBuilder();
        sb.append("{ $project : { ");

        sb.append("\"_id\" : 0, ");

        sb.append("\"" + fieldName + "\"" + " : 1");

        for (String s : fieldNames) {
            sb.append(", ");
            sb.append("\"" + s + "\"" + " : 1");
        }

        sb.append(" } }");

        sl.add(Document.parse(sb.toString()));
        return new MongoDBOperators(this, sl);

    }

    @Override
    public Dataset<Row> toDataframe() {
        //MongoDriverInformation m = MongoDriverInformation.builder().driverName("mongo-java-driver").driverVersion("3.12.5").driverPlatform("Java 1.8").build();
        Map<String, String> readOverrides = new HashMap<>();
        //readOverrides.put("spark.mongodb.input.uri", uriSparkSession);
        //readOverrides.put("spark.mongodb.input.database", getDatabase());
        //System.out.println(uriSparkSession);
        //readOverrides.put("spark.mongodb.input.database", database);
        //readOverrides.put("spark.mongodb.input.collection", getDataCollection());
        ReadConfig readConfig = ReadConfig.create(getSparkSession()).withOptions(readOverrides).withPipeline(JavaConversions.asScalaBuffer(Collections.unmodifiableList(stagesList)).toSeq());
        /*Dataset<Row> df =*/return MongoSpark.loadAndInferSchema(getSparkSession(), readConfig);
        //formExpressionOfNoSQL();
        //return df;
    }
}
