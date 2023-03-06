package gr.ds.unipi.noda.api.client.cassandradatabase;

import gr.ds.unipi.noda.api.client.NoSqlDbSystem;
import gr.ds.unipi.noda.api.core.nosqldb.modifications.FieldValue;
import gr.ds.unipi.noda.api.core.nosqldb.modifications.NoSqlDbInserts;
import gr.ds.unipi.noda.api.core.operators.filterOperators.FilterOperator;
import org.junit.Ignore;
import org.junit.Test;
import java.util.Random;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Date;
import java.net.UnknownHostException;
import java.util.concurrent.TimeUnit;
import java.util.Scanner;
import static gr.ds.unipi.noda.api.core.operators.FilterOperators.*;
import java.util.Set;
import java.util.HashSet;

public class CassandraDatabaseTest{

    @Ignore
    @Test
    public void simpleFilterTest() throws UnknownHostException {
        NoSqlDbSystem noSqlDbSystem = NoSqlDbSystem.Cassandra().Builder("datacenter1","testKeyspace").ipv4Address("172.18.0.2").build();
        noSqlDbSystem.operateOn("testtable").filter(eq("string","Frank Neal")).printScreen();
        noSqlDbSystem.closeConnection();
    }

    @Ignore
    @Test
    public void simpleGroupByTest() {
//
//        NoSqlDbSystem noSqlDbSystem = NoSqlDbSystem.CassandraDataBase().Builder(/*Your defined parameters here*/).host("localhost").port(/*Set your port here*/)/*in case you have optional parameters, call the respective methods here*/.build();
//
//        noSqlDbSystem.operateOn(/*Your collection name or table name here*/).groupBy("columnA").printScreen();
//
//        noSqlDbSystem.closeConnection();
    }

    @Ignore
    @Test
    public void groupByCombinedWithAggregationTest() {

//        NoSqlDbSystem noSqlDbSystem = NoSqlDbSystem.CassandraDataBase().Builder(/*Your defined parameters here*/).host("localhost").port(/*Set your port here*/)/*in case you have optional parameters, call the respective methods here*/.build();
//
//        noSqlDbSystem.operateOn(/*Your collection name or table name here*/).groupBy("columnA").aggregate(sum("columnB")).printScreen();
//
//        noSqlDbSystem.closeConnection();
    }

    @Ignore
    @Test
    public void logicalOperatorTest() {

//        NoSqlDbSystem noSqlDbSystem = NoSqlDbSystem.CassandraDataBase().Builder(/*Your defined parameters here*/).host("localhost").port(/*Set your port here*/)/*in case you have optional parameters, call the respective methods here*/.build();
//
//        noSqlDbSystem.operateOn(/*Your collection name or table name here*/).filter(and(gte("columnA",10), lte("columnA",100))).printScreen();
//
//        noSqlDbSystem.closeConnection();
    }

    @Ignore
    @Test
    public void stucturalSharingTest() {

//        NoSqlDbSystem noSqlDbSystem = NoSqlDbSystem.CassandraDataBase().Builder(/*Your defined parameters here*/).host("localhost").port(/*Set your port here*/)/*in case you have optional parameters, call the respective methods here*/.build();
//
//        NoSqlDbOperators noSqlDbOperators = noSqlDbSystem.operateOn(""/*Your collection name or table name here*/);
//
//        NoSqlDbOperators var = noSqlDbOperators.filter(and(gte("columnA",10), lte("columnA",100)));
//        var = noSqlDbOperators.groupBy("columnA");
//        var.printScreen();
//
//        noSqlDbSystem.closeConnection();
    }

    @Test
    public void testInterface() throws UnknownHostException {
        NoSqlDbSystem cassandra = NoSqlDbSystem.Cassandra().Builder("datacenter1","testKeyspace").ipv4Address("192.168.2.4").build();
    }

    @Test
    public void testConnection() throws UnknownHostException, InterruptedException {
        NoSqlDbSystem cassandra = NoSqlDbSystem.Cassandra().Builder("datacenter1","testKeyspace").build();
        cassandra.operateOn("").printScreen();
        System.out.println("TIMER START");
        TimeUnit.MINUTES.sleep(1);
        System.out.println("TIMER FINISH");
        cassandra.closeConnection();
    }

    @Test
    public void testInsert() throws UnknownHostException, FileNotFoundException {
        NoSqlDbSystem cassandra = NoSqlDbSystem.Cassandra().Builder("datacenter1","testKeyspace").ipv4Address("172.18.0.2").build();
        NoSqlDbInserts cassandraInsert =  cassandra.insertionsOn("testtable2");
        Scanner scanner = new Scanner(new File("/home/george/Projects/Test/insertLines.csv"));
        while (scanner.hasNextLine()) {

            // Simple fields
            String[] currentLine = scanner.nextLine().split(",");
            FieldValue<Short> shortFieldValue = FieldValue.newFieldValue("short", Short.parseShort(currentLine[0]));
            FieldValue<Integer> integerFieldValue = FieldValue.newFieldValue("integer", Integer.parseInt(currentLine[1]));
            FieldValue<Long> longFieldValue = FieldValue.newFieldValue("long", Long.parseLong(currentLine[2]));
            FieldValue<Boolean> booleanFieldValue = FieldValue.newFieldValue("boolean", Boolean.parseBoolean(currentLine[3]));
            FieldValue<Date> dateFieldValue = FieldValue.newFieldValue("date", new Date(Long.parseLong(currentLine[4])));
            FieldValue<String> stringFieldValue = FieldValue.newOFieldValue("string", currentLine[5]);


            cassandraInsert.insert(shortFieldValue, integerFieldValue, longFieldValue, booleanFieldValue, dateFieldValue, stringFieldValue);
        }
    }

    @Test
    public void testDropField() throws UnknownHostException {
       NoSqlDbSystem cassandra = NoSqlDbSystem.Cassandra().Builder("datacenter1","testKeyspace").ipv4Address("172.18.0.2").build();
       cassandra.deletionsOn("testTable2").delete("boolean").flush();
    }

    @Test
    public void testDeleteFieldValues() throws UnknownHostException {
        NoSqlDbSystem cassandra = NoSqlDbSystem.Cassandra().Builder("datacenter1","testKeyspace").ipv4Address("172.18.0.2").build();
        cassandra.deletionsOn("testtable2").delete(and(eq("integer",51), eq("short",6)), "boolean");
        cassandra.deletionsOn("testtable2").flush();
    }

    @Test
    public void testUpdate() throws UnknownHostException {
        NoSqlDbSystem cassandra = NoSqlDbSystem.Cassandra().Builder("datacenter1","testKeyspace").ipv4Address("172.18.0.2").build();
        cassandra.updatesOn("testtable2").update(and(eq("short",6),eq("integer",1016)),FieldValue.newOFieldValue("string","Sally Abbott"));
        Integer[] integers = {-2,-1,0,1,2,3,4,5,6,7,8};
        cassandra.updatesOn("testtable2").update(and(eq("short",6),eq("integer",723)),FieldValue.newFieldValue("integerList",integers),FieldValue.newFieldValue("long",-600), FieldValue.newOFieldValue("string","Luis Patrick"));
        cassandra.updatesOn("testtable2").flush();
    }
}
