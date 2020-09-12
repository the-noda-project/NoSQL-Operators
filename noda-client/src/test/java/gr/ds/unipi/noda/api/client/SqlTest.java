package gr.ds.unipi.noda.api.client;

import gr.ds.unipi.noda.api.client.sql.NoSqlDbSqlStatement;
import org.junit.Ignore;
import org.junit.Test;

public class SqlTest {
    @Ignore
    @Test
    public void sqlTest() {

        //NoSqlDbSystem.MongoDB().Builder("asdf","asdf","sdaf").build().sql("SELECT COUNT(mplimplikia) AS aName, MIN(fdg), sd FROM r GROUP BY groupedColumn HAVING MIN(fdg)>3 AND aName ='ffgds' ");

//        NoSqlDbSystem noSqlDbSystem = NoSqlDbSystem.Neo4j().Builder("username","password","database").host("192.168.1.1").port(27027).build();

        String sqlStatement = "SELECT COUNT(*) FROM geoPoints " +
                "WHERE GEO_TEMPORAL_RECTANGLE(location, (23.7533, 37.9801), (23.7598, 37.9910), date, '1/3/2020 00:00:00', '1/3/2020 23:59:50') " +
                "GROUP BY vehicle_id";

//        NoSqlDbSqlStatement noSqlDbStmt = noSqlDbSystem.sql(sqlStatement);

    }


}
