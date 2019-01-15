package com.github.unipi.trackandknow;

import com.github.unipi.trackandknow.nosqldbs.aggregateOperator.AggregateOperators;
import com.github.unipi.trackandknow.nosqldbs.connectivity.NoSqlDbSystem;
import com.github.unipi.trackandknow.nosqldbs.filterOperator.FilterOperators;
import com.github.unipi.trackandknow.nosqldbs.filterOperator.geographicalOperator.Coordinates;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;
import org.junit.Test;

import static com.github.unipi.trackandknow.nosqldbs.sortOperator.SortingOperators.asc;
import static com.github.unipi.trackandknow.nosqldbs.sortOperator.SortingOperators.desc;

public class NoSqlDbSystemTest {

    @Test
    public void makeAConnection(){

        NoSqlDbSystem.initialize();

        //NoSqlDbSystem noSqlDbSystem1 = NoSqlDbSystem.MongoDB().host("83.212.102.163").database("test").username("myUserAdmin").password("abc123").port(27017).sparkSession(spark).connect();

        //noSqlDbSystem.operateOn("geoPoints").filter(inGeoBox("location",22.5, 36,23, 36.3)).groupBy("theColumn",max("s","adsasd")).project();
        //System.out.println(noSqlDbSystem.operateOn("geoPoints").max("location.coordinates"));

        //System.out.println("points COUNT: "+noSqlDbSystem1.operateOn("points").filter(FilterOperators.inGeoCircleMeters("coordinates",Coordinates.newCoordinates(23.76,37.99),500)).toDataframe().count());

        NoSqlDbSystem noSqlDbSystem2 = NoSqlDbSystem.MongoDB().host("83.212.102.163").database("test").username("myUserAdmin").password("abc123").port(28017).connect();

//        System.out.println("count "+noSqlDbSystem2.operateOn("geoPoints").filter(FilterOperators.inGeoCircleMeters("location",Coordinates.newCoordinates(23.76,37.99),50)).count());
//        noSqlDbSystem2.operateOn("geoPoints").filter(FilterOperators.inGeoCircleMeters("location",Coordinates.newCoordinates(23.76,37.99),50)).printScreen();
//
//        System.out.println("Max "+noSqlDbSystem2.operateOn("geoPoints").filter(FilterOperators.inGeoCircleMeters("location",Coordinates.newCoordinates(23.76,37.99),50)).max("distance"));
//        System.out.println("Min "+noSqlDbSystem2.operateOn("geoPoints").filter(FilterOperators.inGeoCircleMeters("location",Coordinates.newCoordinates(23.76,37.99),50)).min("distance"));
//        System.out.println("Sum "+noSqlDbSystem2.operateOn("geoPoints").filter(FilterOperators.inGeoCircleMeters("location",Coordinates.newCoordinates(23.76,37.99),50)).sum("distance"));
//        System.out.println("Avg "+noSqlDbSystem2.operateOn("geoPoints").filter(FilterOperators.inGeoCircleMeters("location",Coordinates.newCoordinates(23.76,37.99),50)).avg("distance"));
//
//        System.out.println("GroupBy and count "+noSqlDbSystem2.operateOn("geoPoints").filter(FilterOperators.inGeoCircleMeters("location",Coordinates.newCoordinates(23.76,37.99),50)).groupBy("objectId").count());
//
        System.out.println("GroupBy with All");
        noSqlDbSystem2.operateOn("geoPoints").filter(FilterOperators.inGeoCircleMeters("location",Coordinates.newCoordinates(23.76,37.99),50)).groupBy("objectId", AggregateOperators.max("distance").as("ma"),AggregateOperators.min("distance").as("mi"),AggregateOperators.sum("distance").as("su"),AggregateOperators.avg("distance").as("av"),AggregateOperators.count().as("c")).printScreen();
//
//        System.out.println("GroupBy Only");
//        noSqlDbSystem2.operateOn("geoPoints").filter(FilterOperators.inGeoCircleMeters("location",Coordinates.newCoordinates(23.76,37.99),50)).groupBy("objectId").printScreen();
//
//        System.out.println("Distinct");
//        noSqlDbSystem2.operateOn("geoPoints").filter(FilterOperators.inGeoCircleMeters("location",Coordinates.newCoordinates(23.76,37.99),50)).distinct("objectId").printScreen();

//        System.out.println("sort by");
//        noSqlDbSystem2.operateOn("geoPoints").filter(FilterOperators.inGeoCircleMeters("location",Coordinates.newCoordinates(23.76,37.99),50)).sort(desc("distance")).limit(1).printScreen();
//
//        System.out.println("limit");
//        noSqlDbSystem2.operateOn("geoPoints").filter(FilterOperators.inGeoCircleMeters("location",Coordinates.newCoordinates(23.76,37.99),50)).limit(1).printScreen();

        System.out.println("project");
        noSqlDbSystem2.operateOn("geoPoints").filter(FilterOperators.inGeoCircleMeters("location",Coordinates.newCoordinates(23.76,37.99),50)).project("date").printScreen();



        System.out.println("OK!");


        //System.out.println(noSqlDbSystem.operateOn("points").filter(FilterOperators.inGeoRangeMeters("coordinates",Coordinates.newCoordinates(23.76,37.99),500)).count());

        //noSqlDbSystem.operateOn("points").filter(FilterOperators.inGeoRangeMeters("coordinates",Coordinates.newCoordinates(23.76,37.99),500)).printScreen();
        //System.out.println(noSqlDbSystem.operateOn("points").filter(FilterOperators.eq("objectId","15320_135320")).count());
        //noSqlDbSystem1.closeConnection();
        noSqlDbSystem2.closeConnection();

        //spark.close();
//        NoSqlDbManager manager = NoSqlDbSystem.MongoDB().host("83.212.104.92").database("test").username("myUserAdmin").password("abc123").connect()
//                .getNoSqlDbManager();
//
//        NoSqlDbOperators operateOnSpecificCollection = manager.operateOn("otherCollection");
//
//        operateOnSpecificCollection.project("aColumn","bColumn");
//
//        manager.disconnect(3);
//



//        NoSqlDbSystem v = new NoSqlDbSystem();
//
//        NoSqlDbSystem dbSystem = NoSqlDbSystem.MongoDB().host("83.212.104.92").database("test").username("myUserAdmin").password("abc123").connect();
//
//        dbSystem.operateOn("").filter().filter().project();
//
//        dbSystem.operateOn("Collection").aggragation().filter().filter(ColumnName,lambda).projectFilteredColumns();
//        dbSystem.operateOn(Collection).filter(ColumnName,lambda).filter(ColumnName,lambda).project();
//
//        dbSystem.operateOn(Collection).spatialBoundingBoxFilter(ColumnName...).min(3,4).max(7,8).project();
//        dbSystem.operateOn(Collection).spatialRangeFilter(ColumnName...).range(76).project();
//
//        dbSystem.operateOn(Collection).geoSpatialBoundingBoxFilter(ColumnName,ColumnName,ColumnName).min(3,4).max(7,8).project();
//        dbSystem.operateOn(Collection).geoSpatialRangeFilter(ColumnName,ColumnName,ColumnName).range().project();
//
//        dbSystem.operateOn(Collection).geoSpatialBoundingBoxFilter(ColumnName,ColumnName).min(3,4).max(7,8).project();
//        Dataset<Row> r = dbSystem.operateOn(Collection).geoSpatialRangeFilter(ColumnName,ColumnName).range(2).project();
//
//        dbSystem.disconnect();
//        SparkConf.load(r);
//
//
//        dbSystem.operateOn(Collection).filter()
//                .greaterThan(ColumnName,3)
//                .and()
//                .lessThan(ColumnName,100)
//                .or()
//                .equals(ColumnName,342)
//                .project();

    }

}