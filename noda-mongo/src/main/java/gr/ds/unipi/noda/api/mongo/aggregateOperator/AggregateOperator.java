package gr.ds.unipi.noda.api.mongo.aggregateOperator;

abstract class AggregateOperator extends gr.ds.unipi.noda.api.core.operators.aggregateOperators.AggregateOperator<StringBuilder> {

    protected AggregateOperator(String fieldName, String alias) {
        super(fieldName, alias);
    }

    protected abstract String getOperatorJsonField();

    @Override
    public StringBuilder getOperatorExpression() {
        StringBuilder sb = new StringBuilder();
        sb.append(getAlias());

        sb.append(": { $");
        sb.append(getOperatorJsonField());
        sb.append(": ");

        sb.append("\"$");
        sb.append(getFieldName());
        sb.append("\"");
        sb.append(" }");

        return sb;
    }

}
