package gr.ds.unipi.noda.api.couchdb.aggregateOperators;

import org.apache.commons.lang3.StringEscapeUtils;

final class OperatorCount extends AggregateOperator {

    private OperatorCount(String fieldName) {
        super(fieldName, "count");
    }

    public static OperatorCount newOperatorCount() {
        return new OperatorCount("");
    }

    @Override
    protected String reduceStageExpression() {
        String escapedFieldName = StringEscapeUtils.escapeEcmaScript(getFieldName());
        return "values.map(a => a[\"" + escapedFieldName + "\"]).length";
    }

    @Override
    protected String rereduceStageExpression() {
        String escapedAlias = StringEscapeUtils.escapeEcmaScript(getAlias());
        return "values.reduce((a, b) => a + b[\"" + escapedAlias + "\"], 0)";
    }
}
