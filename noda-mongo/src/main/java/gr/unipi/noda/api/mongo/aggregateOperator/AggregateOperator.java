package gr.unipi.noda.api.mongo.aggregateOperator;

public abstract class AggregateOperator extends gr.unipi.noda.api.core.operators.AggregateOperator<StringBuilder> {

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
