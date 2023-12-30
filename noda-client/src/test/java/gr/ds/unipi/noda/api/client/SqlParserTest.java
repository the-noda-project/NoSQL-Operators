package gr.ds.unipi.noda.api.client;

import gr.ds.unipi.noda.api.client.sql.CaseChangingCharStream;
import gr.ds.unipi.noda.api.client.sql.NoSqlDbSqlStatementListener;
import gr.ds.unipi.noda.api.client.sql.SqlBaseLexer;
import gr.ds.unipi.noda.api.client.sql.SqlBaseParser;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.*;
import org.junit.Ignore;
import org.junit.Test;

import java.io.IOException;

public class SqlParserTest {
    @Ignore
    @Test
    public void parseStatement() throws IOException {
        //String sql = "SELECT columnFamily-columnQualifier, anotherColumns, fdf FROM students, sk.pk WHERE surname = 1.423 AND postalCode = 4 AND GEOTEMPORAL(3,4) >3 OR KLASS(43) != d";
        //String sql = "SELECT columnFamily-columnQualifier, anotherColumns, fdf FROM students, sk.pk WHERE surname = INTEGER(142.88766688993) AND name='dfkjnijn' OR sd=23 OR se=3";
        //String sql = "select * from x where fd='ref' AND re=23.3 AND( rrj !='W' OR hgu=>4) AND CIRCLE( pointCol.kf, (45.21, 56.3), 5) GROUP BY id, year LIMIT 55743";
        String sql = "select * FROM y where vehicleId IN (select * from x GROUP BY id) GROUP BY rt";


        long o = System.currentTimeMillis();
        CharStream s = CharStreams.fromString(sql);
        //CharStream s1 = CharStreams.fromString(sql);


        CaseChangingCharStream upper = new CaseChangingCharStream(s,true);
//        CaseChangingCharStream upper1 = new CaseChangingCharStream(s1,true);


        SqlBaseLexer mySqlLexer =  new SqlBaseLexer(upper);
        //SqlBaseLexer mySqlLexer1 =  new SqlBaseLexer(upper1);


        CommonTokenStream tokens = new CommonTokenStream(mySqlLexer);
        //CommonTokenStream tokens1 = new CommonTokenStream(mySqlLexer1);


        SqlBaseParser mySqlParser = new SqlBaseParser(tokens);
        //SqlBaseParser mySqlParser1 = new SqlBaseParser(tokens1);

        System.out.println(System.currentTimeMillis() - o);

        //mySqlParser.querySpecification().relation().size();

        ParseTree tree = mySqlParser.statement();

        //mySqlParser.selectElements().selectElement().forEach(g-> System.out.println(g.getText()));

        //mySqlParser.getParseListeners().forEach(c-> System.out.println(c.toString()));

        //        ParseTree tree = mySqlParser.tableSource();
//
//        System.out.println(tree.getText());

//        System.out.println(mySqlParser.fromClause().toStringTree());
//        System.out.println(mySqlParser.stringLiteral().toStringTree());
//        System.out.println(mySqlParser.showStatement().toStringTree());
//        System.out.println(mySqlParser.predicate().toStringTree());

//        System.out.println(tree.getChild(0).getText());
//
        ParseTreeWalker walker = new ParseTreeWalker();
        NoSqlDbSqlStatementListener listener = NoSqlDbSqlStatementListener.newNodaSqlListener();
        walker.walk(listener,tree);


    }


}
