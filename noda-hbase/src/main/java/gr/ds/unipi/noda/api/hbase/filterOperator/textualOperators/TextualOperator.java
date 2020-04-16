package gr.ds.unipi.noda.api.hbase.filterOperator.textualOperators;

abstract class TextualOperator extends gr.ds.unipi.noda.api.core.operators.filterOperators.textualOperators.TextualOperator<Object> {
    protected TextualOperator(String fieldName, String[] elements) {
        super(fieldName, elements);
    }

    public Object getOperatorExpression() {
        return null;
    }
}
