package gr.ds.unipi.noda.api.client.sql;

import org.antlr.v4.runtime.tree.ParseTree;

import java.util.ArrayList;
import java.util.List;

public class NodaSqlListener extends SqlBaseBaseListener {

    private List<String> logicalOperator = new ArrayList<>();
    private List<String> column = new ArrayList<>();
    private boolean columnDereference;
    private String comparison;
    private int limit;

//    private Coordinates coordinates;
//    private List<Coordinates> coordinatesList;



    @Override public void enterSingleStatement(SqlBaseParser.SingleStatementContext ctx) {

        SqlBaseParser.LogicalBinaryContext v;

        recursiveFunction(ctx,"");

    }

    @Override public void enterQueryNoWith(SqlBaseParser.QueryNoWithContext ctx) {

        if(ctx.limit != null){
            this.limit = Integer.valueOf(ctx.limit.getText());
            System.out.println("LIMITee " + ctx.limit.getText());
        }
    }

    @Override public void enterLogicalBinary(SqlBaseParser.LogicalBinaryContext ctx) {

        logicalOperator.add(ctx.operator.getText());

        System.out.println("LOGICAL BINARY CONTEXT " + ctx.getText()+ " "+ ctx.operator.getText() + " "+ ctx.operator.getType());

    }

    @Override public void enterDereference(SqlBaseParser.DereferenceContext ctx) {
        columnDereference = true;
        column.add(ctx.getText());
        System.out.println(" DEREFERENCE CONTEXT " + ctx.getText());

    }

    @Override public void enterColumnReference(SqlBaseParser.ColumnReferenceContext ctx) {
        if(!columnDereference){
            column.add(ctx.getText());
        }
        columnDereference = false;
        System.out.println("COLUMN REFERENCE CONTEXT " + ctx.getText());
    }

    @Override public void enterComparisonOperator(SqlBaseParser.ComparisonOperatorContext ctx) {

        comparison = ctx.getText();


        System.out.println("COMPARISON OPERATOR " + ctx.getText() +" "+ ctx.start.getType());
    }

    @Override public void enterDecimalLiteral(SqlBaseParser.DecimalLiteralContext ctx) {

        if(comparison != null){
            createFilter(Double.parseDouble(ctx.getText()));
        }


        System.out.println("DECIMAL LITERAL CONTEXT " + ctx.getText());

    }

    @Override public void enterIntegerLiteral(SqlBaseParser.IntegerLiteralContext ctx) {
        if(comparison != null){
            createFilter(Integer.parseInt(ctx.getText()));
        }

        System.out.println("INTGER LITERAL CONTEXT " + ctx.getText());
    }

    @Override public void enterStringLiteral(SqlBaseParser.StringLiteralContext ctx) {
        if(comparison != null){
            createFilter(ctx.getText());
        }
        System.out.println("STRING LITERAL CONTEXT " + ctx.getText());
    }

