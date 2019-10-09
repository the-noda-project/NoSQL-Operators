package gr.unipi.noda.api.mongo.sortOperator;


abstract class SortOperator extends gr.unipi.noda.api.core.operators.sortOperators.SortOperator<StringBuilder> {

    protected SortOperator(String fieldName, int order) {
        super(fieldName, order);
    }

    @Override
    public StringBuilder getOperatorExpression() {
        StringBuilder sb = new StringBuilder();
        sb.append(getFieldName() + " : " + getOrder());
        return sb;
    }
}
