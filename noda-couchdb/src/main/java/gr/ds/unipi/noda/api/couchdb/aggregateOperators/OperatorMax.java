package gr.ds.unipi.noda.api.couchdb.aggregateOperators;

final class OperatorMax extends AggregateOperator {

    private OperatorMax(String fieldName) {
        super(fieldName, "max_" + fieldName);
    }

    public static OperatorMax newOperatorMax(String fieldName) {
        return new OperatorMax(fieldName);
    }

    @Override
    protected String reduceStageExpression() {
        return "Math.max.apply(null, values.map(a => a[\"" + getFieldName() + "\"]))";
    }

    @Override
    protected String rereduceStageExpression() {
        return "values.reduce((a, b) => Math.max(a, b[\"" + getAlias() + "\"]), -Infinity)";
    }
}
