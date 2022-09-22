package gr.ds.unipi.noda.api.client;

import gr.ds.unipi.noda.api.core.nosqldb.NoSqlDbOperators;
import org.apache.spark.sql.SparkSession;
import org.junit.Test;

import static gr.ds.unipi.noda.api.core.operators.FilterOperators.*;

public class CouchDBSystemTest {

    @Test
    public void mongodbTest() {

        NoSqlDbSystem noSqlDbSystem = NoSqlDbSystem.CouchDB().Builder("myUserAdmin","myPass","database").host("localhost").port(1234).build();
        NoSqlDbOperators noSqlDbOperators = noSqlDbSystem.operateOn("collection/table");

        System.out.println(noSqlDbOperators.filter(gte("myField",4)).count());

        System.out.println(noSqlDbOperators.filter(eq("myField",4)).count());

        System.out.println(noSqlDbOperators.filter(or(gte("myField",5), eq("myField",4))).count());

        noSqlDbSystem.closeConnection();

    }
}
