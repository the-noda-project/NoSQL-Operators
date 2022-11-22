package gr.ds.unipi.noda.api.client.yyydatabase;

import gr.ds.unipi.noda.api.client.NoSqlDbSystem;

import gr.ds.unipi.noda.api.core.nosqldb.NoSqlDbOperators;
import org.junit.Ignore;
import org.junit.Test;

import static gr.ds.unipi.noda.api.core.operators.AggregateOperators.sum;
import static gr.ds.unipi.noda.api.core.operators.FilterOperators.*;

public class YYYDatabaseTest {

    @Ignore
    @Test
    public void simpleFilterTest() {

//        NoSqlDbSystem noSqlDbSystem = NoSqlDbSystem.YYYDataBase().Builder(/*Your defined parameters here*/).host("localhost").port(/*Set your port here*/)/*in case you have optional parameters, call the respective methods here*/.build();
//
//        noSqlDbSystem.operateOn(/*Your collection name or table name here*/).filter(gte("columnA",10)).printScreen();
//
//        noSqlDbSystem.closeConnection();
    }

    @Ignore
    @Test
    public void simpleGroupByTest() {
//
//        NoSqlDbSystem noSqlDbSystem = NoSqlDbSystem.YYYDataBase().Builder(/*Your defined parameters here*/).host("localhost").port(/*Set your port here*/)/*in case you have optional parameters, call the respective methods here*/.build();
//
//        noSqlDbSystem.operateOn(/*Your collection name or table name here*/).groupBy("columnA").printScreen();
//
//        noSqlDbSystem.closeConnection();
    }

    @Ignore
    @Test
    public void groupByCombinedWithAggregationTest() {

//        NoSqlDbSystem noSqlDbSystem = NoSqlDbSystem.YYYDataBase().Builder(/*Your defined parameters here*/).host("localhost").port(/*Set your port here*/)/*in case you have optional parameters, call the respective methods here*/.build();
//
//        noSqlDbSystem.operateOn(/*Your collection name or table name here*/).groupBy("columnA").aggregate(sum("columnB")).printScreen();
//
//        noSqlDbSystem.closeConnection();
    }

    @Ignore
    @Test
    public void logicalOperatorTest() {

//        NoSqlDbSystem noSqlDbSystem = NoSqlDbSystem.YYYDataBase().Builder(/*Your defined parameters here*/).host("localhost").port(/*Set your port here*/)/*in case you have optional parameters, call the respective methods here*/.build();
//
//        noSqlDbSystem.operateOn(/*Your collection name or table name here*/).filter(and(gte("columnA",10), lte("columnA",100))).printScreen();
//
//        noSqlDbSystem.closeConnection();
    }

    @Ignore
    @Test
    public void stucturalSharingTest() {

//        NoSqlDbSystem noSqlDbSystem = NoSqlDbSystem.YYYDataBase().Builder(/*Your defined parameters here*/).host("localhost").port(/*Set your port here*/)/*in case you have optional parameters, call the respective methods here*/.build();
//
//        NoSqlDbOperators noSqlDbOperators = noSqlDbSystem.operateOn(""/*Your collection name or table name here*/);
//
//        NoSqlDbOperators var = noSqlDbOperators.filter(and(gte("columnA",10), lte("columnA",100)));
//        var = noSqlDbOperators.groupBy("columnA");
//        var.printScreen();
//
//        noSqlDbSystem.closeConnection();
    }
}
