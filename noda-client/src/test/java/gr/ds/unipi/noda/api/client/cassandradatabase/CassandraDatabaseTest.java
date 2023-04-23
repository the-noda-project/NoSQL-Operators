package gr.ds.unipi.noda.api.client.cassandradatabase;

import gr.ds.unipi.noda.api.client.NoSqlDbSystem;
import gr.ds.unipi.noda.api.core.nosqldb.NoSqlDbOperators;
import gr.ds.unipi.noda.api.core.nosqldb.NoSqlDbRecord;
import gr.ds.unipi.noda.api.core.nosqldb.NoSqlDbResults;
import gr.ds.unipi.noda.api.core.nosqldb.modifications.FieldValue;
import gr.ds.unipi.noda.api.core.nosqldb.modifications.NoSqlDbInserts;
import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.Coordinates;
import org.junit.Ignore;
import org.junit.Test;
import static gr.ds.unipi.noda.api.core.operators.AggregateOperators.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.Date;
import java.net.UnknownHostException;
import java.util.concurrent.TimeUnit;
import java.util.Scanner;
import static gr.ds.unipi.noda.api.core.operators.FilterOperators.*;
import static gr.ds.unipi.noda.api.core.operators.SortOperators.asc;
import static gr.ds.unipi.noda.api.core.operators.SortOperators.desc;


public class CassandraDatabaseTest{

    @Ignore
    @Test
    public void simpleFilterTest() throws UnknownHostException {
        NoSqlDbSystem cassandra = NoSqlDbSystem.Cassandra().Builder("datacenter1","testKeyspace").ipv4Address("127.0.0.1").build();
        NoSqlDbOperators cassandraOperators = cassandra.operateOn("testtable");
        cassandraOperators.project("short","integer","date");
        cassandraOperators.filter(eq("short", 6));
        cassandraOperators.filter(eq("string", "Maria"));
        cassandraOperators.sort(asc("integer"));
        cassandraOperators.printScreen();
        cassandra.closeConnection();
    }

    @Ignore
    @Test
    public void simpleGroupByTest() throws UnknownHostException {
        NoSqlDbSystem cassandra = NoSqlDbSystem.Cassandra().Builder("datacenter1","testKeyspace").ipv4Address("127.0.0.1").build();
        cassandra.operateOn("testtable").project("short","integer").groupBy("short").filter(eq("string","Maria")).printScreen();
        cassandra.closeConnection();
    }

    @Ignore
    @Test()
    public void groupByCombinedWithAggregationTest() throws UnknownHostException {
        NoSqlDbSystem cassandra = NoSqlDbSystem.Cassandra().Builder("datacenter1","testKeyspace").ipv4Address("127.0.0.1").build();
        cassandra.operateOn("testtable").groupBy("short").aggregate(max("integer")).filter(gte("integer",7000)).printScreen();
        cassandra.closeConnection();
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
        NoSqlDbSystem cassandra = NoSqlDbSystem.Cassandra().Builder("datacenter1","testKeyspace").ipv4Address("127.0.0.1").build();
        NoSqlDbOperators cassandraOperators = cassandra.operateOn("testTable");
        cassandraOperators.limit(10).printScreen();
    }

    @Test
    public void testConnectionAppConfig(){
        NoSqlDbSystem cassandra = NoSqlDbSystem.Cassandra().Builder("/home/george/Projects/NoSQL-Operators/noda-client/src/test/java/gr/ds/unipi/noda/api/client/cassandradatabase/application.conf").build();
        NoSqlDbOperators cassandraOperators = cassandra.operateOn("testTable");
        cassandraOperators.limit(10).printScreen();
    }

