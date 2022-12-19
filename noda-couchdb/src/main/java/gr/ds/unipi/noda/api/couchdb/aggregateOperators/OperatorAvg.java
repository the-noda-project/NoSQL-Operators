package gr.ds.unipi.noda.api.couchdb.aggregateOperators;

final class OperatorAvg extends AggregateOperator {

    private OperatorAvg(String fieldName) {
        super(fieldName, "avg_" + fieldName);
    }

    public static OperatorAvg newOperatorAvg(String fieldName) {
        return new OperatorAvg(fieldName);
    }

    @Override
    protected String reduceStageExpression() {
        return "sum(values.map(a => a[\"" + getFieldName() + "\"]))";
    }

    @Override
    protected String rereduceStageExpression() {
        return "values.reduce((a, b) => a + b[\"" + getAlias() + "\"], 0) / values.length";
    }
}
