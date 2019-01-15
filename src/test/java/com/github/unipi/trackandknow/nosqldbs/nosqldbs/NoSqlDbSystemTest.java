package com.github.unipi.trackandknow.nosqldbs.nosqldbs;

import com.github.unipi.trackandknow.nosqldbs.aggregateOperator.AggregateOperators;
import com.github.unipi.trackandknow.nosqldbs.nosqldbs.NoSqlDbSystem;
import com.github.unipi.trackandknow.nosqldbs.filterOperator.FilterOperators;
import com.github.unipi.trackandknow.nosqldbs.filterOperator.geographicalOperator.Coordinates;
import org.junit.Test;

import static com.github.unipi.trackandknow.nosqldbs.filterOperator.FilterOperators.inGeoCircleMeters;
import static com.github.unipi.trackandknow.nosqldbs.sortOperator.SortingOperators.desc;

public class NoSqlDbSystemTest {

    @Test
    public void test(){

        NoSqlDbSystem.initialize();

        NoSqlDbSystem noSqlDbSystem = NoSqlDbSystem.MongoDB().host("83.212.102.163").database("test").username("myUserAdmin").password("abc123").port(28017).build();

        System.out.println("count "+noSqlDbSystem.operateOn("geoPoints").filter(inGeoCircleMeters("location",Coordinates.newCoordinates(23.76,37.99),50)).count());
        noSqlDbSystem.operateOn("geoPoints").filter(inGeoCircleMeters("location",Coordinates.newCoordinates(23.76,37.99),50)).printScreen();

        System.out.println("Max "+noSqlDbSystem.operateOn("geoPoints").filter(inGeoCircleMeters("location",Coordinates.newCoordinates(23.76,37.99),50)).max("distance"));
        System.out.println("Min "+noSqlDbSystem.operateOn("geoPoints").filter(inGeoCircleMeters("location",Coordinates.newCoordinates(23.76,37.99),50)).min("distance"));
        System.out.println("Sum "+noSqlDbSystem.operateOn("geoPoints").filter(inGeoCircleMeters("location",Coordinates.newCoordinates(23.76,37.99),50)).sum("distance"));
        System.out.println("Avg "+noSqlDbSystem.operateOn("geoPoints").filter(inGeoCircleMeters("location",Coordinates.newCoordinates(23.76,37.99),50)).avg("distance"));


        System.out.println("GroupBy with All");
        noSqlDbSystem.operateOn("geoPoints").filter(inGeoCircleMeters("location",Coordinates.newCoordinates(23.76,37.99),50)).groupBy("objectId", AggregateOperators.max("distance").as("ma"),AggregateOperators.min("distance").as("mi"),AggregateOperators.sum("distance").as("su"),AggregateOperators.avg("distance").as("av"),AggregateOperators.count().as("c")).printScreen();

        System.out.println("GroupBy Only");
        noSqlDbSystem.operateOn("geoPoints").filter(inGeoCircleMeters("location",Coordinates.newCoordinates(23.76,37.99),50)).groupBy("objectId").printScreen();

        System.out.println("Distinct");
        noSqlDbSystem.operateOn("geoPoints").filter(inGeoCircleMeters("location",Coordinates.newCoordinates(23.76,37.99),50)).distinct("objectId").printScreen();

        System.out.println("sort by");
        noSqlDbSystem.operateOn("geoPoints").filter(inGeoCircleMeters("location",Coordinates.newCoordinates(23.76,37.99),50)).sort(desc("distance")).limit(1).printScreen();

        System.out.println("limit");
        noSqlDbSystem.operateOn("geoPoints").filter(inGeoCircleMeters("location",Coordinates.newCoordinates(23.76,37.99),50)).limit(1).printScreen();

        System.out.println("project");
        noSqlDbSystem.operateOn("geoPoints").filter(inGeoCircleMeters("location",Coordinates.newCoordinates(23.76,37.99),50)).project("date").printScreen();

        System.out.println("OK!");

        noSqlDbSystem.closeConnection();

    }

}