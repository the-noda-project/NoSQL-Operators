package gr.unipi.trackandknow.api.aggregateOperator;

public class OperatorCount extends AggregateOperator {

    private OperatorCount(String fieldName) {
        super(fieldName, "count");
    }

    public static OperatorCount newOperatorCount() {
        return new OperatorCount("");
    }

    @Override
    protected String getOperatorJsonField() {
        return "sum";
    }

    @Override
    public StringBuilder getJsonStringBuilder() {
        StringBuilder sb = new StringBuilder();
        sb.append(getAlias());

        sb.append(": { $");
        sb.append(getOperatorJsonField());
        sb.append(": 1");
        sb.append(" }");

        return sb;
    }
}
