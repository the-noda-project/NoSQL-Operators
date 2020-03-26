package gr.ds.unipi.noda.api.neo4j.filterOperators.comparisonOperators;

abstract class ComparisonOperator<U> extends gr.ds.unipi.noda.api.core.operators.filterOperators.comparisonOperators.ComparisonOperator<String, U> {

    protected ComparisonOperator(String fieldName, U fieldValue) {
        super(fieldName, fieldValue);
    }

    @Override
    public String getOperatorExpression() {

        return  getFieldName() + getComparisonType() + getFieldValue()  ;

    }

    abstract String getComparisonType();
}
