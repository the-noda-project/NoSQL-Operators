package gr.ds.unipi.noda.api.client.cassandradatabase;

import gr.ds.unipi.noda.api.client.NoSqlDbSystem;
import gr.ds.unipi.noda.api.core.nosqldb.NoSqlDbOperators;
import gr.ds.unipi.noda.api.core.nosqldb.NoSqlDbResults;
import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.Coordinates;
import org.junit.Test;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

import static gr.ds.unipi.noda.api.core.operators.AggregateOperators.*;
import static gr.ds.unipi.noda.api.core.operators.FilterOperators.*;
import static gr.ds.unipi.noda.api.core.operators.SortOperators.asc;
import static gr.ds.unipi.noda.api.core.operators.SortOperators.desc;


public class CassandraDatabaseTest {
    @Test
    public void test1() {
        NoSqlDbSystem cassandra = NoSqlDbSystem.Cassandra().Builder(
                "/home/george/Projects/NoSQL-Operators/noda-client/src/test/java/gr/ds/unipi/noda/api/client/cassandradatabase/application.conf"
        ).build();
        NoSqlDbOperators cassandraOperators = cassandra.operateOn("testtable");
        cassandraOperators.printScreen();
        cassandra.closeConnection();
    }

    @Test
    public void test2() {
        NoSqlDbSystem cassandra = NoSqlDbSystem.Cassandra().Builder(
                "/home/george/Projects/NoSQL-Operators/noda-client/src/test/java/gr/ds/unipi/noda/api/client/cassandradatabase/application.conf"
        ).build();
        NoSqlDbOperators cassandraOperators = cassandra.operateOn("testtable");
        cassandraOperators.project("short", "int", "string", "long", "location_longitude", "location_latitude");
        cassandraOperators.filter(and(ne("short", 90), inGeoCircleKm("location", Coordinates.newCoordinates(-50, 10), 10)));
        NoSqlDbResults results = cassandraOperators.getResults();
        try {
            FileWriter resultsFile = new FileWriter("/home/george/Projects/NoSQL-Operators/noda-client/src/test/java/gr/ds/unipi/noda/api/client/cassandradatabase/results2.csv");
            while (results.hasNextRecord())
                resultsFile.write(results.getRecord().toString() + '\n');
            resultsFile.flush();
            resultsFile.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        cassandra.closeConnection();
    }

    @Test
    public void test3() {
        NoSqlDbSystem cassandra = NoSqlDbSystem.Cassandra().Builder(
                "/home/george/Projects/NoSQL-Operators/noda-client/src/test/java/gr/ds/unipi/noda/api/client/cassandradatabase/application.conf"
        ).build();
        NoSqlDbOperators cassandraOperators = cassandra.operateOn("testtable");
        cassandraOperators.filter(and(gte("date", new Date(968579506000L)), lte("date", new Date(1599731506000L))));
        double maxDouble = cassandraOperators.max("double").get();
        System.out.println("The MAX(double) is :" + maxDouble);
    }

    @Test
    public void test4() {
        NoSqlDbSystem cassandra = NoSqlDbSystem.Cassandra().Builder(
                "/home/george/Projects/NoSQL-Operators/noda-client/src/test/java/gr/ds/unipi/noda/api/client/cassandradatabase/application.conf"
        ).build();
        NoSqlDbOperators cassandraOperators = cassandra.operateOn("testtable");
        cassandraOperators.aggregate(countDistinct("int"), countNonNull("int"));
        cassandraOperators.filter(and(eq("short", 0), inGeoTextualCircleKm("location", Coordinates.newCoordinates(-50, 10), 10
                , anyKeywords("string", "such", "hungry", "funny"))));
        cassandraOperators.groupBy("short");
        cassandraOperators.printScreen();
        cassandra.closeConnection();
    }

    @Test
    public void test5() {
        NoSqlDbSystem cassandra = NoSqlDbSystem.Cassandra().Builder(
                "/home/george/Projects/NoSQL-Operators/noda-client/src/test/java/gr/ds/unipi/noda/api/client/cassandradatabase/application.conf"
        ).build();
        NoSqlDbOperators cassandraOperators = cassandra.operateOn("testtable");
        cassandraOperators.aggregate(avg("int"), count(), min("date"));
        cassandraOperators.filter(and(
                inGeoTemporalPolygon("location", "date", new Date(968579506000L), new Date(1599731506000L),
                        Coordinates.newCoordinates(-50, 11), Coordinates.newCoordinates(-51, 9), Coordinates.newCoordinates(-49, 9)),
                inGeoTextualPolygon("location", allKeywords("string", "hungry", "increase"),
                        Coordinates.newCoordinates(-50, 11), Coordinates.newCoordinates(-51, 9), Coordinates.newCoordinates(-49, 9)),
                eq("short", 0)
        ));
        cassandraOperators.groupBy("short");
        cassandraOperators.sort(asc("int"));
        NoSqlDbResults results = cassandraOperators.getResults();
        try {
            FileWriter resultsFile = new FileWriter("/home/george/Projects/NoSQL-Operators/noda-client/src/test/java/gr/ds/unipi/noda/api/client/cassandradatabase/results5.csv");
            while (results.hasNextRecord())
                resultsFile.write(results.getRecord().toString() + '\n');
            resultsFile.flush();
            resultsFile.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        cassandra.closeConnection();
    }

    @Test
    public void test6() {
        NoSqlDbSystem cassandra = NoSqlDbSystem.Cassandra().Builder(
                "/home/george/Projects/NoSQL-Operators/noda-client/src/test/java/gr/ds/unipi/noda/api/client/cassandradatabase/application.conf"
        ).build();
        NoSqlDbOperators cassandraOperators = cassandra.operateOn("testtable");
        cassandraOperators.filter(and(gt("short", -80), lt("date", new Date(2294036994000L))));
        double intAvg = cassandraOperators.avg("int").get();
        System.out.println("The intAvg is :" + intAvg);
    }

    @Test
    public void test7() {
        NoSqlDbSystem cassandra = NoSqlDbSystem.Cassandra().Builder(
                "/home/george/Projects/NoSQL-Operators/noda-client/src/test/java/gr/ds/unipi/noda/api/client/cassandradatabase/application.conf"
        ).build();
        NoSqlDbOperators cassandraOperators = cassandra.operateOn("testtable");
        cassandraOperators.filter(and(
                inGeoPolygon("location", Coordinates.newCoordinates(-50, 11), Coordinates.newCoordinates(-51, 9), Coordinates.newCoordinates(-49, 9)),
                allKeywords("string", "help", "bye", "hello"),
                eq("short", 0)
        ));
        cassandraOperators.sort(desc("int"));
        cassandraOperators.limit(500);
        cassandraOperators.printScreen();
        cassandra.closeConnection();
    }

    @Test
    public void test8() {
        NoSqlDbSystem cassandra = NoSqlDbSystem.Cassandra().Builder(
                "/home/george/Projects/NoSQL-Operators/noda-client/src/test/java/gr/ds/unipi/noda/api/client/cassandradatabase/application.conf"
        ).build();
        NoSqlDbOperators cassandraOperators = cassandra.operateOn("testtable");
        cassandraOperators.filter(and(
                inGeoTemporalRectangle("location", Coordinates.newCoordinates(-51, 9), Coordinates.newCoordinates(-49, 11), "date", new Date(463761397000L), new Date(1599834997000L)),
                inGeoTextualRectangle("location", Coordinates.newCoordinates(-51, 9), Coordinates.newCoordinates(-49, 11), anyKeywords("string", "hello", "bye", "help"))
        ));
        double doubleSum = cassandraOperators.sum("double").get();
        System.out.println("The sum of the doubles are : " + doubleSum);
        cassandra.closeConnection();
    }

    @Test
    public void test9() {
        NoSqlDbSystem cassandra = NoSqlDbSystem.Cassandra().Builder(
                "/home/george/Projects/NoSQL-Operators/noda-client/src/test/java/gr/ds/unipi/noda/api/client/cassandradatabase/application.conf"
        ).build();
        NoSqlDbOperators cassandraOperators = cassandra.operateOn("testtable");
        cassandraOperators.filter(and(
                anyKeywords("string", "help", "hello", "bye"),
                inGeoCircleKm("location", Coordinates.newCoordinates(-50, 10), 50)
        ));
        cassandraOperators.printScreen();
        cassandra.closeConnection();
    }

    @Test
    public void test10() {
        NoSqlDbSystem cassandra = NoSqlDbSystem.Cassandra().Builder(
                "/home/george/Projects/NoSQL-Operators/noda-client/src/test/java/gr/ds/unipi/noda/api/client/cassandradatabase/application.conf"
        ).build();
        NoSqlDbOperators cassandraOperators = cassandra.operateOn("testtable");
        cassandraOperators.filter(inGeoRectangle("location", Coordinates.newCoordinates(-51, 9), Coordinates.newCoordinates(-49, 11)));
        int records = cassandraOperators.count();
        System.out.println("The records are : " + records);
        cassandra.closeConnection();
    }
}
