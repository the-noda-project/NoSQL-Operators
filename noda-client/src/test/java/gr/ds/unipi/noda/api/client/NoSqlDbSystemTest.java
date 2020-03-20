package gr.ds.unipi.noda.api.client;

import org.junit.Test;

import java.util.Arrays;
import java.util.stream.Stream;

import static gr.ds.unipi.noda.api.core.operators.AggregateOperators.max;

public class NoSqlDbSystemTest {

    @Test
    public void neo4j() {
        NoSqlDbSystem noSqlDbSystem = NoSqlDbSystem.Neo4j().username("myUsername").password("myPass").host("192.168.1.1").port(5000).database("myDatabase").build();
        noSqlDbSystem.operateOn("table").groupBy("field", max("anotherField"));
        noSqlDbSystem.closeConnection();

    }

    @Test
    public void check(){
        String[] c = new String[998];
        for(int i =0;i<998;i++){
            c[i] = "sdfsgfmjnijni";
        }

        long t1 = System.currentTimeMillis();
        something1("adfsdf","sfdgdfg",c);
        System.out.println(System.currentTimeMillis() - t1 +"ms");


        long t2 = System.currentTimeMillis();
        something2("adfsdf","sfdgdfg",c);
        System.out.println(System.currentTimeMillis() - t2 +"ms");

    }

    public static void something1(String a, String b, String[] c){
        String[] d = new String[1000];
        d[0] = a;
        d[1] = b;
        for(int i =2;i<1000;i++){
            d[i] = c[i-2];
        }
    }

    public static void something2(String a, String b, String[] c){
        Arrays.stream(new String[]{a,b} ).toArray(String[]::new);
    }
}