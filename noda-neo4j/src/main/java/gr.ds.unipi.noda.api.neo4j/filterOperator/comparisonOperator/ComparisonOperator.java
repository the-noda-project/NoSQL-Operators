package gr.ds.unipi.noda.api.neo4j.filterOperator.comparisonOperator;

abstract class ComparisonOperator<U> extends gr.ds.unipi.noda.api.core.operators.filterOperators.comparisonOperators.ComparisonOperator<String, U> {

    protected ComparisonOperator(String fieldName, U fieldValue) {
        super(fieldName, fieldValue);
    }

    @Override
    public String getOperatorExpression() {

        return "s." + getFieldName() + getComparisonType() + getFieldValue()  ;

    }

    abstract String getComparisonType();
}
