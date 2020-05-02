package gr.ds.unipi.noda.api.client.sql;

import gr.ds.unipi.noda.api.core.nosqldb.NoSqlDbOperators;
import gr.ds.unipi.noda.api.core.operators.FilterOperators;
import gr.ds.unipi.noda.api.core.operators.filterOperators.FilterOperator;
import gr.ds.unipi.noda.api.core.operators.filterOperators.geographicalOperators.Coordinates;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static gr.ds.unipi.noda.api.core.operators.FilterOperators.*;

public class NodaSqlListener extends SqlBaseBaseListener {

    private NoSqlDbOperators noSqlDbOperators;
    private String source;
    private FilterOperator filterOperator;
    private List<String> selectOperator = new ArrayList<>();
    private boolean selectAll = false;
    private List<String> groupBy = new ArrayList<>();

    private List<String> logicalOperator = new ArrayList<>();
    private List<String> column = new ArrayList<>();
    private boolean columnDereference;
    private String comparison;

    private int limit = -1;

    // The value of HashMap represents the number of arguments in a Row e.g.(58.45, 28.83)
    private Map<String, Integer> hashMap = new HashMap<String, Integer>(){{
        put("POLYGON",2);
        put("RECTANGLE",2);
        put("CIRCLE",2);
    }};

    private String functionName;
    private List<Coordinates> coordinatesList = new ArrayList<>();
    private List<Number> functionNumbers = new ArrayList<>();
    private List<String> functionStrings = new ArrayList<>();


    private NodaSqlListener(){}

