package gr.ds.unipi.noda.api.client;

import org.junit.Test;

import static gr.ds.unipi.noda.api.core.operators.AggregateOperators.max;
import static org.junit.Assert.*;

public class NoSqlDbSystemTest {

    @Test
    public void neo4j() {
        NoSqlDbSystem.Neo4j().build().operateOn("coll1").groupBy("", max(""));

    }
}