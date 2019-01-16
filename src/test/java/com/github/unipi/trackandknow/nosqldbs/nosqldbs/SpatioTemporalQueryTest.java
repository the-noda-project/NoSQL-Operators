package com.github.unipi.trackandknow.nosqldbs.nosqldbs;

import com.github.unipi.trackandknow.nosqldbs.filterOperator.geographicalOperator.Coordinates;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;
import java.util.Optional;

import static com.github.unipi.trackandknow.nosqldbs.filterOperator.FilterOperators.gte;
import static com.github.unipi.trackandknow.nosqldbs.filterOperator.FilterOperators.inGeoBox;
import static com.github.unipi.trackandknow.nosqldbs.filterOperator.FilterOperators.inGeoCircleMeters;
import static org.junit.Assert.*;

public class SpatioTemporalQueryTest {

    @Test
    public void test() throws ParseException {
        NoSqlDbSystem.initialize();

        Date d = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS").parse("2017-12-01T00:00:00.000Z");

        System.out.println(d);
        NoSqlDbSystem noSqlDbSystem = NoSqlDbSystem.MongoDB().host("83.212.102.163").database("test").username("myUserAdmin").password("abc123").port(28017).build();

        System.out.println("count "+noSqlDbSystem.operateOn("geoPoints").filter(inGeoBox("location", Coordinates.newCoordinates(23.7576,37.9839),Coordinates.newCoordinates(23.7830,38.0050)),gte("date",d)).count());


        System.out.println(noSqlDbSystem.operateOn("geoPoints").filter(inGeoCircleMeters("location",Coordinates.newCoordinates(23.76,37.99),200)/*, gte("date",d)*/).count());


        noSqlDbSystem.closeConnection();
    }
}