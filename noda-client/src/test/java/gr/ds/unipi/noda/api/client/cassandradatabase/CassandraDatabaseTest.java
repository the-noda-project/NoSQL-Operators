package gr.ds.unipi.noda.api.client.cassandradatabase;

import gr.ds.unipi.noda.api.client.NoSqlDbSystem;
import gr.ds.unipi.noda.api.core.nosqldb.modifications.FieldValue;
import gr.ds.unipi.noda.api.core.nosqldb.modifications.NoSqlDbInserts;
import org.junit.Ignore;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Field;
import java.util.Date;
import java.net.UnknownHostException;
import java.util.concurrent.TimeUnit;
import java.util.Scanner;
import static gr.ds.unipi.noda.api.core.operators.FilterOperators.*;

public class CassandraDatabaseTest{

    @Ignore
    @Test
    public void simpleFilterTest() throws UnknownHostException {

        NoSqlDbSystem noSqlDbSystem = NoSqlDbSystem.Cassandra().Builder("datacenter1","testKeyspace").build();
        long dateInMl = Long.parseLong("825166800000");
        Date date = new Date(dateInMl);
        noSqlDbSystem.operateOn("testtable").filter(gt("date",date)).printScreen();
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
        NoSqlDbSystem cassandra = NoSqlDbSystem.Cassandra().Builder("datacenter1","testtKeyspace").ipv4Address("172.18.0.2").build();
        NoSqlDbInserts cassandraInsert =  cassandra.insertionsOn("testTable");
        Scanner scanner = new Scanner(new File("/home/george/Projects/Test/insertLines.csv"));
        while (scanner.hasNextLine()) {

            // Simple fields
            String[] currentLine = scanner.nextLine().split(",");
            FieldValue<Short> shortFieldValue = FieldValue.newFieldValue("short", Short.parseShort(currentLine[0]));
            FieldValue<Integer> integerFieldValue = FieldValue.newFieldValue("integer", Integer.parseInt(currentLine[1]));
            FieldValue<Long> longFieldValue = FieldValue.newFieldValue("long", Long.parseLong(currentLine[2]));
            FieldValue<Float> floatFieldValue = FieldValue.newFieldValue("float", Float.parseFloat(currentLine[3]));
            FieldValue<Double> doubleFieldValue = FieldValue.newFieldValue("double", Double.parseDouble(currentLine[4]));
            FieldValue<Boolean> booleanFieldValue = FieldValue.newFieldValue("boolean", Boolean.parseBoolean(currentLine[5]));
            FieldValue<Date> dateFieldValue = FieldValue.newFieldValue("date", new Date(Long.parseLong(currentLine[7])));
            FieldValue<String> stringFieldValue = FieldValue.newOFieldValue("string", currentLine[14]);

            // List fields
            Boolean[] booleanList = new Boolean[5];
            for(int i=0; i<5; i++){
                booleanList[i] = Boolean.parseBoolean(currentLine[6].split(" ")[i]);
            }
            FieldValue<Boolean[]> booleanFieldList = FieldValue.newFieldValue("booleanlist", booleanList);

            Date[] dateList = new Date[5];
            for(int i=0; i<5; i++){
                dateList[i] = new Date((Long.parseLong(currentLine[8].split(" ")[i])));
            }
            FieldValue<Date[]> dateFieldList = FieldValue.newFieldValue("datelist", dateList);

            Double[] doubleList = new Double[5];
            for(int i=0; i<5; i++){
                doubleList[i] = Double.parseDouble(currentLine[9].split(" ")[i]);
            }
            FieldValue<Double[]> doubleFieldList = FieldValue.newFieldValue("doublelist", doubleList);

            Float[] floatList = new Float[5];
            for(int i=0; i<5; i++){
                floatList[i] = Float.parseFloat(currentLine[10].split(" ")[i]);
            }
            FieldValue<Float[]> floatFieldList = FieldValue.newFieldValue("floatlist", floatList);

            Integer[] integerList = new Integer[5];
            for(int i=0; i<5; i++){
                integerList[i] = Integer.parseInt(currentLine[11].split(" ")[i]);
            }
            FieldValue<Integer[]> integerFieldList = FieldValue.newFieldValue("integerlist", integerList);

            Long[] longList = new Long[5];
            for(int i=0; i<5; i++){
                longList[i] = Long.parseLong(currentLine[12].split(" ")[i]);
            }
            FieldValue<Long[]> longFieldList = FieldValue.newFieldValue("longlist", longList);

            Short[] shortList = new Short[5];
            for(int i=0; i<5; i++){
                shortList[i] = Short.parseShort(currentLine[13].split(" ")[i]);
            }
            FieldValue<Short[]> shortFieldList = FieldValue.newFieldValue("shortlist", shortList);

            String[] stringList = currentLine[15].split(" ");
            FieldValue<String[]> stringFieldList = FieldValue.newOFieldValue("stringlist", stringList);

            cassandraInsert.insert(shortFieldValue, integerFieldValue, longFieldValue, floatFieldValue, doubleFieldValue, booleanFieldValue, booleanFieldList, dateFieldValue, dateFieldList, doubleFieldList, floatFieldList, integerFieldList, longFieldList, shortFieldList, stringFieldValue, stringFieldList);
        }


    }
}
