package gr.ds.unipi.noda.api.client;

import gr.ds.unipi.noda.api.core.operators.filterOperators.geographicalOperators.Coordinates;
import org.junit.Test;

import static gr.ds.unipi.noda.api.core.operators.FilterOperators.inGeoPolygon;

public class HBaseSystemTest {
    @Test
    public void hBaseTest() {

        NoSqlDbSystem noSqlDbSystem = NoSqlDbSystem.HBase().Builder().host("localhost").build();
        //noSqlDbSystem.operateOn("test").filter(eq("cf:name", "George")).project("cf:surname").printScreen();
        //noSqlDbSystem.operateOn("points").filter(inGeoRectangle("location", Coordinates.newCoordinates(24,38),Coordinates.newCoordinates(25,39))).printScreen();
        noSqlDbSystem.operateOn("points").filter(inGeoPolygon("location", Coordinates.newCoordinates(24,38),Coordinates.newCoordinates(24,39),Coordinates.newCoordinates(25,39),Coordinates.newCoordinates(25,38))).printScreen();

        //noSqlDbSystem.operateOn("points").filter(gte("location:lon",24)).printScreen();
        noSqlDbSystem.closeConnection();
    }


}
