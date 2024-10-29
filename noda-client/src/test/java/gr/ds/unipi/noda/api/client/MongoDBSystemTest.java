package gr.ds.unipi.noda.api.client;

import gr.ds.unipi.noda.api.core.nosqldb.NoSqlDbOperators;
import gr.ds.unipi.noda.api.core.nosqldb.modifications.FieldValue;
import gr.ds.unipi.noda.api.core.nosqldb.modifications.NoSqlDbDeletes;
import gr.ds.unipi.noda.api.core.nosqldb.modifications.NoSqlDbInserts;
import gr.ds.unipi.noda.api.core.nosqldb.modifications.NoSqlDbUpdates;
import org.apache.spark.sql.SparkSession;
import org.junit.Ignore;
import org.junit.Test;

import static gr.ds.unipi.noda.api.core.operators.FilterOperators.eq;

public class MongoDBSystemTest {

//    @Test
//    public void mongodbTest() {
//
//        SparkSession spark = SparkSession
//                .builder()
//                .appName("Application Name").master("local").config("spark.mongodb.input.database", "admin").config("spark.mongodb.input.collection", "points")
//                .getOrCreate();
//
//        NoSqlDbSystem noSqlDbSystem = NoSqlDbSystem.MongoDB().Builder("sampleuser", "password", "SampleCollection").host("localhost").sparkSession(spark).build();
//        NoSqlDbOperators noSqlDbOperators = noSqlDbSystem.operateOn("points");
//
//        //noSqlDbOperators = noSqlDbOperators.filter(inGeoCircleMeters("location",Coordinates.newCoordinates(25.975396, 39.543451),0.1));
//
//        //noSqlDbOperators = noSqlDbOperators.filter(inGeoRectangle("location",Coordinates.newCoordinates(25.90, 39.6),Coordinates.newCoordinates(25.99, 39.7)));
//
//        System.out.println(noSqlDbOperators.limit(40000).toDataframe().count());
//        noSqlDbSystem.closeConnection();
//
//    }

    @Ignore
    @Test
    public void OperatorsWithSparkSession() {
        SparkSession sparkSession = SparkSession
                .builder()
                .appName("Application Name")
                .master("local")
                .config("spark.mongodb.input.uri", "mongodb://sampleuser:password@localhost/SampleDatabase.SampleCollection")
                .config("spark.mongodb.output.uri", "mongodb://sampleuser:password@localhost/SampleDatabase.SampleCollection")
                .getOrCreate();

        NoSqlDbSystem noSqlDbSystem = NoSqlDbSystem.MongoDB().Builder("sampleuser", "password", "SampleDatabase").host("localhost").sparkSession(sparkSession).build();
        NoSqlDbOperators noSqlDbOperators = noSqlDbSystem.operateOn("SampleCollection");
        System.out.println("Count: " + noSqlDbOperators.limit(40000).toDataframe().count());
        noSqlDbSystem.closeConnection();
    }

    @Ignore
    @Test
    public void NoSqlDbInserts() {
        NoSqlDbSystem noSqlDbSystem = NoSqlDbSystem.MongoDB().Builder("sampleuser", "password", "SampleDatabase").host("localhost").build();
        NoSqlDbInserts operation = noSqlDbSystem.insertionsOn("SampleCollection");

        operation = operation.insert(
                FieldValue.newOFieldValue("name", "John Doe"),
                FieldValue.newFieldValue("age", 30),
                FieldValue.newFieldValue("active", true)
        );

        operation = operation.flush();

        noSqlDbSystem.closeConnection();
    }

    @Ignore
    @Test
    public void NoSqlDbInserts_InsertOnMultiple() {
        NoSqlDbSystem noSqlDbSystem = NoSqlDbSystem.MongoDB().Builder("sampleuser", "password", "SampleDatabase").host("localhost").build();
        NoSqlDbInserts operation = noSqlDbSystem.insertionsOn("SampleCollection");

        operation = operation.insert(
                FieldValue.newOFieldValue("name", "John Doe"),
                FieldValue.newFieldValue("age", 30),
                FieldValue.newFieldValue("active", true)
        );
        operation = operation.insert(
                FieldValue.newOFieldValue("name", "John Doe 2"),
                FieldValue.newFieldValue("age", 18),
                FieldValue.newFieldValue("active", true)
        );

        operation = operation.flush();

        noSqlDbSystem.closeConnection();
    }

    @Ignore
    @Test
    public void NoSqlDbInserts_InsertOnMultipleWithSeparateFlush() {
        NoSqlDbSystem noSqlDbSystem = NoSqlDbSystem.MongoDB().Builder("sampleuser", "password", "SampleDatabase").host("localhost").build();
        NoSqlDbInserts operation = noSqlDbSystem.insertionsOn("SampleCollection");

        operation = operation.insert(
                FieldValue.newOFieldValue("name", "John Doe"),
                FieldValue.newFieldValue("age", 30),
                FieldValue.newFieldValue("active", true)
        );


        operation = operation.flush();

        operation = operation.insert(
                FieldValue.newOFieldValue("name", "John Doe 2"),
                FieldValue.newFieldValue("age", 18),
                FieldValue.newFieldValue("active", true)
        );

        operation = operation.flush();

        noSqlDbSystem.closeConnection();
    }


    @Ignore
    @Test
    public void NoSqlDbUpdate() {
        NoSqlDbSystem noSqlDbSystem = NoSqlDbSystem.MongoDB().Builder("sampleuser", "password", "SampleDatabase").host("localhost").build();
        NoSqlDbUpdates operation = noSqlDbSystem.updatesOn("SampleCollection");

        operation = operation.update(eq("age", 18), FieldValue.newFieldValue("active", false));

        operation = operation.flush();

        noSqlDbSystem.closeConnection();
    }

    @Test
    public void NoSqlDbDeletes() {
        NoSqlDbSystem noSqlDbSystem = NoSqlDbSystem.MongoDB().Builder("sampleuser", "password", "SampleDatabase").host("localhost").build();
        NoSqlDbDeletes operation = noSqlDbSystem.deletionsOn("SampleCollection");

        operation = operation.delete(
                eq("age", 30));

        operation = operation.flush();

        noSqlDbSystem.closeConnection();
    }
}
