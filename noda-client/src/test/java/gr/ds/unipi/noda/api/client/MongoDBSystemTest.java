package gr.ds.unipi.noda.api.client;

import gr.ds.unipi.noda.api.core.nosqldb.NoSqlDbOperators;
import org.apache.spark.sql.SparkSession;
import org.junit.Test;

public class MongoDBSystemTest {

    @Test
    public void mongodbTest() {

        SparkSession spark = SparkSession
                .builder()
                .appName("Application Name").master("local").config("spark.mongodb.input.database","admin").config("spark.mongodb.input.collection", "inventory")
                .getOrCreate();

        NoSqlDbSystem noSqlDbSystem = NoSqlDbSystem.MongoDB().Builder("myUserAdmin","myPass","admin").host("localhost").sparkSession(spark).build();
        //noSqlDbSystem.operateOn("points").filter(gte("cf:name", 43.7)).project("cf:name").printScreen();
        //noSqlDbSystem.operateOn("points").filter(inGeoRectangle("location", Coordinates.newCoordinates(24,38),Coordinates.newCoordinates(25,39))).printScreen();
        //noSqlDbSystem.operateOn("points").filter(inGeoPolygon("location", Coordinates.newCoordinates(24,38),Coordinates.newCoordinates(24,39),Coordinates.newCoordinates(25,39),Coordinates.newCoordinates(25,38))).printScreen();

        NoSqlDbOperators noSqlDbOperators = noSqlDbSystem.operateOn("inventory");

        noSqlDbOperators.toDataframe().show();

//        Dataset<Row> d1 = a.toDataframe();
//
//        a = noSqlDbOperators.filter(inGeoRectangle("location", Coordinates.newCoordinates(24,38),Coordinates.newCoordinates(25,39)));
//        Dataset<Row> d2  = a.toDataframe();

        noSqlDbSystem.closeConnection();

    }
}
