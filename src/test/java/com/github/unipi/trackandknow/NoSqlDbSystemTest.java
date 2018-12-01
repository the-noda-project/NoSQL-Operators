package com.github.unipi.trackandknow;

import com.github.unipi.trackandknow.nosqldbs.filterOperator.FilterOperators;
import org.junit.Test;

import static com.github.unipi.trackandknow.nosqldbs.filterOperator.FilterOperators.inGeoBox;

public class NoSqlDbSystemTest {

    @Test
    public void makeAConnection(){

        NoSqlDbSystem noSqlDbSystem = NoSqlDbSystem.MongoDB().host("83.212.102.163").database("test").username("myUserAdmin").password("abc123").port(28017).connect();

        //noSqlDbSystem.operateOn("geoPoints").filter(inGeoBox("location",22.5, 36,23, 36.3)).groupBy("theColumn",max("s","adsasd")).project();
        //System.out.println(noSqlDbSystem.operateOn("geoPoints").max("location.coordinates"));

        System.out.println(noSqlDbSystem.operateOn("geoPoints").filter(FilterOperators.inGeoRangeKm("location",23,36.5,55.6)).count());


        noSqlDbSystem.disconnect();
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