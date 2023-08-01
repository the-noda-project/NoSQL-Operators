package gr.ds.unipi.noda.api.client.cassandradatabase;

import gr.ds.unipi.noda.api.client.NoSqlDbSystem;
import gr.ds.unipi.noda.api.core.nosqldb.NoSqlDbOperators;
import gr.ds.unipi.noda.api.core.nosqldb.NoSqlDbRecord;
import gr.ds.unipi.noda.api.core.nosqldb.NoSqlDbResults;
import gr.ds.unipi.noda.api.core.operators.SortOperators;
import gr.ds.unipi.noda.api.core.operators.aggregateOperators.AggregateOperator;
import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.Coordinates;
import org.junit.Test;

import java.util.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.UnknownHostException;
import java.util.stream.Collectors;

import static gr.ds.unipi.noda.api.core.operators.FilterOperators.*;
import static gr.ds.unipi.noda.api.core.operators.AggregateOperators.*;


public class CassandraDatabaseTest{

    /*

     * Testing for USOLevel = 1
     *
     */

    @Test
    public void testA(){
        NoSqlDbSystem cassandraUSOLevel1 = NoSqlDbSystem.Cassandra().Builder("/home/george/Projects/NoSQL-Operators/noda-client/src/test/java/gr/ds/unipi/noda/api/client/cassandradatabase/application.conf").USOLevel(1).build();
        NoSqlDbOperators cassandraOperators = cassandraUSOLevel1.operateOn("testtable");
        cassandraOperators.filter(ne("short",90));
        cassandraOperators.printScreen();
        cassandraUSOLevel1.closeConnection();
    }

    @Test
    public void testB(){
        NoSqlDbSystem cassandraUSOLevel1 = NoSqlDbSystem.Cassandra().Builder("/home/george/Projects/NoSQL-Operators/noda-client/src/test/java/gr/ds/unipi/noda/api/client/cassandradatabase/application.conf").USOLevel(1).build();
        NoSqlDbOperators cassandraOperators = cassandraUSOLevel1.operateOn("customers");
        cassandraOperators.aggregate(max("customerId"));
        cassandraOperators.filter(anyKeywords("contacttile","Manager"));
        cassandraOperators.printScreen();
        cassandraUSOLevel1.closeConnection();
    }

    @Test
    public void testC() throws UnknownHostException {
        NoSqlDbSystem cassandraUSOLevel1 = NoSqlDbSystem.Cassandra().Builder("/home/george/Projects/NoSQL-Operators/noda-client/src/test/java/gr/ds/unipi/noda/api/client/cassandradatabase/application.conf").USOLevel(1).ipv4Address("127.0.0.1").build();
        NoSqlDbOperators noSqlDbOperators = cassandraUSOLevel1.operateOn("customers");
        noSqlDbOperators.filter(inGeoCircleKm("location", Coordinates.newCoordinates(0, 0), 48));
        noSqlDbOperators.filter(anyKeywords("city", "Sao"));
        noSqlDbOperators.project("customerid","location");
        noSqlDbOperators.printScreen();
        cassandraUSOLevel1.closeConnection();
    }

    @Test
    public void testD() throws UnknownHostException {
        NoSqlDbSystem cassandraUSOLevel1 = NoSqlDbSystem.Cassandra().Builder("/home/george/Projects/NoSQL-Operators/noda-client/src/test/java/gr/ds/unipi/noda/api/client/cassandradatabase/application.conf").USOLevel(1).ipv4Address("127.0.0.1").build();
        NoSqlDbOperators noSqlDbOperators = cassandraUSOLevel1.operateOn("customers");
        noSqlDbOperators.filter(and(allKeywords("contacttile", "Sales", "Manager"),inGeoPolygon("location", Coordinates.newCoordinates(0,0.5),Coordinates.newCoordinates(0.5,-0.5),Coordinates.newCoordinates(-0.5,-0.5))));
        noSqlDbOperators.project("customerid","companyname");
        noSqlDbOperators.printScreen();
        cassandraUSOLevel1.closeConnection();
    }

    @Test
    public void testE() throws UnknownHostException {
        NoSqlDbSystem cassandraUSOLevel1 = NoSqlDbSystem.Cassandra().Builder("/home/george/Projects/NoSQL-Operators/noda-client/src/test/java/gr/ds/unipi/noda/api/client/cassandradatabase/application.conf").USOLevel(1).ipv4Address("127.0.0.1").build();
        NoSqlDbOperators noSqlDbOperators = cassandraUSOLevel1.operateOn("customers");
        noSqlDbOperators.aggregate(countNonNull("region"));
        noSqlDbOperators.filter(ne("customerid","WARTH"));
        noSqlDbOperators.printScreen();
        cassandraUSOLevel1.closeConnection();
    }

    @Test
    public void testF() throws UnknownHostException {
        NoSqlDbSystem cassandraUSOLevel1 = NoSqlDbSystem.Cassandra().Builder("/home/george/Projects/NoSQL-Operators/noda-client/src/test/java/gr/ds/unipi/noda/api/client/cassandradatabase/application.conf").USOLevel(1).ipv4Address("127.0.0.1").build();
        NoSqlDbOperators noSqlDbOperators = cassandraUSOLevel1.operateOn("testtable");
        noSqlDbOperators.project("short");
        noSqlDbOperators.filter(ne("boolean", false));
        noSqlDbOperators.limit(10);
        noSqlDbOperators.printScreen();
        cassandraUSOLevel1.closeConnection();
    }

