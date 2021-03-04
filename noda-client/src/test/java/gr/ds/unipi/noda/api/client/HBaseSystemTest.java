package gr.ds.unipi.noda.api.client;

import gr.ds.unipi.noda.api.core.nosqldb.NoSqlDbOperators;
import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.Coordinates;
import org.apache.spark.sql.SparkSession;
import org.junit.Ignore;
import org.junit.Test;

import static gr.ds.unipi.noda.api.core.operators.FilterOperators.eq;
import static gr.ds.unipi.noda.api.core.operators.FilterOperators.gte;
import static gr.ds.unipi.noda.api.core.operators.FilterOperators.inGeoPolygon;

public class HBaseSystemTest {
    //@Ignore
    @Test
    public void hBaseTest() {

        SparkSession spark = SparkSession
                .builder()
                .appName("Application Name").master("local")
                .getOrCreate();

        NoSqlDbSystem noSqlDbSystem = NoSqlDbSystem.HBase().Builder().port(2181).sparkSession(spark).build();
        //noSqlDbSystem.operateOn("points").filter(gte("cf:name", 43.7)).project("cf:name").printScreen();
        //noSqlDbSystem.operateOn("points").filter(inGeoRectangle("location", Coordinates.newCoordinates(24,38),Coordinates.newCoordinates(25,39))).printScreen();
        //noSqlDbSystem.operateOn("points").filter(inGeoPolygon("location", Coordinates.newCoordinates(24,38),Coordinates.newCoordinates(24,39),Coordinates.newCoordinates(25,39),Coordinates.newCoordinates(25,38))).printScreen();

        NoSqlDbOperators noSqlDbOperators = noSqlDbSystem.operateOn("points");

        noSqlDbOperators.toDataframe();
        noSqlDbOperators.toDataframe();

        noSqlDbSystem.closeConnection();
        
    }


}
