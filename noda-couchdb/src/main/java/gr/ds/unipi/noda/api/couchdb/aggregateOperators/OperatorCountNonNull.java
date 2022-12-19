package gr.ds.unipi.noda.api.couchdb.aggregateOperators;

public class OperatorCountNonNull extends AggregateOperator {

    private OperatorCountNonNull(String fieldName) {
        super(fieldName, "countNonNull_" + fieldName);
    }

    public static OperatorCountNonNull newOperatorCountNonNull(String fieldName) {
        return new OperatorCountNonNull(fieldName);
    }

    @Override
    protected String reduceStageExpression() {
        return "values.map(a => a[\"" + getFieldName() + "\"]).filter(a => a != null).length";
    }

    @Override
    protected String rereduceStageExpression() {
        return "values.reduce((a, b) => a + b[\"" + getAlias() + "\"], 0)";
    }
}
