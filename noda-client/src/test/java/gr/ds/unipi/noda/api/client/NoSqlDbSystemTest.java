package gr.ds.unipi.noda.api.client;

import gr.ds.unipi.noda.api.core.operators.filterOperators.geographicalOperators.Coordinates;
import gr.ds.unipi.noda.api.core.operators.filterOperators.geographicalOperators.geometries.Circle;
import javafx.geometry.Point2D;
import org.junit.Test;

import java.awt.*;
import java.util.Arrays;

import static gr.ds.unipi.noda.api.core.operators.FilterOperators.*;
import static gr.ds.unipi.noda.api.core.operators.AggregateOperators.*;
import static gr.ds.unipi.noda.api.core.operators.SortOperators.*;

public class NoSqlDbSystemTest {
//    public void neo4j(){
//        NoSqlDbSystem noSqlDbSys =  NoSqlDbSystem.Neo4j().Builder("neo4j","nikos","graph").host("127.0.0.1").port(7687).build();
//        //noSqlDbSys.operateOn("Ship").filter(or(eq("LAT",-38.31416), eq("LON",145.004403333), gt("SPEED", 20))).filter(eq("LAT",-38.31416)).sort(desc("COURSE")).sort(asc("LON")).printScreen();
//        noSqlDbSys.operateOn("Ship").filter(eq("LAT",-38.31416)).printScreen();
//        noSqlDbSys.closeConnection();
//    }

//    @Test
//    public void neo4jTest() {
//        NoSqlDbSystem noSqlDbSystem = NoSqlDbSystem.Neo4j().Builder("nikos", "b.xT9aop6yHVKR.VT55Sd4YB7ICbuR6").host("hobby-mhkjmndbhbhagbkeckbgfoel.dbs.graphenedb.com").port(24787).build();
//        noSqlDbSystem.operateOn("Ship").filter(eq("LAT", -38.31416)).printScreen();
//        noSqlDbSystem.closeConnection();
//    }


    @Test
    public void groupingAndsortingExample() {
        NoSqlDbSystem noSqlDbSystem = NoSqlDbSystem.Neo4j().Builder("neo4j", "nikos").host("localhost").port(7687).build();
//        noSqlDbSystem.operateOn("Ship").filter(eq("LAT", -38.31416)).printScreen();

        noSqlDbSystem.operateOn("Ship").filter(inGeoCircleKm("LOCATION", Coordinates.newCoordinates(145.00441, -38.31416), 0.04)).printScreen();
//        noSqlDbSystem.operateOn("Ship").filter(or(eq("LAT",-38.31416), eq("LON",145.004403333), gt("SPEED", 20))).groupBy("LAT", max("COURSE")).printScreen();

        noSqlDbSystem.closeConnection();
    }
//
//    @Test
//    public void countExample() {
//        NoSqlDbSystem noSqlDbSystem = NoSqlDbSystem.Neo4j().username("neo4j").password("nikos").host("localhost").port(7687).database("graph").build();
//        noSqlDbSystem.operateOn("Ship").filter(eq("LAT","'-38.31416'")).groupBy("fieldA", count()).printScreen();
//        noSqlDbSystem.operateOn("Ship").filter(eq("LAT","'-38.31416'")).count();
//
//        noSqlDbSystem.closeConnection();
//    }

    @Test
    public void check() {
        String[] c = new String[998];
        for (int i = 0; i < 998; i++) {
            c[i] = "sdfsgfmjnijni";
        }

        long t1 = System.currentTimeMillis();
        something1("adfsdf", "sfdgdfg", c);
        System.out.println(System.currentTimeMillis() - t1 + "ms");


        long t2 = System.currentTimeMillis();
        something2("adfsdf", "sfdgdfg", c);
        System.out.println(System.currentTimeMillis() - t2 + "ms");

    }

    public static void something1(String a, String b, String[] c) {
        String[] d = new String[1000];
        d[0] = a;
        d[1] = b;
        for (int i = 2; i < 1000; i++) {
            d[i] = c[i - 2];
        }
    }

    public static void something2(String a, String b, String[] c) {
        Arrays.stream(new String[]{a, b}).toArray(String[]::new);
    }
}