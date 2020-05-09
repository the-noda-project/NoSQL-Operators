package gr.ds.unipi.noda.api.client.sql;

import gr.ds.unipi.noda.api.core.nosqldb.NoSqlDbOperators;
import gr.ds.unipi.noda.api.core.operators.AggregateOperators;
import gr.ds.unipi.noda.api.core.operators.FilterOperators;
import gr.ds.unipi.noda.api.core.operators.aggregateOperators.AggregateOperator;
import gr.ds.unipi.noda.api.core.operators.filterOperators.FilterOperator;
import gr.ds.unipi.noda.api.core.operators.filterOperators.geographicalOperators.Coordinates;
import gr.ds.unipi.noda.api.core.operators.sortOperators.SortOperator;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import static gr.ds.unipi.noda.api.core.operators.FilterOperators.*;
import static gr.ds.unipi.noda.api.core.operators.SortOperators.asc;
import static gr.ds.unipi.noda.api.core.operators.SortOperators.desc;

public class NodaSqlListener extends SqlBaseBaseListener {

    private NoSqlDbOperators noSqlDbOperators;
    private String source;
    private List<FilterOperator> filterOperatorSecondStage = new ArrayList<>();
    private List<FilterOperator> filterOperatorsFirstStage = new ArrayList<>();
    private FilterOperator finalFilterOperator;
    private List<String> selectOperator = new ArrayList<>();
    private boolean selectAll = false;
    private List<String> groupBy = new ArrayList<>();
    private List<AggregateOperator> aggregateOperators = new ArrayList<>();
    private List<SortOperator> sortOperators = new ArrayList<>();

    private List<String> logicalOperator = new ArrayList<>();
    private List<String> column = new ArrayList<>();
    private boolean columnDereference;
    private String comparison;
    private boolean havingCondition;

    private final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    private int limit = -1;

    // The value of HashMap represents the number of arguments in a Row e.g.(58.45, 28.83)
    private Map<String, Integer> hashMap = new HashMap<String, Integer>(){{
        put("GEO_POLYGON",2);
        put("GEO_RECTANGLE",2);
        put("GEO_CIRCLE_KM",2);
        put("GEO_CIRCLE_ME",2);
        put("GEO_CIRCLE_MI",2);
        put("GEO_TEMPORAL_POLYGON",2);
        put("GEO_TEMPORAL_RECTANGLE",2);
        put("GEO_TEMPORAL_CIRCLE_KM",2);
        put("GEO_TEMPORAL_CIRCLE_ME",2);
        put("GEO_TEMPORAL_CIRCLE_MI",2);
    }};

