package gr.ds.unipi.noda.api.client;

import net.sf.jsqlparser.JSQLParserException;
import net.sf.jsqlparser.parser.CCJSqlParserDefaultVisitor;
import net.sf.jsqlparser.parser.CCJSqlParserUtil;
import net.sf.jsqlparser.parser.SimpleNode;
import org.junit.Test;

public class SqlTest {
    @Test
    public void sqlTest() throws JSQLParserException {


//        Statement statement = CCJSqlParserUtil.parse("SELECT * FROM tab1");
//        Select selectStatement = (Select) statement;
//
//        TablesNamesFinder tablesNamesFinder = new TablesNamesFinder();
//        List<String> tableList = tablesNamesFinder.getTableList(selectStatement);
//        tableList.forEach(System.out::println);


        SimpleNode node = (SimpleNode) CCJSqlParserUtil.parseAST("SELECT col1 FROM tab1 WHERE (col1>3 OR col23<5)");

        node.jjtAccept(new CCJSqlParserDefaultVisitor() {
            @Override
            public Object visit(SimpleNode node, Object data) {
                //if (node.getId() == CCJSqlParserTreeConstants.JJTTABLE || node.getId() == CCJSqlParserTreeConstants.JJTSELECTITEM || node.getId() == CCJSqlParserTreeConstants.JJTREGULARCONDITION) {

                if (node.jjtGetValue() != null) {
                    //ComparisonOperator comparisonOperator = (ComparisonOperator) node.jjtGetValue();
                    System.out.println(node.jjtGetValue() + " " + node.toString() + " " + node.jjtGetValue().getClass());
                }

                return super.visit(node, data);
                //} else {
                //return super.visit(node, data);
                //}
            }
        }, null);

        System.out.println("------");
        node.jjtAccept(new CCJSqlParserDefaultVisitor() {
            @Override
            public Object visit(SimpleNode node, Object data) {

                if (node.toString().equals("RegularCondition")) {

                }


                System.out.println(node.jjtGetValue() + " " + node.toString() + " firstToken=" + node.jjtGetFirstToken().image
                        + " line=" + node.jjtGetFirstToken().beginLine);
                return super.visit(node, data);
            }
        }, null);

    }


}
