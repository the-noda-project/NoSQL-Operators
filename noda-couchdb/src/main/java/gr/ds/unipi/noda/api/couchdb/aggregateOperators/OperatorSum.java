package gr.ds.unipi.noda.api.couchdb.aggregateOperators;

import org.apache.commons.lang3.StringEscapeUtils;

final class OperatorSum extends AggregateOperator {

    private OperatorSum(String fieldName) {
        super(fieldName, "sum_" + fieldName);
    }

    public static OperatorSum newOperatorSum(String fieldName) {
        return new OperatorSum(fieldName);
    }

    @Override
    protected String reduceStageExpression() {
        String escapedFieldName = StringEscapeUtils.escapeEcmaScript(getFieldName());
        return "sum(values.map(a => a[\"" + escapedFieldName + "\"]))";
    }

    @Override
    protected String rereduceStageExpression() {
        String escapedAlias = StringEscapeUtils.escapeEcmaScript(getAlias());
        return "values.reduce((a, b) => a + b[\"" + escapedAlias + "\"], 0)";
    }
}
