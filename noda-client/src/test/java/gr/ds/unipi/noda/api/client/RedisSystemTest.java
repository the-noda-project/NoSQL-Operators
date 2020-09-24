package gr.ds.unipi.noda.api.client;

import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.Coordinates;
import org.junit.Ignore;
import org.junit.Test;

import static gr.ds.unipi.noda.api.core.operators.FilterOperators.*;

public class RedisSystemTest {
    @Ignore
    @Test
    public void redisTest() {

        NoSqlDbSystem noSqlDbSystem = NoSqlDbSystem.Redis().Builder().build();
        //noSqlDbSystem.operateOn("test").filter(eq("cf:name", "George")).project("cf:surname").printScreen();
        //noSqlDbSystem.operateOn("points").filter(inGeoRectangle("location", Coordinates.newCoordinates(24,38),Coordinates.newCoordinates(25,39))).printScreen();
        noSqlDbSystem.operateOn("points").filter(and(gt("age",25),lt("age", 10),gt("age",16),lte("age",10),gte("age",25),gte("age",16))).printScreen();

        //noSqlDbSystem.operateOn("points").filter(gte("location:lon",24)).printScreen();
        noSqlDbSystem.closeConnection();
    }


}
