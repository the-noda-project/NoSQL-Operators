package gr.ds.unipi.noda.api.client;

import org.junit.Test;

import static gr.ds.unipi.noda.api.core.operators.AggregateOperators.max;
import static org.junit.Assert.*;

public class NoSqlDbSystemTest {

    @Test
    public void neo4j() {
        NoSqlDbSystem noSqlDbSystem = NoSqlDbSystem.Neo4j().username("myUsername").password("myPass").host("192.168.1.1").port(5000).database("myDatabase").build();
        noSqlDbSystem.operateOn("table").groupBy("field", max("anotherField"));
        noSqlDbSystem.closeConnection();
    }
}