package gr.ds.unipi.noda.api.client;

import net.sf.jsqlparser.JSQLParserException;
import net.sf.jsqlparser.parser.CCJSqlParserDefaultVisitor;
import net.sf.jsqlparser.parser.CCJSqlParserUtil;
import net.sf.jsqlparser.parser.SimpleNode;
import org.junit.Test;

public class SqlTest {
    @Test
    public void sqlTest() throws JSQLParserException {

        NoSqlDbSystem.MongoDB().Builder("asdf","asdf","sdaf").build().sql("SELECT ro FROM r WHERE ty=4");

    }


}
