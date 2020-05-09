package gr.ds.unipi.noda.api.mongo.aggregateOperators;

public class OperatorCountNonNull extends AggregateOperator {

    private OperatorCountNonNull(String fieldName) {
        super(fieldName, "countNonNull_" + fieldName);
    }

    public static OperatorCountNonNull newOperatorCountNonNull(String fieldName) {
        return new OperatorCountNonNull(fieldName);
    }

    @Override
    protected String getOperatorJsonField() {
        return "sum";
    }

    @Override
    public StringBuilder getOperatorExpression() {
        StringBuilder sb = new StringBuilder();
        sb.append(getAlias());

        sb.append(": { $");
        sb.append(getOperatorJsonField());
        sb.append(": { $cond: [ { $ne: [");

        sb.append("\"$");
        sb.append(getFieldName());
        sb.append("\"");

        sb.append(", null ] }, 1, 0 ] } }");

        return sb;
    }
}
