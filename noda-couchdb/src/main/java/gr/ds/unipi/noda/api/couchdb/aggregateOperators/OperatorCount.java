package gr.ds.unipi.noda.api.couchdb.aggregateOperators;

final class OperatorCount extends AggregateOperator {

    private OperatorCount(String fieldName) {
        super(fieldName, "count");
    }

    public static OperatorCount newOperatorCount() {
        return new OperatorCount("");
    }

    @Override
    protected String reduceStageExpression() {
        return "values.map(a => a[\"" + getFieldName() + "\"]).length";
    }

    @Override
    protected String rereduceStageExpression() {
        return "values.reduce((a, b) => a + b[\"" + getAlias() + "\"], 0)";
    }
}
