package gr.ds.unipi.noda.api.client;

import gr.ds.unipi.noda.api.core.nosqldb.NoSqlDbOperators;
import gr.ds.unipi.noda.api.core.nosqldb.NoSqlDbResults;
import gr.ds.unipi.noda.api.couchdb.aggregateOperators.OperatorCountDistinct;
import org.junit.Test;

import static gr.ds.unipi.noda.api.core.operators.AggregateOperators.avg;
import static gr.ds.unipi.noda.api.core.operators.FilterOperators.*;

public class CouchDBSystemTest {
    private NoSqlDbSystem getSystem() {
        return NoSqlDbSystem.CouchDB()
                .Builder("admin", "password")
                .host("localhost")
                .port(5984)
                .readTimeout(500)
                .connectTimeout(500)
                .build();
    }

    @Test
    public void couchdbTest() {
        getSystem().operateOn("people")
                .aggregate(OperatorCountDistinct.newOperatorCountDistinct("favoriteFruit"))
                .printScreen();
    }

    @Test
    public void simpleFilterTest() {
        NoSqlDbSystem noSqlDbSystem = getSystem();
        noSqlDbSystem.operateOn("people").filter(gte("age", 30)).printScreen();
        noSqlDbSystem.closeConnection();
    }

    @Test
    public void simpleGroupByTest() {
        NoSqlDbSystem noSqlDbSystem = getSystem();
        noSqlDbSystem.operateOn("people").groupBy("eyeColor").printScreen();
        noSqlDbSystem.closeConnection();
    }

    @Test
    public void groupByCombinedWithAggregationTest() {
        NoSqlDbSystem noSqlDbSystem = getSystem();
        NoSqlDbResults<?> res = noSqlDbSystem.operateOn("people")
                .groupBy("eyeColor", "isActive")
                .aggregate(avg("age"))
                .getResults();
        while (res.hasNextRecord()) {
            System.out.println(res.getRecord().toString());
        }
        noSqlDbSystem.closeConnection();
    }

    @Test
    public void logicalOperatorTest() {
        NoSqlDbSystem noSqlDbSystem = getSystem();
        noSqlDbSystem.operateOn("people").filter(and(gte("age", 22), lte("age", 40))).printScreen();
        noSqlDbSystem.closeConnection();
    }

    @Test
    public void structuralSharingTest() {
        NoSqlDbSystem noSqlDbSystem = getSystem();
        NoSqlDbOperators noSqlDbOperators = noSqlDbSystem.operateOn("people");

        NoSqlDbOperators var = noSqlDbOperators.filter(and(gte("weight", 200), lte("weight", 500)));
        var = noSqlDbOperators.groupBy("age").project("name");
        var.printScreen();

        noSqlDbSystem.closeConnection();
    }

    @Test
    public void getResultsTest() {
        NoSqlDbSystem noSqlDbSystem = getSystem();

        NoSqlDbResults<?> results = noSqlDbSystem.operateOn("people").filter(gte("age", 10)).getResults();

        while (results.hasNextRecord()) {
            System.out.println(results.getRecord());
        }

        noSqlDbSystem.closeConnection();
    }
}