    @Test
    public void testInsert() throws UnknownHostException, FileNotFoundException, ParseException {
        NoSqlDbSystem cassandra = NoSqlDbSystem.Cassandra().Builder("datacenter1","testKeyspace").ipv4Address("127.0.0.1").build();
        NoSqlDbInserts cassandraInsert =  cassandra.insertionsOn("testtable");
        SimpleDateFormat df = new SimpleDateFormat("yyyy/mm/dd");
        Scanner scanner = new Scanner(new File("/home/george/Downloads/records.csv"));
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] fields = line.split(",");
            short shortValue = Short.parseShort(fields[0]);
            int integerValue = Integer.parseInt(fields[1]);
            boolean booleanValue = Boolean.parseBoolean(fields[2]);
            String stringDate = fields[3];
            Date dateValue = df.parse(stringDate);
            double doubleValue = Double.parseDouble(fields[4]);
            float floatValue = Float.parseFloat(fields[5]);
            long longValue = Long.parseLong(fields[6]);
            String stringValue = fields[7];
            cassandraInsert.insert(FieldValue.newFieldValue("short", shortValue), FieldValue.newFieldValue("integer", integerValue), FieldValue.newFieldValue("boolean",booleanValue), FieldValue.newFieldValue("date", dateValue), FieldValue.newFieldValue("double", doubleValue), FieldValue.newFieldValue("float", floatValue), FieldValue.newFieldValue("long", longValue), FieldValue.newOFieldValue("string", stringValue));
        }
        cassandra.closeConnection();
    }

    @Test
    public void testDropField() throws UnknownHostException {
       NoSqlDbSystem cassandra = NoSqlDbSystem.Cassandra().Builder("datacenter1","testKeyspace").ipv4Address("172.18.0.2").build();
       cassandra.deletionsOn("testTable2").delete("boolean").flush();
       cassandra.closeConnection();
    }

    @Test
    public void testDeleteFieldValues() throws UnknownHostException {
        NoSqlDbSystem cassandra = NoSqlDbSystem.Cassandra().Builder("datacenter1","testKeyspace").ipv4Address("172.18.0.2").build();
        cassandra.deletionsOn("testtable2").delete(and(eq("integer",51), eq("short",6)), "boolean");
        cassandra.deletionsOn("testtable2").flush();
        cassandra.closeConnection();
    }

    @Test
    public void testUpdate() throws UnknownHostException {
        NoSqlDbSystem cassandra = NoSqlDbSystem.Cassandra().Builder("datacenter1","testKeyspace").ipv4Address("172.18.0.2").build();
        cassandra.updatesOn("testtable2").update(and(eq("short",6),eq("integer",1016)),FieldValue.newOFieldValue("string","Sally Abbott"));
        Integer[] integers = {-2,-1,0,1,2,3,4,5,6,7,8};
        cassandra.updatesOn("testtable2").update(and(eq("short",6),eq("integer",723)),FieldValue.newFieldValue("integerList",integers),FieldValue.newFieldValue("long",-600), FieldValue.newOFieldValue("string","Luis Patrick"));
        cassandra.updatesOn("testtable2").flush();
        cassandra.closeConnection();
    }

    @Test
    public void testAggregate() throws UnknownHostException {
        NoSqlDbSystem cassandra = NoSqlDbSystem.Cassandra().Builder("datacenter1","testKeyspace").ipv4Address("127.0.0.1").build();
        NoSqlDbOperators  cassandraOperators = cassandra.operateOn("testtable");
        cassandraOperators.aggregate(sum("integer"));
        cassandraOperators.aggregate(avg("short"));
        cassandraOperators.aggregate(min("integer"));
        cassandraOperators.aggregate(max("integer"));
        cassandraOperators.aggregate(count());
        cassandraOperators.printScreen();
        cassandra.closeConnection();
    }

    @Test
    public void testAggregateFunctions() throws UnknownHostException {
        NoSqlDbSystem cassandra = NoSqlDbSystem.Cassandra().Builder("datacenter1","testKeyspace").ipv4Address("127.0.0.1").build();
        NoSqlDbOperators  cassandraOperators = cassandra.operateOn("testtable");
        //Max function
        cassandraOperators.filter(and(eq("boolean",true),lte("integer",70)));
        Double max = cassandraOperators.max("integer").get();
        System.out.println("The max value is " + max);
        //Min function
        cassandraOperators.filter(and(eq("boolean",false),lte("integer",70)));
        Double min = cassandraOperators.min("integer").get();
        System.out.println("The min value is " + min);
        //Sum function
        cassandraOperators.filter(and(eq("string","Maria"),gte("integer",70)));
        Double sum = cassandraOperators.sum("integer").get();
        System.out.println("The sum value is " + sum);
        //Avg function
        cassandraOperators.filter(eq("string","Maria"));
        Double avg = cassandraOperators.avg("integer").get();
        System.out.println("The avg value is " + avg);
        //Count function
        cassandraOperators.filter(eq("boolean",true));
        int count = cassandraOperators.count();
        System.out.println("The cout value is " + count);
        cassandra.closeConnection();
    }

    @Test
    public void test() throws UnknownHostException {
        NoSqlDbSystem cassandra = NoSqlDbSystem.Cassandra().Builder("datacenter1","testKeyspace").ipv4Address("127.0.0.1").build();
        NoSqlDbOperators  cassandraOperators = cassandra.operateOn("testtable");
        cassandraOperators.sort(asc("FieldName"));
        cassandra.closeConnection();
    }

    @Test
    public void testLimitOperator() throws UnknownHostException {
        NoSqlDbSystem cassandra = NoSqlDbSystem.Cassandra().Builder("datacenter1","testKeyspace").ipv4Address("127.0.0.1").build();
        NoSqlDbOperators  cassandraOperators = cassandra.operateOn("testtable");
        cassandraOperators.sort(desc("integer")).project("string").filter(eq("short", 6)).limit(10).printScreen();
    }

    @Test
    public void testResultsOperator() throws UnknownHostException {
        NoSqlDbSystem cassandra = NoSqlDbSystem.Cassandra().Builder("datacenter1","testKeyspace").ipv4Address("127.0.0.1").build();
        NoSqlDbOperators  cassandraOperators = cassandra.operateOn("testtable").filter(eq("short", 6 )).filter(eq("integer", 607)).limit(1);
        NoSqlDbResults results = cassandraOperators.getResults();
        System.out.println("THE RESULTS ARE: ");
        while(results.hasNextRecord()){
            NoSqlDbRecord record = results.getRecord();
            System.out.println(record.toString());
            System.out.println(record.containsValue(LocalDate.of(2113,3, 29)));
        }
        cassandra.closeConnection();
    }

    @Test
    public void testGeoOperatorRectangle() throws InterruptedException {
        NoSqlDbSystem cassandra = NoSqlDbSystem.Cassandra().Builder("/home/george/Projects/NoSQL-Operators/noda-client/src/test/java/gr/ds/unipi/noda/api/client/cassandradatabase/application.conf").build();
        NoSqlDbOperators cassandraOperators = cassandra.operateOn("spatialTable");
        cassandraOperators.filter(inGeoRectangle("geoHash", Coordinates.newCoordinates(-25.75,28.65), Coordinates.newCoordinates(28.3,-25.58)));
        cassandraOperators.printScreen();
    }

    @Test
    public void testGeoPolygonOperator() throws InterruptedException {
        NoSqlDbSystem cassandra = NoSqlDbSystem.Cassandra().Builder("/home/george/Projects/NoSQL-Operators/noda-client/src/test/java/gr/ds/unipi/noda/api/client/cassandradatabase/application.conf").build();
        NoSqlDbOperators cassandraOperators = cassandra.operateOn("spatialTable");
        cassandraOperators.filter(inGeoPolygon("geoHash", Coordinates.newCoordinates(28.16956, -25.60), Coordinates.newCoordinates(28.15, -25.62), Coordinates.newCoordinates(28.20, -25.62)));
        cassandraOperators.printScreen();
    }

    @Test
    public void testGeoTemporalOperator() throws  InterruptedException {
        NoSqlDbSystem cassandra = NoSqlDbSystem.Cassandra().Builder("/home/george/Projects/NoSQL-Operators/noda-client/src/test/java/gr/ds/unipi/noda/api/client/cassandradatabase/application.conf").build();
        NoSqlDbOperators cassandraOperators = cassandra.operateOn("spatioTemporalTable");
        Date startDate = new Date(Long.parseLong("1081185752000"));
        Date endDate = new Date(Long.parseLong("1081963352000"));
        cassandraOperators.filter(inGeoTemporalRectangle("geoHash",Coordinates.newCoordinates(-48.889,-39.749), Coordinates.newCoordinates(-48.801,-39.661), "date", startDate, endDate));
        cassandraOperators.printScreen();
        cassandra.closeConnection();
    }
}
