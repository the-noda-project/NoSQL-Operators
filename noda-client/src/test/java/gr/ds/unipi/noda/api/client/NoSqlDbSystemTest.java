package gr.ds.unipi.noda.api.client;

import org.junit.Test;

import static gr.ds.unipi.noda.api.core.operators.AggregateOperators.max;
import static gr.ds.unipi.noda.api.core.operators.FilterOperators.*;

public class NoSqlDbSystemTest {

    @Test
    public void neo4j() {
        NoSqlDbSystem noSqlDbSystem = NoSqlDbSystem.Neo4j().username("neo4j").password("nikos").host("localhost").port(7687).database("graph").build();
        noSqlDbSystem.operateOn("Ship").filter(eq("LAT","'-38.31416'")).printScreen();
        noSqlDbSystem.closeConnection();


    }
}