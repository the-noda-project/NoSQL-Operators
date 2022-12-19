package gr.ds.unipi.noda.api.couchdb.aggregateOperators;

final class OperatorSum extends AggregateOperator {

    private OperatorSum(String fieldName) {
        super(fieldName, "sum_" + fieldName);
    }

    public static OperatorSum newOperatorSum(String fieldName) {
        return new OperatorSum(fieldName);
    }

    @Override
    protected String reduceStageExpression() {
        return "sum(values.map(a => a[\"" + getFieldName() + "\"]))";
    }

    @Override
    protected String rereduceStageExpression() {
        return "values.reduce((a, b) => a + b[\"" + getAlias() + "\"], 0)";
    }
}
