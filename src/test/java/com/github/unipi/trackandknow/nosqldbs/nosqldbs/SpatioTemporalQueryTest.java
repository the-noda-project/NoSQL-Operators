package com.github.unipi.trackandknow.nosqldbs.nosqldbs;

import com.github.unipi.trackandknow.nosqldbs.filterOperator.geographicalOperator.Coordinates;
import org.junit.Test;

import java.time.Instant;
import java.util.Date;

import static com.github.unipi.trackandknow.nosqldbs.filterOperator.FilterOperators.gte;
import static com.github.unipi.trackandknow.nosqldbs.filterOperator.FilterOperators.inGeoCircleMeters;
import static org.junit.Assert.*;

public class SpatioTemporalQueryTest {

    @Test
    public void test() {
        NoSqlDbSystem.initialize();

        NoSqlDbSystem noSqlDbSystem = NoSqlDbSystem.MongoDB().host("83.212.102.163").database("test").username("myUserAdmin").password("abc123").port(28017).build();

        System.out.println("count "+noSqlDbSystem.operateOn("geoPoints").filter(inGeoCircleMeters("location", Coordinates.newCoordinates(23.76,37.99),50)).count());
        noSqlDbSystem.operateOn("geoPoints").filter(inGeoCircleMeters("location",Coordinates.newCoordinates(23.76,37.99),50), gte("date",Date.from(Instant.parse("2013-10-01T00:00:00.000Z")))).printScreen();



    }
}