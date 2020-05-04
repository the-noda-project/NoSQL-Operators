package gr.ds.unipi.noda.api.client;

import net.sf.jsqlparser.JSQLParserException;
import net.sf.jsqlparser.parser.CCJSqlParserDefaultVisitor;
import net.sf.jsqlparser.parser.CCJSqlParserUtil;
import net.sf.jsqlparser.parser.SimpleNode;
import org.junit.Test;

public class SqlTest {
    @Test
    public void sqlTest() throws JSQLParserException {

        NoSqlDbSystem.MongoDB().Builder("asdf","asdf","sdaf").build().sql("SELECT MIN(gdf) AS aName, MIN(fdg) AS anotherName, sd FROM r WHERE GEO_TEMPORAL_CIRCLE_KM(columnOfLocation, [(34.4,35)], 456, columnOfTemporal, '1/1/2010 00:00:00', '1/2/2010 00:00:00' )");

    }


}
