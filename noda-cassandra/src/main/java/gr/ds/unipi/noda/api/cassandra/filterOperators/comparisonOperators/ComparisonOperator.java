package gr.ds.unipi.noda.api.cassandra.filterOperators.comparisonOperators;

import java.util.Dictionary;
import java.util.Hashtable;

abstract class ComparisonOperator<U> extends gr.ds.unipi.noda.api.core.operators.filterOperators.comparisonOperators.ComparisonOperator<StringBuilder, U> {

    protected static Dictionary<String, String> monthInt;

    protected ComparisonOperator(String fieldName, U fieldValue) {
        super(fieldName, fieldValue);
        monthInt = new Hashtable<String, String>();
        monthInt.put("Jan", "01");
        monthInt.put("Feb", "02");
        monthInt.put("Mar", "03");
        monthInt.put("Apr", "04");
        monthInt.put("May", "05");
        monthInt.put("Jun", "06");
        monthInt.put("Jul", "07");
        monthInt.put("Aug", "08");
        monthInt.put("Sep", "09");
        monthInt.put("Oct", "10");
        monthInt.put("Nov", "11");
        monthInt.put("Dec", "12");
    }

    @Override
    public StringBuilder getOperatorExpression() {
        return null;
    }
}
