package gr.ds.unipi.noda.api.couchdb.filterOperators.comparisonOperators;

import org.apache.commons.lang.StringEscapeUtils;

abstract class ComparisonOperator<U> extends gr.ds.unipi.noda.api.core.operators.filterOperators.comparisonOperators.ComparisonOperator<String, U> {
    protected ComparisonOperator(String fieldName, U fieldValue) {
        super(fieldName, fieldValue);
    }

    abstract protected String operatorSymbol();

    @Override
    public String getOperatorExpression() {
        String escapedFieldName = '"' + StringEscapeUtils.escapeJavaScript(getFieldName()) + '"';
        return "doc[" + escapedFieldName + "]" + operatorSymbol() + escapedFieldName;
    }
}
