package com.github.unipi.trackandknow;

import com.github.unipi.trackandknow.nosqldbs.NoSqlDbOperators;
import org.junit.Test;

public class NoSqlDbSystemTest {

    @Test
    public void makeAConnection(){
        NoSqlDbManager manager = NoSqlDbSystem.MongoDB().host("83.212.104.92").database("test").username("myUserAdmin").password("abc123").connect()
                .getNoSqlDbManager();

        //manager.operateOn("points").scan();

        //manager.operateOn("collection").filter("aColumn",f->f>3).project("aColumn");

        NoSqlDbOperators operateOnSpecificCollection = manager.operateOn("otherCollection");

        //operateOnSpecificCollection.scan();
        operateOnSpecificCollection.project("aColumn","bColumn");

        manager.disconnect();

        NoSqlDbSystem v = new NoSqlDbSystem();

        NoSqlDbSystem dbSystem = NoSqlDbSystem.MongoDB().host("83.212.104.92").database("test").username("myUserAdmin").password("abc123").connect();

        dbSystem.operateOn(Collection).filter(ColumnName,f->f>3).filter(ColumnName,lambda).projectFilteredColumns();
        dbSystem.operateOn(Collection).filter(ColumnName,lambda).filter(ColumnName,lambda).project();

        dbSystem.operateOn(Collection).spatialBoundingBoxFilter(ColumnName...).min(3,4).max(7,8).project();
        dbSystem.operateOn(Collection).spatialRangeFilter(ColumnName...).range(76).project();

        dbSystem.operateOn(Collection).geoSpatialBoundingBoxFilter(ColumnName,ColumnName,ColumnName).min(3,4).max(7,8).project();
        dbSystem.operateOn(Collection).geoSpatialRangeFilter(ColumnName,ColumnName,ColumnName).range().project();

        dbSystem.operateOn(Collection).geoSpatialBoundingBoxFilter(ColumnName,ColumnName).min(3,4).max(7,8).project();
        Dataset<Row> r = dbSystem.operateOn(Collection).geoSpatialRangeFilter(ColumnName,ColumnName).range(2).project();

        dbSystem.disconnect();
        SparkConf.load(r);


        dbSystem.operateOn(Collection).filter()
                .greaterThan(ColumnName,3)
                .and()
                .lessThan(ColumnName,100)
                .or()
                .equals(ColumnName,342)
                .project();

    }

}