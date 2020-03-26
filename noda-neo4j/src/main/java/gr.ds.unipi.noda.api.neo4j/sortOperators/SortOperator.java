package gr.ds.unipi.noda.api.neo4j.sortOperators;

abstract class SortOperator extends gr.ds.unipi.noda.api.core.operators.sortOperators.SortOperator<StringBuilder> {

    protected SortOperator(String fieldName) {
        super(fieldName);
    }

    @Override
    public StringBuilder getOperatorExpression() {

        return null;
    }
}
