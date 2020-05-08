package gr.ds.unipi.noda.api.client;

import net.sf.jsqlparser.JSQLParserException;
import org.junit.Test;

public class SqlTest {
    @Test
    public void sqlTest() throws JSQLParserException {

        //NoSqlDbSystem.MongoDB().Builder("asdf","asdf","sdaf").build().sql("SELECT COUNT(mplimplikia) AS aName, MIN(fdg), sd FROM r GROUP BY groupedColumn HAVING MIN(fdg)>3 AND aName ='ffgds' ");

        NoSqlDbSystem.MongoDB().Builder("asdf","asdf","sdaf").build().sql("SELECT MIN(fdg) as fgr, sd FROM r GROUP BY groupedColumn HAVING MIN(fdg)>3 AND aName ='ffgds' ");

//        NoSqlDbSystem.MongoDB().Builder("asdf","asdf","sdaf").build();
//        final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
//
//        System.out.println("ds");
//        try {
//            System.out.println(FilterOperators.inGeoTemporalCircleKm("col", Coordinates.newCoordinates(34,23), 3, "temporal", simpleDateFormat.parse("1/1/2010 00:00:00"), simpleDateFormat.parse("1/2/2010 00:00:00")));
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
    }


}
