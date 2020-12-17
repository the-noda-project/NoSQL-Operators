package gr.ds.unipi.noda.api.client;

import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.Coordinates;
import org.junit.Ignore;
import org.junit.Test;

import java.util.Arrays;

import static gr.ds.unipi.noda.api.core.operators.FilterOperators.*;

public class GeoTextualOperatorsTest {

	
    @Test
    public void mongoDB(){
    	NoSqlDbSystem noSqlDbSys =  NoSqlDbSystem.MongoDB().Builder("knest", "password", "mongodb").host("localhost").port(27017).build();
    	 // noSqlDbSys.operateOn("myCollecton").filter(inGeoTextualRectangle("fieldName", Coordinates.newCoordinates(45,45), Coordinates.newCoordinates(46,46), anyKeywords("keywordsFieldName","keyword1"))).printScreen();

         noSqlDbSys.operateOn("hilbertcollection").filter(inGeoTextualRectangle("location", Coordinates.newCoordinates(-70.6995,60.191988133), Coordinates.newCoordinates(-30.937563,20.974964), allKeywords("Text","Burgers","Pizza","Sandwiches"))).printScreen();
         //noSqlDbSys.operateOn("geoindex").filter(inGeoRectangle("location", Coordinates.newCoordinates(-70.6995,60.19198813), Coordinates.newCoordinates(-30.937563,20.974964))).printScreen();

         // noSqlDbSys.operateOn("myCollecton").filter(topRankInGeoTextualRectangle("fieldName", Coordinates.newCoordinates(45,45), Coordinates.newCoordinates(46,46),"keywordsFieldName", Arrays.asList("keyword"),5)).printScreen();


    }
    

}