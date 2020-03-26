package gr.ds.unipi.noda.api.mongo.sortOperators;


abstract class SortOperator extends gr.ds.unipi.noda.api.core.operators.sortOperators.SortOperator<StringBuilder> {

    protected SortOperator(String fieldName) {
        super(fieldName);
    }

    protected abstract String getSortConditionNum();

    @Override
    public StringBuilder getOperatorExpression() {
        StringBuilder sb = new StringBuilder();
        sb.append(getFieldName() + " : " + getSortConditionNum());
        return sb;
    }
}
