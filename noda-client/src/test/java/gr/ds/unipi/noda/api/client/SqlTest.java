package gr.ds.unipi.noda.api.client;

import net.sf.jsqlparser.JSQLParserException;
import net.sf.jsqlparser.expression.Expression;
import net.sf.jsqlparser.expression.LongValue;
import net.sf.jsqlparser.expression.operators.arithmetic.Addition;
import net.sf.jsqlparser.expression.operators.arithmetic.Multiplication;
import net.sf.jsqlparser.expression.operators.relational.ComparisonOperator;
import net.sf.jsqlparser.parser.*;
import net.sf.jsqlparser.statement.Statement;
import net.sf.jsqlparser.statement.Statements;
import net.sf.jsqlparser.statement.select.*;
import net.sf.jsqlparser.util.TablesNamesFinder;
import net.sf.jsqlparser.util.deparser.ExpressionDeParser;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

import static gr.ds.unipi.noda.api.core.operators.FilterOperators.eq;

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

                if(node.jjtGetValue() != null){
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

                if(node.toString().equals("RegularCondition")){

                }

                
                System.out.println( node.jjtGetValue()+" " +node.toString() + " firstToken=" + node.jjtGetFirstToken().image
                        + " line=" + node.jjtGetFirstToken().beginLine);
                return super.visit(node, data);
            }
        }, null);

    }


}
