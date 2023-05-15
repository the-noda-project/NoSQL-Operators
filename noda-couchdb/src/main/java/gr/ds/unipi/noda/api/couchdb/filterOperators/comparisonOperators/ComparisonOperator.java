package gr.ds.unipi.noda.api.couchdb.filterOperators.comparisonOperators;

import org.apache.commons.lang3.StringEscapeUtils;

import java.util.Date;

abstract class ComparisonOperator<U> extends gr.ds.unipi.noda.api.core.operators.filterOperators.comparisonOperators.ComparisonOperator<String, U> {
    protected ComparisonOperator(String fieldName, U fieldValue) {
        super(fieldName, fieldValue);
    }

    abstract protected String operatorSymbol();

    @Override
    public String getOperatorExpression() {
        final String fieldName = "doc[\"" + StringEscapeUtils.escapeEcmaScript(getFieldName()) + "\"]";
        final Object fieldValue = getFieldValue();

        String left, right;
        // Convert dates to epoch time format
        if (fieldValue instanceof Date) {
            left = "Date.parse(" + fieldName + ")";
            right = Long.toString(((Date) fieldValue).toInstant().getEpochSecond());
        } else if (fieldValue instanceof String) {
            left = fieldName;
            right = '"' + String.valueOf(fieldValue) + '"';
        } else {
            left = fieldName;
            right = String.valueOf(fieldValue);
        }

        return left + operatorSymbol() + right;
    }
}
