package gr.ds.unipi.noda.api.yyydatabase.sortOperators;

abstract class SortOperator extends gr.ds.unipi.noda.api.core.operators.sortOperators.SortOperator<Object> {
    protected SortOperator(String fieldName) {
        super(fieldName);
    }

    @Override
    public Object getOperatorExpression() {
        return null;
    }
}
