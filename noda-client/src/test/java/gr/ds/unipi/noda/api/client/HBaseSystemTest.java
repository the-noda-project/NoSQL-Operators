package gr.ds.unipi.noda.api.client;

import net.sf.jsqlparser.JSQLParserException;
import net.sf.jsqlparser.parser.CCJSqlParserDefaultVisitor;
import net.sf.jsqlparser.parser.CCJSqlParserUtil;
import net.sf.jsqlparser.parser.SimpleNode;
import org.junit.Test;

import static gr.ds.unipi.noda.api.core.operators.FilterOperators.eq;

public class HBaseSystemTest {
    @Test
    public void hBaseTest() {

        NoSqlDbSystem noSqlDbSystem = NoSqlDbSystem.HBase().Builder().host("localhost").build();
        noSqlDbSystem.operateOn("test").filter(eq("cf:name","George")).printScreen();

        noSqlDbSystem.closeConnection();
    }



}