    private Set<String> aggregateFunctions =  new LinkedHashSet<String>(){{
        add("COUNT");
        add("MIN");
        add("MAX");
        add("SUM");
        add("AVG");
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
    }

    public String getSource(){
        return source;
    }

    @Override public void enterSelectAll(SqlBaseParser.SelectAllContext ctx) {

        System.out.println("SELECT ALL");
        selectAll = true;
    }

    @Override public void exitSelectSingle(SqlBaseParser.SelectSingleContext ctx) {

        if(ctx.getChildCount()==1){
            if(!column.isEmpty()){//if it is not a function
                selectOperator.add(column.get(0));
                column.remove(0);
            }
            else{//if it is function - implying aggregationg since it is select
                selectOperator.add(aggregateOperators.get(aggregateOperators.size()-1).getAlias());
            }
        }
        else if(ctx.getChildCount()==3 && ctx.getChild(1).getText().equalsIgnoreCase("AS")){

            selectOperator.add(ctx.getChild(2).getText());

            AggregateOperator aop = aggregateOperators.get(aggregateOperators.size()-1).as(ctx.getChild(2).getText());
            aggregateOperators.remove(aggregateOperators.size()-1);
            aggregateOperators.add(aop);

        }
        else{
            try {
                throw new Exception("");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override public void exitGroupBy(SqlBaseParser.GroupByContext ctx) {
        groupBy.addAll(column);
        column.clear();
        System.out.println("EXITING GROUP BY");
        finalFilterOperator = formFinalFilter();
        havingCondition = true;
    }

    @Override public void enterQueryNoWith(SqlBaseParser.QueryNoWithContext ctx) {

        if(ctx.limit != null){
            this.limit = Integer.valueOf(ctx.limit.getText());
            System.out.println("LIMITee " + ctx.limit.getText());
        }
    }

    @Override public void enterLogicalBinary(SqlBaseParser.LogicalBinaryContext ctx) {

        if(filterOperatorsFirstStage.size() > 0){
            formFilterOperatorSecondStage();
        }

        logicalOperator.add(ctx.operator.getText());

        System.out.println("LOGICAL BINARY CONTEXT " + ctx.getText()+ " "+ ctx.operator.getText() + " "+ (ctx.getChildCount()-1));

    }

    private void formFilterOperatorSecondStage(){
        FilterOperator fop = filterOperatorsFirstStage.get(0);
        for (int i = 1; i < filterOperatorsFirstStage.size(); i++) {
            if(logicalOperator.get(logicalOperator.size()-1).equalsIgnoreCase("AND")){
                fop = and(fop, filterOperatorsFirstStage.get(i));
            }
            else if(logicalOperator.get(logicalOperator.size()-1).equalsIgnoreCase("OR")) {
                fop = or(fop, filterOperatorsFirstStage.get(i));
            }
            else{
                try {
                    throw new Exception("");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            logicalOperator.remove(logicalOperator.size()-1);
        }

        filterOperatorSecondStage.add(fop);
        filterOperatorsFirstStage.clear();
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
            createFilter(ctx.getText().substring(1,ctx.getText().length()-1));
        }
        else if(functionName != null){
            functionStrings.add(ctx.getText().substring(1,ctx.getText().length()-1));
        }
        System.out.println("STRING LITERAL CONTEXT " + ctx.getText().substring(1,ctx.getText().length()-1));
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

        if(havingCondition){
            return;
        }

        for(Map.Entry<String,Integer> entry: hashMap.entrySet()){
            if(ctx.getText().toUpperCase().startsWith(entry.getKey())){
                functionName = ctx.getText().substring(0,entry.getKey().length());
                break;
            }
        }

        if(functionName == null) {
            for (String aggregateFunction : aggregateFunctions) {
                if(ctx.getText().toUpperCase().startsWith(aggregateFunction)){
                    functionName = ctx.getText().substring(0,aggregateFunction.length());
                    break;
                }
            }
        }

        System.out.println("ctx.getText() "+ ctx.getText());
        System.out.println("function name: "+ functionName);

            if(functionName == null){
            try {
                throw new Exception("");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }


    @Override public void exitFunctionCall(SqlBaseParser.FunctionCallContext ctx) {

        if(havingCondition){
            column.set(0, ctx.getText());
            return;
        }

        try {
            switch (functionName.toUpperCase()) {
                case "GEO_POLYGON":
                    checkForSingleColumn();
                    checkForNoneValues();
                    if (coordinatesList.size() < 3) {
                        try {
                            throw new Exception("");
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }

                    if (coordinatesList.size() == 3) {
                        addFilter(FilterOperators.inGeoPolygon(column.get(0), coordinatesList.get(0), coordinatesList.get(1), coordinatesList.get(2)));
                    } else {
                        Coordinates[] coordinates = new Coordinates[coordinatesList.size() - 3];
                        for (int i = 3; i < coordinatesList.size(); i++) {
                            coordinates[i - 3] = coordinatesList.get(i);
                        }
                        addFilter(FilterOperators.inGeoPolygon(column.get(0), coordinatesList.get(0), coordinatesList.get(1), coordinatesList.get(2), coordinates));
                    }
                    break;
                case "GEO_RECTANGLE":
                    checkForSingleColumn();
                    checkForNoneValues();
                    if (coordinatesList.size() != 2) {
                        try {
                            throw new Exception("");
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }

                    addFilter(FilterOperators.inGeoRectangle(column.get(0), coordinatesList.get(0), coordinatesList.get(1)));

                    break;
                case "GEO_CIRCLE_KM":
                case "GEO_CIRCLE_ME":
                case "GEO_CIRCLE_MI":
                    checkForSingleColumn();
                    checkForNoneStrings();

                    if (coordinatesList.size() != 1) {
                        try {
                            throw new Exception("");
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }

                    if (functionName.equals("GEO_CIRCLE_KM")) {
                        addFilter(FilterOperators.inGeoCircleKm(column.get(0), coordinatesList.get(0), (double) functionNumbers.get(0)));
                    } else if (functionName.equals("GEO_CIRCLE_ME")) {
                        addFilter(FilterOperators.inGeoCircleMeters(column.get(0), coordinatesList.get(0), (double) functionNumbers.get(0)));
                    } else {
                        addFilter(FilterOperators.inGeoCircleMiles(column.get(0), coordinatesList.get(0), (double) functionNumbers.get(0)));
                    }

                    break;
                case "GEO_TEMPORAL_POLYGON":
                    checkForDoubleColumn();
                    checkForNoneNumbers();
                    if (coordinatesList.size() < 3) {
                        try {
                            throw new Exception("");
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }

                    if (coordinatesList.size() == 3) {
                        addFilter(FilterOperators.inGeoTemporalPolygon(column.get(0), column.get(1), simpleDateFormat.parse(functionStrings.get(0)), simpleDateFormat.parse(functionStrings.get(1)), coordinatesList.get(0), coordinatesList.get(1), coordinatesList.get(2)));
                    } else {
                        Coordinates[] coordinates = new Coordinates[coordinatesList.size() - 3];
                        for (int i = 3; i < coordinatesList.size(); i++) {
                            coordinates[i - 3] = coordinatesList.get(i);
                        }
                        addFilter(FilterOperators.inGeoTemporalPolygon(column.get(0), column.get(1), simpleDateFormat.parse(functionStrings.get(0)), simpleDateFormat.parse(functionStrings.get(1)), coordinatesList.get(0), coordinatesList.get(1), coordinatesList.get(2), coordinates));
                    }
                    break;
                case "GEO_TEMPORAL_RECTANGLE":
                    checkForDoubleColumn();
                    checkForNoneNumbers();
                    if (coordinatesList.size() != 2) {
                        try {
                            throw new Exception("");
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }

                    addFilter(FilterOperators.inGeoTemporalRectangle(column.get(0), coordinatesList.get(0), coordinatesList.get(1), column.get(1), simpleDateFormat.parse(functionStrings.get(0)), simpleDateFormat.parse(functionStrings.get(1))));

                    break;
                case "GEO_TEMPORAL_CIRCLE_KM":
                case "GEO_TEMPORAL_CIRCLE_ME":
                case "GEO_TEMPORAL_CIRCLE_MI":
                    checkForDoubleColumn();

                    if (coordinatesList.size() != 1) {
                        try {
                            throw new Exception("");
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }

                    if (functionName.equals("GEO_TEMPORAL_CIRCLE_KM")) {
                        addFilter(FilterOperators.inGeoTemporalCircleKm(column.get(0), coordinatesList.get(0), (double) functionNumbers.get(0), column.get(1), simpleDateFormat.parse(functionStrings.get(0)), simpleDateFormat.parse(functionStrings.get(1))));
                    } else if (functionName.equals("GEO_TEMPORAL_CIRCLE_ME")) {
                        addFilter(FilterOperators.inGeoTemporalCircleMeters(column.get(0), coordinatesList.get(0), (double) functionNumbers.get(0), column.get(1), simpleDateFormat.parse(functionStrings.get(0)), simpleDateFormat.parse(functionStrings.get(1))));
                    } else {
                        addFilter(FilterOperators.inGeoTemporalCircleMiles(column.get(0), coordinatesList.get(0), (double) functionNumbers.get(0), column.get(1), simpleDateFormat.parse(functionStrings.get(0)), simpleDateFormat.parse(functionStrings.get(1))));
                    }

                    break;
                case "MIN":
                    checkForSingleColumn();
                    addAggregate(AggregateOperators.min(column.get(0)).as(functionName+"("+column.get(0)+")"));
                    break;
                case "MAX":
                    checkForSingleColumn();
                    addAggregate(AggregateOperators.max(column.get(0)).as(functionName+"("+column.get(0)+")"));
                    break;
                case "SUM":
                    checkForSingleColumn();
                    addAggregate(AggregateOperators.sum(column.get(0)).as(functionName+"("+column.get(0)+")"));
                    break;
                case "AVG":
                    checkForSingleColumn();
                    addAggregate(AggregateOperators.avg(column.get(0)).as(functionName+"("+column.get(0)+")"));
                    break;
                case "COUNT":
                    checkForNoneValues();
                    if(ctx.getChild(2).getText().equals("*") && column.isEmpty()){
                        addAggregate(AggregateOperators.count().as(functionName+"(*)"));
                    }
                    else if(ctx.getChild(2).getText().equalsIgnoreCase("DISTINCT")){
                        checkForSingleColumn();
                        addAggregate(AggregateOperators.countDistinct(column.get(0)).as(functionName+"("+ctx.getChild(2).getText()+" "+column.get(0)+")"));
                    }
                    else if(ctx.getChild(2).getText().equalsIgnoreCase("ALL") || ctx.getChildCount()==4){
                        checkForSingleColumn();
                        String alias;
                        if(ctx.getChild(2).getText().equalsIgnoreCase("ALL")){
                            alias = functionName+"("+ctx.getChild(2).getText()+" "+column.get(0)+")";
                        }
                        else{
                            alias = functionName+"("+column.get(0)+")";
                        }
                        addAggregate(AggregateOperators.countNonNull(column.get(0)).as(alias));
                    }
                    else{
                        try {
                            throw new Exception();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
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
        catch (ParseException e){
            e.printStackTrace();
        }
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

    private void checkForNoneNumbers(){
        if(functionNumbers.size()!=0){
            try {
                throw new Exception("");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void checkForNoneValues(){
        checkForNoneStrings();
        checkForNoneNumbers();
    }

    @Override public void exitSortItem(SqlBaseParser.SortItemContext ctx) {

        if(ctx.getChildCount()==2 && ctx.getChild(1).getText().equalsIgnoreCase("DESC")){
            sortOperators.add(desc(column.get(0)));
        }
        else{
            sortOperators.add(asc(column.get(0)));
        }

        column.clear();
    }

    private void addFilter(FilterOperator fop){

        filterOperatorsFirstStage.add(fop);
        comparison = null;
        column.clear();

        functionName = null;
        coordinatesList.clear();
        functionNumbers.clear();
        functionStrings.clear();

    }

    private void addAggregate(AggregateOperator aop){

        aggregateOperators.add(aop);
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

    private FilterOperator formFinalFilter(){
        if(filterOperatorsFirstStage.size()>0){
            formFilterOperatorSecondStage();
            FilterOperator fop = filterOperatorSecondStage.get(filterOperatorSecondStage.size()-1);
            for (int i = filterOperatorSecondStage.size() - 2; i >= 0; i--) {
                if(logicalOperator.get(logicalOperator.size()-1).equalsIgnoreCase("AND")){
                    fop = and(filterOperatorSecondStage.get(i), fop);
                }
                else if(logicalOperator.get(logicalOperator.size()-1).equalsIgnoreCase("OR")) {
                    fop = or(filterOperatorSecondStage.get(i), fop);
                }
                else{
                    try {
                        throw new Exception("");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                logicalOperator.remove(logicalOperator.size()-1);

            }
            filterOperatorSecondStage.clear();
            return fop;
        }
        return null;
    }

    public NoSqlDbOperators getNoSqlDbOperators(){

        if(groupBy.size()==0){
            finalFilterOperator = formFinalFilter();
        }else{
            if(finalFilterOperator!=null){
                noSqlDbOperators.filter(finalFilterOperator);
                finalFilterOperator = null;
            }
        }

        if(groupBy.size() != 0){
            if(groupBy.size() ==1){
                noSqlDbOperators.groupBy(groupBy.get(0));
            }else{
                String[] group = new String[groupBy.size()-1];
                for(int i=1;i<groupBy.size();i++){
                    group[i-1] = groupBy.get(i);
                }
                noSqlDbOperators.groupBy(groupBy.get(0),group);
            }
            //forming having
            finalFilterOperator = formFinalFilter();
            if(finalFilterOperator!=null){
                System.out.println("HAVING OPERATOR IS" + finalFilterOperator.getOperatorExpression());
                noSqlDbOperators.filter(finalFilterOperator);
                finalFilterOperator = null;
            }
        }

        if(sortOperators.size() != 0){
            if(sortOperators.size() ==1){
                noSqlDbOperators.sort(sortOperators.get(0));
                System.out.println("SORT "+ sortOperators.get(0).getOperatorExpression());
            }else{
                SortOperator[] sop = new SortOperator[sortOperators.size()-1];
                System.out.println("SORT "+ sortOperators.get(0).getOperatorExpression());

                for(int i=1;i<sortOperators.size();i++){
                    sop[i-1] = sortOperators.get(i);
                    System.out.println("SORT "+ sortOperators.get(i).getOperatorExpression());

                }
                noSqlDbOperators.sort(sortOperators.get(0),sop);
            }
        }

        if(selectOperator.size()!=0 && !selectAll){
            if(selectOperator.size() ==1){
                System.out.println("FDF1 " + selectOperator.get(0));
                noSqlDbOperators.project(selectOperator.get(0));
            }else{
                System.out.println("FDF1 " + selectOperator.get(0));

                String[] select = new String[selectOperator.size()-1];
                for(int i=1;i<selectOperator.size();i++){
                    select[i-1] = selectOperator.get(i);
                    System.out.println("FDF2 " +selectOperator.get(i));

                }
                noSqlDbOperators.project(selectOperator.get(0),select);
            }
        }

        if(limit != -1){
            noSqlDbOperators.limit(limit);
            System.out.println("LIMIT "+limit);
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