    @Override public void enterQuerySpecification(SqlBaseParser.QuerySpecificationContext ctx) {

        if(ctx.relation().size() != 1){
            try {
                throw new Exception("");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        source = ctx.relation().get(0).getText();

        //System.out.println("QUERY SPECIFICATION " + ctx.relation().size());

    }

    public String getSource(){
        return source;
    }

    @Override public void enterSelectAll(SqlBaseParser.SelectAllContext ctx) {
        selectAll = true;
    }

    @Override public void exitSelectSingle(SqlBaseParser.SelectSingleContext ctx) {
        selectOperator.add(column.get(0));
        column.remove(0);
        System.out.println("SELECTS exit" + ctx.getText());
    }

    @Override public void exitGroupBy(SqlBaseParser.GroupByContext ctx) {
        groupBy.addAll(column);
        column.clear();
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
        else if(functionName != null){
            functionNumbers.add(Double.parseDouble(ctx.getText()));
        }
        System.out.println("DECIMAL LITERAL CONTEXT " + ctx.getText());
    }

    @Override public void enterIntegerLiteral(SqlBaseParser.IntegerLiteralContext ctx) {
        if(comparison != null){
            createFilter(Integer.parseInt(ctx.getText()));
        }
        else if(functionName != null){
            functionNumbers.add(Integer.parseInt(ctx.getText()));
        }
        System.out.println("INTGER LITERAL CONTEXT " + ctx.getText());
    }

    @Override public void enterStringLiteral(SqlBaseParser.StringLiteralContext ctx) {
        if(comparison != null){
            createFilter(ctx.getText());
        }
        else if(functionName != null){
            functionStrings.add(ctx.getText());
        }
        System.out.println("STRING LITERAL CONTEXT " + ctx.getText());
    }

    public void createFilter(Object o){
        if(o instanceof Integer){
            switch (comparison){
                case ">": addFilter(gt(column.get(0), (int) o));
                    break;
                case ">=": addFilter(gte(column.get(0), (int) o));
                    break;
                case "<": addFilter(lt(column.get(0), (int) o));
                    break;
                case "<=": addFilter(lte(column.get(0), (int) o));
                    break;
                case "!=": addFilter(ne(column.get(0), (int) o));
                    break;
                case "=": addFilter(eq(column.get(0), (int) o));
                    break;
                default:
                    try {
                        throw new Exception("");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
            }


        }else if(o instanceof Double){
            switch (comparison){
                case ">": addFilter(gt(column.get(0), (double) o));
                    break;
                case ">=": addFilter(gte(column.get(0), (double) o));
                    break;
                case "<": addFilter(lt(column.get(0), (double) o));
                    break;
                case "<=": addFilter(lte(column.get(0), (double) o));
                    break;
                case "!=": addFilter(ne(column.get(0), (double) o));
                    break;
                case "=": addFilter(eq(column.get(0), (double) o));
                    break;
                default:
                    try {
                        throw new Exception("");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
            }
        }
        else if(o instanceof String){
            switch (comparison){
                case "!=": addFilter(ne(column.get(0), (String) o));
                    break;
                case "=": addFilter(eq(column.get(0), (String) o));
                    break;
                default:
                    try {
                        throw new Exception("");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
            }
        }
        else{
            try {
                throw new Exception("");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override public void enterFunctionCall(SqlBaseParser.FunctionCallContext ctx) {

        hashMap.forEach((key,value)->{
            if(ctx.getText().startsWith(key)){
                functionName = key;
                return;
            }
        });

        if(functionName == null){
            try {
                throw new Exception("");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    @Override public void exitFunctionCall(SqlBaseParser.FunctionCallContext ctx) {

        FilterOperator fop;

        if(functionName.equals("POLYGON")){
            checkForSingleColumn();
            if(coordinatesList.size()<3){
                try {
                    throw new Exception("");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            if(coordinatesList.size()==3){
                addFilter(FilterOperators.inGeoPolygon(column.get(0),coordinatesList.get(0),coordinatesList.get(1),coordinatesList.get(2)));
            }
            else{
                Coordinates[] coordinates = new Coordinates[coordinatesList.size()-3];
                for(int i=3;i<coordinatesList.size();i++){
                    coordinates[i-3] = coordinatesList.get(i);
                }
                addFilter(FilterOperators.inGeoPolygon(column.get(0),coordinatesList.get(0),coordinatesList.get(1),coordinatesList.get(2), coordinates));
            }
        }

        else if(functionName.equals("RECTANGLE")){
            checkForSingleColumn();
            if(coordinatesList.size()!=2){
                try {
                    throw new Exception("");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            addFilter(FilterOperators.inGeoRectangle(column.get(0),coordinatesList.get(0),coordinatesList.get(1)));

        }
        else if(functionName.equals("CIRCLE")){
            checkForSingleColumn();
            if(coordinatesList.size()!=1){
                try {
                    throw new Exception("");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            addFilter(FilterOperators.inGeoCircleMeters(column.get(0),coordinatesList.get(0),(double) functionNumbers.get(0)));

        }

        else{
            try {
                throw new Exception("");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        System.out.println("FUNCTION CALL CONTEXT " + ctx.getText());

    }

    private void checkForSingleColumn(){
        if(column.size()!=1){
            try {
                throw new Exception("");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void checkForDoubleColumn(){
        if(column.size()!=2){
            try {
                throw new Exception("");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void checkForSingleNumber(){
        if(functionNumbers.size()!=1){
            try {
                throw new Exception("");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void checkForNoneStrings(){
        if(functionStrings.size()!=0){
            try {
                throw new Exception("");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void addFilter(FilterOperator fop){

        if(logicalOperator.size()>0){
            String logical = logicalOperator.get(logicalOperator.size()-1);
            switch (logical){
                case "AND": filterOperator = and(filterOperator,fop);
                    break;
                case "OR": filterOperator = or(filterOperator,fop);
                    break;
                default:
                    try {
                        throw new Exception("");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
            }

            logicalOperator.remove(logicalOperator.size()-1);
        } else {
            if(filterOperator == null){
                filterOperator = fop;
            }
        }

        comparison = null;
        column.clear();

        functionName = null;
        coordinatesList.clear();
        functionNumbers.clear();
        functionStrings.clear();

    }

    @Override public void enterRowConstructor(SqlBaseParser.RowConstructorContext ctx) {

        if(hashMap.get(functionName) == 2){

            if(ctx.children.size() == 5 && ctx.getChild(0).getText().equals("(") &&
                    ctx.getChild(4).getText().equals(")") && ctx.getChild(2).getText().equals(",")) {

                coordinatesList.add(Coordinates.newCoordinates(Double.parseDouble(ctx.getChild(1).getText()), Double.parseDouble(ctx.getChild(3).getText())));
            }
            else{
                try {
                    throw new Exception("");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

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

//    @Override public void enterValueExpressionDefault(SqlBaseParser.ValueExpressionDefaultContext ctx)  {
//
//        System.out.println("VALUE EXPRESSION DEFAULT " + ctx.getText());
//    }
//
//    public void recursiveFunction(ParseTree parseTree, String level){
//
//
////        if(parseTree instanceof SQLiteParser.Column_nameContext){
////            System.out.println( parseTree.getText());
////        }
//        for(int i=0;i<parseTree.getChildCount();i++){
//            System.out.println(level+parseTree.getClass() +" "+ parseTree.getText() + " [" + parseTree.getChild(i).getChildCount()+"]" +" "+parseTree.toString());
//            recursiveFunction(parseTree.getChild(i),level+"|");
//        }
//
//    }

    public NoSqlDbOperators getNoSqlDbOperators(){
        if(filterOperator!=null){
            noSqlDbOperators.filter(filterOperator);
        }

        if(selectOperator.size()!=0 && !selectAll){
            if(selectOperator.size() ==1){
                noSqlDbOperators.project(selectOperator.get(0));
            }else{

                 String[] select = new String[selectOperator.size()-1];
                 for(int i=1;i<selectOperator.size();i++){
                     select[i-1] = selectOperator.get(i);
                 }

                noSqlDbOperators.project(selectOperator.get(0),select);
            }
        }

//        if(groupBy.size() != 0){
//            noSqlDbOperators.groupBy()
//        }

        if(limit != -1){
            noSqlDbOperators.limit(limit);
        }
        return noSqlDbOperators;
    }

    public void setNoSqlDbOperators(NoSqlDbOperators noSqlDbOperators) {
        this.noSqlDbOperators = noSqlDbOperators;
    }

    public static NodaSqlListener newNodaSqlListener(){
        return new NodaSqlListener();
    }
}
