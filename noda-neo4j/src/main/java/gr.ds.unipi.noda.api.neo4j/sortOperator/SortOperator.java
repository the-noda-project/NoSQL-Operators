package gr.ds.unipi.noda.api.neo4j.sortOperator;

abstract class SortOperator extends gr.ds.unipi.noda.api.core.operators.sortOperators.SortOperator<StringBuilder> {

    protected SortOperator(String fieldName, int order) {
        super(fieldName, order);
    }

    @Override
    public StringBuilder getOperatorExpression() {

        return null;
    }
}
