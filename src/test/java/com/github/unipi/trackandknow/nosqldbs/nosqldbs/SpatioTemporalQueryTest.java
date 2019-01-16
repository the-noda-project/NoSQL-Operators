package com.github.unipi.trackandknow.nosqldbs.nosqldbs;

import com.github.unipi.trackandknow.nosqldbs.filterOperator.geographicalOperator.Coordinates;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;
import java.util.Optional;

import static com.github.unipi.trackandknow.nosqldbs.filterOperator.FilterOperators.gte;
import static com.github.unipi.trackandknow.nosqldbs.filterOperator.FilterOperators.inGeoCircleMeters;
import static org.junit.Assert.*;

public class SpatioTemporalQueryTest {

    @Test
    public void test() throws ParseException {
        NoSqlDbSystem.initialize();

        Date d = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS").parse("2018-09-01T00:00:00.000Z");

        System.out.println(d);
        NoSqlDbSystem noSqlDbSystem = NoSqlDbSystem.MongoDB().host("83.212.102.163").database("test").username("myUserAdmin").password("abc123").port(28017).build();

        System.out.println("count "+noSqlDbSystem.operateOn("geoPoints").filter(inGeoCircleMeters("location", Coordinates.newCoordinates(23.76,37.99),50)).count());
        System.out.println("second count "+noSqlDbSystem.operateOn("geoPoints").filter(inGeoCircleMeters("location",Coordinates.newCoordinates(23.76,37.99),50), gte("date",d)).sum("date"));


        Optional<Double> sum =noSqlDbSystem.operateOn("geoPoints").filter(inGeoCircleMeters("location",Coordinates.newCoordinates(23.76,37.99),50), gte("date",d)).sum("date");

        System.out.println(sum.get());

    }
}