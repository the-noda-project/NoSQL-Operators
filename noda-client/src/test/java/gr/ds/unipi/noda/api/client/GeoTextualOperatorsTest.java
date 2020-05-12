package gr.ds.unipi.noda.api.client;

import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.Coordinates;
import org.junit.Test;

import java.util.Arrays;

import static gr.ds.unipi.noda.api.core.operators.FilterOperators.*;

public class GeoTextualOperatorsTest {

    @Test
    public void mongoDB(){
        NoSqlDbSystem noSqlDbSys =  NoSqlDbSystem.MongoDB().Builder("username", "password", "database").host("localhost").port(27017).build();
        noSqlDbSys.operateOn("myCollecton").filter(inGeoTextualRectangle("fieldName", Coordinates.newCoordinates(45,45), Coordinates.newCoordinates(46,46), anyKeywords("keywordsFieldName","keyword1"))).printScreen();

        noSqlDbSys.operateOn("myCollecton").filter(inGeoTextualRectangle("fieldName", Coordinates.newCoordinates(45,45), Coordinates.newCoordinates(46,46), allKeywords("keywordsFieldName","keyword1","keyword2"))).printScreen();

        noSqlDbSys.operateOn("myCollecton").filter(topRankInGeoTextualRectangle("fieldName", Coordinates.newCoordinates(45,45), Coordinates.newCoordinates(46,46),"keywordsFieldName", Arrays.asList("keyword"),5)).printScreen();

        noSqlDbSys.closeConnection();

    }
}