    @Test
    public void testG() throws UnknownHostException {
        NoSqlDbSystem cassandraUSOLevel1 = NoSqlDbSystem.Cassandra().Builder("/home/george/Projects/NoSQL-Operators/noda-client/src/test/java/gr/ds/unipi/noda/api/client/cassandradatabase/application.conf").USOLevel(1).ipv4Address("127.0.0.1").build();
        NoSqlDbOperators noSqlDbOperators = cassandraUSOLevel1.operateOn("customers");
        noSqlDbOperators.project("customerid","companyname");
        noSqlDbOperators.filter(eq("customerid","WARTH"));
        noSqlDbOperators.sort(SortOperators.asc("companyname"));
        noSqlDbOperators.limit(3);
        noSqlDbOperators.printScreen();
        cassandraUSOLevel1.closeConnection();
    }

    @Test
    public void testH() throws UnknownHostException {
        NoSqlDbSystem cassandraUSOLevel1 = NoSqlDbSystem.Cassandra().Builder("/home/george/Projects/NoSQL-Operators/noda-client/src/test/java/gr/ds/unipi/noda/api/client/cassandradatabase/application.conf").USOLevel(1).ipv4Address("127.0.0.1").build();
        NoSqlDbOperators noSqlDbOperators = cassandraUSOLevel1.operateOn("customers");
        noSqlDbOperators.project("customerid","companyname");
        noSqlDbOperators.filter(eq("customerid","WARTH"));
        noSqlDbOperators.sort(SortOperators.desc("companyname"));
        noSqlDbOperators.limit(3);
        noSqlDbOperators.printScreen();
        cassandraUSOLevel1.closeConnection();
    }

    @Test
    public void testI() throws UnknownHostException {
        NoSqlDbSystem cassandraUSOLevel1 = NoSqlDbSystem.Cassandra().Builder("/home/george/Projects/NoSQL-Operators/noda-client/src/test/java/gr/ds/unipi/noda/api/client/cassandradatabase/application.conf").USOLevel(1).ipv4Address("127.0.0.1").build();
        NoSqlDbOperators noSqlDbOperators = cassandraUSOLevel1.operateOn("customers");
        noSqlDbOperators.aggregate(min("date"));
        noSqlDbOperators.filter(inGeoCircleKm("location",Coordinates.newCoordinates(0,0),200));
        noSqlDbOperators.printScreen();
        cassandraUSOLevel1.closeConnection();
    }

    @Test
    public void testJ() throws UnknownHostException {
        NoSqlDbSystem cassandraUSOLevel1 = NoSqlDbSystem.Cassandra().Builder("/home/george/Projects/NoSQL-Operators/noda-client/src/test/java/gr/ds/unipi/noda/api/client/cassandradatabase/application.conf").USOLevel(1).ipv4Address("127.0.0.1").build();
        NoSqlDbOperators noSqlDbOperators = cassandraUSOLevel1.operateOn("customers");
        noSqlDbOperators.project("customerid","location","date");
        noSqlDbOperators.filter(inGeoTemporalRectangle("location",Coordinates.newCoordinates(-1,-1),Coordinates.newCoordinates(1,1),"date",new Date(1596194531000L),new Date(3489650531000L)));
        noSqlDbOperators.printScreen();
        cassandraUSOLevel1.closeConnection();
    }

    @Test
    public void testK() throws UnknownHostException {
        NoSqlDbSystem cassandraUSOLevel1 = NoSqlDbSystem.Cassandra().Builder("/home/george/Projects/NoSQL-Operators/noda-client/src/test/java/gr/ds/unipi/noda/api/client/cassandradatabase/application.conf").USOLevel(1).ipv4Address("127.0.0.1").build();
        NoSqlDbOperators noSqlDbOperators = cassandraUSOLevel1.operateOn("customers");
        noSqlDbOperators.aggregate(countDistinct("county"));
        noSqlDbOperators.filter(inGeoTemporalPolygon("location", "date", new Date(1596194531000L), new Date(3489650531000L), Coordinates.newCoordinates(0, 0.5), Coordinates.newCoordinates(0.5, -0.5), Coordinates.newCoordinates(-0.5, -0.5)));
        noSqlDbOperators.printScreen();
        cassandraUSOLevel1.closeConnection();
    }

    @Test
    public void testM() throws UnknownHostException {
        NoSqlDbSystem cassandraUSOLevel1 = NoSqlDbSystem.Cassandra().Builder("/home/george/Projects/NoSQL-Operators/noda-client/src/test/java/gr/ds/unipi/noda/api/client/cassandradatabase/application.conf").USOLevel(1).ipv4Address("127.0.0.1").build();
        NoSqlDbOperators noSqlDbOperators = cassandraUSOLevel1.operateOn("customers");
        noSqlDbOperators.project("customerid");
        noSqlDbOperators.filter(gte("date", new Date(1596194531000L)), lte("date", new Date(3489650531000L)));
        noSqlDbOperators.filter(inGeoRectangle("location",Coordinates.newCoordinates(-0.5,-0.5), Coordinates.newCoordinates(0.5,0.5)));
        noSqlDbOperators.printScreen();
        cassandraUSOLevel1.closeConnection();
    }
}
