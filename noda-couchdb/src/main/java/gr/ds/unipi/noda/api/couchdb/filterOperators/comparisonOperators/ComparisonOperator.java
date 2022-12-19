package gr.ds.unipi.noda.api.couchdb.filterOperators.comparisonOperators;

import com.google.gson.Gson;

abstract class ComparisonOperator<U> extends gr.ds.unipi.noda.api.core.operators.filterOperators.comparisonOperators.ComparisonOperator<String, U> {
    protected ComparisonOperator(String fieldName, U fieldValue) {
        super(fieldName, fieldValue);
    }

    abstract protected String operatorSymbol();

    @Override
    public String getOperatorExpression() {
        String fieldValue = new Gson().toJson(getFieldValue());
        return "doc[\"" + getFieldName() + "\"]" + operatorSymbol() + fieldValue;
    }
}
