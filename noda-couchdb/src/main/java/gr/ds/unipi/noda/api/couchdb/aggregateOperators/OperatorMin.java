package gr.ds.unipi.noda.api.couchdb.aggregateOperators;

final class OperatorMin extends AggregateOperator {

    private OperatorMin(String fieldName) {
        super(fieldName, "min_" + fieldName);
    }

    public static OperatorMin newOperatorMin(String fieldName) {
        return new OperatorMin(fieldName);
    }

    @Override
    protected String reduceStageExpression() {
        return "Math.min.apply(null, values.map(a => a[\"" + getFieldName() + "\"]))";
    }

    @Override
    protected String rereduceStageExpression() {
        return "values.reduce((a, b) => Math.min(a, b[\"" + getAlias() + "\"]), Infinity)";
    }
}
