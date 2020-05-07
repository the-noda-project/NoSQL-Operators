package gr.ds.unipi.noda.api.client;

import gr.ds.unipi.noda.api.core.operators.FilterOperators;
import gr.ds.unipi.noda.api.core.operators.filterOperators.geographicalOperators.Coordinates;
import net.sf.jsqlparser.JSQLParserException;
import net.sf.jsqlparser.parser.CCJSqlParserDefaultVisitor;
import net.sf.jsqlparser.parser.CCJSqlParserUtil;
import net.sf.jsqlparser.parser.SimpleNode;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class SqlTest {
    @Test
    public void sqlTest() throws JSQLParserException {

        NoSqlDbSystem.MongoDB().Builder("asdf","asdf","sdaf").build().sql("SELECT COUNT(mplimplikia) AS aName, MIN(fdg) AS anotherName, sd FROM r WHERE GEO_TEMPORAL_CIRCLE_KM(columnOfLocation, [(34.4,35)], 456, columnOfTemporal, '1/1/2010 00:00:00', '1/2/2010 00:00:00') GROUP BY groupedColumn HAVING COUNT(re) >3 ");
//
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
