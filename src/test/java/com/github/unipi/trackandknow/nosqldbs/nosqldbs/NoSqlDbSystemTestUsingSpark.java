package com.github.unipi.trackandknow.nosqldbs.nosqldbs;

import com.github.unipi.trackandknow.nosqldbs.aggregateOperator.AggregateOperators;
import com.github.unipi.trackandknow.nosqldbs.nosqldbs.NoSqlDbSystem;
import com.github.unipi.trackandknow.nosqldbs.filterOperator.FilterOperators;
import com.github.unipi.trackandknow.nosqldbs.filterOperator.geographicalOperator.Coordinates;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;
import org.junit.Test;

import static com.github.unipi.trackandknow.nosqldbs.filterOperator.FilterOperators.inGeoCircleMeters;
import static com.github.unipi.trackandknow.nosqldbs.sortOperator.SortingOperators.desc;

public class NoSqlDbSystemTestUsingSpark {

    @Test
    public void test(){

        NoSqlDbSystem.initialize();

        SparkSession spark = SparkSession.builder()
                .master("local")
                .appName("MongoSparkConnectorIntro")
                .getOrCreate();

        NoSqlDbSystem noSqlDbSystem = NoSqlDbSystem.MongoDB().host("83.212.102.163").database("test").username("myUserAdmin").password("abc123").port(28017).sparkSession(spark).build();

        noSqlDbSystem.operateOn("geoPoints").filter(inGeoCircleMeters("location",Coordinates.newCoordinates(23.76,37.99),50)).count();
        noSqlDbSystem.operateOn("geoPoints").filter(inGeoCircleMeters("location",Coordinates.newCoordinates(23.76,37.99),50)).printScreen();

        noSqlDbSystem.operateOn("geoPoints").filter(inGeoCircleMeters("location",Coordinates.newCoordinates(23.76,37.99),50)).toDataframe().groupBy().max("distance");
        noSqlDbSystem.operateOn("geoPoints").filter(inGeoCircleMeters("location",Coordinates.newCoordinates(23.76,37.99),50)).toDataframe().groupBy().min("distance");
        noSqlDbSystem.operateOn("geoPoints").filter(inGeoCircleMeters("location",Coordinates.newCoordinates(23.76,37.99),50)).toDataframe().groupBy().sum("distance");
        noSqlDbSystem.operateOn("geoPoints").filter(inGeoCircleMeters("location",Coordinates.newCoordinates(23.76,37.99),50)).toDataframe().groupBy().avg("distance");


        System.out.println("GroupBy with All");
        noSqlDbSystem.operateOn("geoPoints").filter(inGeoCircleMeters("location",Coordinates.newCoordinates(23.76,37.99),50)).groupBy("objectId", AggregateOperators.max("distance").as("ma"),AggregateOperators.min("distance").as("mi"),AggregateOperators.sum("distance").as("su"),AggregateOperators.avg("distance").as("av"),AggregateOperators.count().as("c")).toDataframe().show();

        System.out.println("GroupBy Only");
        noSqlDbSystem.operateOn("geoPoints").filter(inGeoCircleMeters("location",Coordinates.newCoordinates(23.76,37.99),50)).groupBy("objectId").toDataframe().show();

        System.out.println("Distinct");
        noSqlDbSystem.operateOn("geoPoints").filter(inGeoCircleMeters("location",Coordinates.newCoordinates(23.76,37.99),50)).distinct("objectId").toDataframe().show();

        System.out.println("sort by");
        noSqlDbSystem.operateOn("geoPoints").filter(inGeoCircleMeters("location",Coordinates.newCoordinates(23.76,37.99),50)).sort(desc("distance")).limit(1).toDataframe().show();

        System.out.println("limit");
        noSqlDbSystem.operateOn("geoPoints").filter(inGeoCircleMeters("location",Coordinates.newCoordinates(23.76,37.99),50)).limit(1).toDataframe().show();

        System.out.println("project");
        noSqlDbSystem.operateOn("geoPoints").filter(inGeoCircleMeters("location",Coordinates.newCoordinates(23.76,37.99),50)).project("date").toDataframe().show();

        System.out.println("OK!");

        noSqlDbSystem.closeConnection();

    }
}