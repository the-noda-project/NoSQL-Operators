package gr.ds.unipi.noda.api.client;

import gr.ds.unipi.noda.api.core.nosqldb.NoSqlDbOperators;
import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.Coordinates;
import org.apache.spark.sql.SparkSession;
import org.junit.Test;
import static gr.ds.unipi.noda.api.core.operators.FilterOperators.inGeoCircleKm;
import static gr.ds.unipi.noda.api.core.operators.FilterOperators.inGeoCircleMeters;
import static gr.ds.unipi.noda.api.core.operators.FilterOperators.inGeoRectangle;

public class MongoDBSystemTest {

    @Test
    public void mongodbTest() {

        SparkSession spark = SparkSession
                .builder()
                .appName("Application Name").master("local").config("spark.mongodb.input.database","admin").config("spark.mongodb.input.collection", "points")
                .getOrCreate();

        NoSqlDbSystem noSqlDbSystem = NoSqlDbSystem.MongoDB().Builder("myUserAdmin","myPass","admin").host("localhost").sparkSession(spark).build();
        NoSqlDbOperators noSqlDbOperators = noSqlDbSystem.operateOn("points");

        //noSqlDbOperators = noSqlDbOperators.filter(inGeoCircleMeters("location",Coordinates.newCoordinates(25.975396, 39.543451),0.1));

        //noSqlDbOperators = noSqlDbOperators.filter(inGeoRectangle("location",Coordinates.newCoordinates(25.90, 39.6),Coordinates.newCoordinates(25.99, 39.7)));

        System.out.println(noSqlDbOperators.limit(40000).toDataframe().count());
        noSqlDbSystem.closeConnection();

    }
}
