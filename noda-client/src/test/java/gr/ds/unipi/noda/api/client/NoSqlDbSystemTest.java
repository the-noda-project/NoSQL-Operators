package gr.ds.unipi.noda.api.client;

import org.bson.Document;
import org.bson.conversions.Bson;
import org.junit.Test;

import java.util.Arrays;

import static gr.ds.unipi.noda.api.core.operators.FilterOperators.eq;

public class NoSqlDbSystemTest {

//    public void neo4j(){
//        NoSqlDbSystem noSqlDbSys =  NoSqlDbSystem.Neo4j().Builder("neo4j","nikos","graph").host("127.0.0.1").port(7687).build();
//        //noSqlDbSys.operateOn("Ship").filter(or(eq("LAT",-38.31416), eq("LON",145.004403333), gt("SPEED", 20))).filter(eq("LAT",-38.31416)).sort(desc("COURSE")).sort(asc("LON")).printScreen();
//        noSqlDbSys.operateOn("Ship").filter(eq("LAT",-38.31416)).printScreen();
//        noSqlDbSys.closeConnection();
//    }

    @Test
    public void neo4jTest() {
        NoSqlDbSystem noSqlDbSystem = NoSqlDbSystem.Neo4j().Builder("neo4j", "nikos", "graph").host("127.0.0.1").port(7687).build();
        noSqlDbSystem.operateOn("Ship").filter(eq("LAT", -38.31416)).printScreen();
        noSqlDbSystem.closeConnection();
    }


//    @Test
//    public void groupingAndsortingExample() {
//        NoSqlDbSystem noSqlDbSystem = NoSqlDbSystem.Neo4j().username("neo4j").password("nikos").host("localhost").port(7687).database("graph").build();
//        noSqlDbSystem.operateOn("Ship").filter(eq("LAT","'-38.31416'")).groupBy("fieldA", max("fieldB")).sort(asc("fieldC")).printScreen();
//        noSqlDbSystem.closeConnection();
//    }
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

    @Test
    public void check2(){

        String s = "{ $group: " + "{ _id: {"+ "myF: "+ "\"" + "$" + "myF" + "\"" +
                ",fd: "+ "\"" + "$" + "fd" + "\"" +
                "}, er:5,  " +"} }";

        Bson bson = (Bson) Document.parse(s);

//        System.out.println(((Document) bson).containsKey("$group"));
//        System.out.println(((Document) bson).get("$group"));
//
//        Document id = (Document) ((Document) ((Document) bson).get("$group")).get("_id");
//
//        System.out.println("_id: "+ id);
//
//
//        ((Document) ((Document) bson).get("$group")).remove("_id");
//        Document perisevoumena = (Document) ((Document) ((Document) bson).get("$group"));
//        System.out.println("perisevoumena "+ perisevoumena.isEmpty());
//        perisevoumena.forEach((o,v)-> System.out.println(o+" "+v));
//
//        ((Document) ((Document) bson).get("$group")).append("_id", id).append("s","d").append("r","d");


        String json = ((Document) bson).toJson();
        System.out.println(json);

        System.out.println(Document.parse(json.substring(0, json.length()-3) +", count:{ $sum:1 } }}").toJson());


//        String json = ((Document)bson).toJson(JsonWriterSettings.builder().outputMode(JsonMode.RELAXED).build());
//
//        System.out.println(json.substring(0, json.length()-3));
    }
}