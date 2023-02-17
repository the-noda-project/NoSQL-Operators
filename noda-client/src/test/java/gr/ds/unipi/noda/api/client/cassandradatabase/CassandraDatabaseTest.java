package gr.ds.unipi.noda.api.client.cassandradatabase;

import gr.ds.unipi.noda.api.client.NoSqlDbSystem;
import gr.ds.unipi.noda.api.client.cassandra.CassandraSystem;
import org.junit.Ignore;
import org.junit.Test;
import java.util.Date;
import java.net.UnknownHostException;
import java.util.concurrent.TimeUnit;

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
}