    public void createFilter(Object o){
        if(o instanceof Double){

        }else if(o instanceof Integer){

        }else if(o instanceof String){

        }
        else{
            try {
                throw new Exception("");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        comparison = null;
        column.clear();
    }

    @Override public void enterFunctionCall(SqlBaseParser.FunctionCallContext ctx) {

        if(ctx.getText().startsWith("IN_GEO_POLYGON")){
        }
        else if(ctx.getText().startsWith("")){

        }else{
            try {
                throw new Exception("");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        System.out.println("FUNCTION CALL CONTEXT " + ctx.getText());
    }

    @Override public void exitFunctionCall(SqlBaseParser.FunctionCallContext ctx) {

        System.out.println(" EXITING FUNCTION CALL CONTEXT " + ctx.getText());
    }



    @Override public void enterRowConstructor(SqlBaseParser.RowConstructorContext ctx) {

        if(ctx.children.size() == 5) {
            System.out.println("ROW " + ctx.getChild(0).getText());
            System.out.println("ROW " + ctx.getChild(1).getText());
            System.out.println("ROW " + ctx.getChild(2).getText());
            System.out.println("ROW " + ctx.getChild(3).getText());
            System.out.println("ROW " + ctx.getChild(4).getText());

        }
        else{
            try {
                throw new Exception("");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

//    @Override public void enterPredicated(SqlBaseParser.PredicatedContext ctx) {
//
//        System.out.println("PREDICATED 1 "+ctx.getChild(0).getText());
//        System.out.println("PREDICATED 2 "+ctx.getChild(1));
//        System.out.println("PREDICATED 3 "+ctx.getChild(2));
//
//    }



//    @Override public void enterUnquotedIdentifier(SqlBaseParser.UnquotedIdentifierContext ctx) {
//
//        System.out.println(" UnquotedIdentifierContext CONTEXT " + ctx.getText());
//
//    }




//    @Override public void enterValueExpressionDefault(SqlBaseParser.ValueExpressionDefaultContext ctx)  {
//
//        System.out.println("VALUE EXPRESSION DEFAULT " + ctx.getText());
//    }

//    @Override public void enterParse(SQLiteParser.ParseContext ctx) {
//
//        recursiveFunction(ctx,"");
//    }


//    @Override public void enterSelectElements(MySqlParser.SelectElementsContext ctx) {
//        ctx.children.forEach(i-> System.out.println(i.getText()));
//
//    }
//
//    @Override public void enterFromClause(MySqlParser.FromClauseContext ctx) {
//
////        if (!ctx.whereExpr.isEmpty()){
////            ctx.whereExpr.children.forEach(i-> System.out.println(i.getText()));
////        }
//
//        recursiveFunction(ctx.whereExpr,"");
//
//        System.out.println("----");
//
//        for(int i=0;i<ctx.whereExpr.getChildCount();i++){
//            System.out.println(ctx.whereExpr.getClass() +" "+ ctx.whereExpr.getText() + " " + ctx.whereExpr.getChildCount());
//        }
////
////        System.out.println(ctx.whereExpr.getText());
////        System.out.println(ctx.whereExpr.getClass());
////        System.out.println("---");
////
////        System.out.println(ctx.whereExpr.getChild(0).getText());
////        System.out.println(ctx.whereExpr.getChild(0).getClass());
////        System.out.println("---");
////
////        System.out.println(ctx.whereExpr.getChild(0).getChild(0).getText());
////        System.out.println(ctx.whereExpr.getChild(0).getChild(0).getClass());
////        System.out.println("---");
////
////        System.out.println(ctx.whereExpr.getChild(0).getChild(0).getChild(0).getText());
////        System.out.println(ctx.whereExpr.getChild(0).getChild(0).getChild(0).getClass());
////
////        System.out.println("---");
////        System.out.println(ctx.whereExpr.getChild(0).getChild(0).getChild(0).getChild(0).getText());
////        System.out.println(ctx.whereExpr.getChild(0).getChild(0).getChild(0).getChild(0).getClass());
////
////        System.out.println("---");
////        System.out.println(ctx.whereExpr.getChild(0).getChild(0).getChild(0).getChild(0).getChild(0).getText());
////        System.out.println(ctx.whereExpr.getChild(0).getChild(0).getChild(0).getChild(0).getChild(0).getClass());
////
////        System.out.println("---");
////        System.out.println(ctx.whereExpr.getChild(0).getChild(0).getChild(0).getChild(0).getChild(1).getText());
////        System.out.println(ctx.whereExpr.getChild(0).getChild(0).getChild(0).getChild(0).getChild(1).getClass());
////
////        System.out.println("---");
////        System.out.println(ctx.whereExpr.getChild(0).getChild(0).getChild(0).getChild(0).getChild(2).getText());
////        System.out.println(ctx.whereExpr.getChild(0).getChild(0).getChild(0).getChild(0).getChild(2).getClass());
////
////        System.out.println("---");
////        System.out.println(ctx.whereExpr.getChild(0).getChild(0).getChild(0).getChild(0).getChild(2).getChild(0).getText());
////        System.out.println(ctx.whereExpr.getChild(0).getChild(0).getChild(0).getChild(0).getChild(2).getChild(0).getClass());
////
////        System.out.println("---");
////        System.out.println(ctx.whereExpr.getChild(0).getChild(0).getChild(0).getChild(0).getChild(2).getChild(0).getChild(0).getText());
////        System.out.println(ctx.whereExpr.getChild(0).getChild(0).getChild(0).getChild(0).getChild(2).getChild(0).getChild(0).getClass());
////
////        System.out.println("---");
////        System.out.println(ctx.whereExpr.getChild(0).getChild(0).getChild(0).getChild(0).getChild(2).getChild(0).getChild(0).getChild(0).getText());
////        System.out.println(ctx.whereExpr.getChild(0).getChild(0).getChild(0).getChild(0).getChild(2).getChild(0).getChild(0).getChild(0).getClass());
////
////        System.out.println("---");
////        System.out.println(ctx.whereExpr.getChild(0).getChild(0).getChild(0).getChild(0).getChild(2).getChild(0).getChild(0).getChild(0).getChild(0).getText());
////        System.out.println(ctx.whereExpr.getChild(0).getChild(0).getChild(0).getChild(0).getChild(2).getChild(0).getChild(0).getChild(0).getChild(0).getClass());
//
//
//    }
//
    public void recursiveFunction(ParseTree parseTree, String level){


//        if(parseTree instanceof SQLiteParser.Column_nameContext){
//            System.out.println( parseTree.getText());
//        }
        for(int i=0;i<parseTree.getChildCount();i++){
            System.out.println(level+parseTree.getClass() +" "+ parseTree.getText() + " [" + parseTree.getChild(i).getChildCount()+"]" +" "+parseTree.toString());
            recursiveFunction(parseTree.getChild(i),level+"|");
        }

    }
//
//
//    @Override public void enterRoot(MySqlParser.RootContext ctx) {
//        System.out.println("Root "+ctx.toStringTree());
//    }
//

}
