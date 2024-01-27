package gr.ds.unipi.noda.api.client.roadNetworkOperatorsNeo4j;

import gr.ds.unipi.noda.api.client.NoSqlDbSystem;
import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.Coordinates;
import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.geometries.Point;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.junit.Ignore;
import org.junit.Test;

import java.util.Arrays;
import java.util.Date;

import static gr.ds.unipi.noda.api.core.operators.FilterOperators.*;


public class NoSqlDbSystemTest {

    @Ignore
    @Test
    public void shortestPathTest() {
        NoSqlDbSystem noSqlDbSystem = NoSqlDbSystem.Neo4j().Builder("neo4j", "nikos").host("localhost").port(7687).build();

        noSqlDbSystem.operateOn("something").filter(shortestPathInRoadNetwork("location", Point.newPoint(Coordinates.newCoordinates(0,0)), Point.newPoint(Coordinates.newCoordinates(1,1)))).printScreen();

        noSqlDbSystem.closeConnection();
    }

    @Ignore
    @Test
    public void nearestObjectTest() {

        Date datemin = new Date(1546992000);
        Date datemax = new Date(1547078400);

        NoSqlDbSystem noSqlDbSystem = NoSqlDbSystem.Neo4j().Builder("neo4j", "nikos").host("localhost").port(7687).build();

        noSqlDbSystem.operateOn("something").filter(nearestObjectInRoadNetwork("location", Point.newPoint(Coordinates.newCoordinates(0,0)), "temporal", datemin, datemax)).printScreen();

        noSqlDbSystem.closeConnection();
    }

    @Ignore
    @Test
    public void nearestInRangeTest() {

        Date datemin = new Date(1546992000);
        Date datemax = new Date(1547078400);

        NoSqlDbSystem noSqlDbSystem = NoSqlDbSystem.Neo4j().Builder("neo4j", "nikos").host("localhost").port(7687).build();

        noSqlDbSystem.operateOn("something").filter(nearestInRangeInRoadNetwork("location", Point.newPoint(Coordinates.newCoordinates(0,0)), 4,"temporal", datemin, datemax)).printScreen();

        noSqlDbSystem.closeConnection();
    }


}