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
        //noSqlDbSystem.operateOn("points").filter(and(lt("age",25),gt("age", 10),gt("fd",54))).printScreen();
        System.out.println(noSqlDbSystem.operateOn("points").filter(or(gt("age", 24),lt("age", 21))).count());

        //noSqlDbSystem.operateOn("points").filter(gte("location:lon",24)).printScreen();
        noSqlDbSystem.closeConnection();
    }


}
