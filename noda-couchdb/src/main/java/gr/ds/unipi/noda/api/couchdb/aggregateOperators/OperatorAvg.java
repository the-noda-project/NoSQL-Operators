package gr.ds.unipi.noda.api.couchdb.aggregateOperators;

import org.apache.commons.lang.StringEscapeUtils;

final class OperatorAvg extends AggregateOperator {

    private OperatorAvg(String fieldName) {
        super(fieldName, "avg_" + fieldName);
    }

    public static OperatorAvg newOperatorAvg(String fieldName) {
        return new OperatorAvg(fieldName);
    }

    @Override
    protected String reduceStageExpression() {
        String escapedFieldName = StringEscapeUtils.escapeJavaScript(getFieldName());
        return "sum(values.map(a => a[\"" + escapedFieldName + "\"]))";
    }

    @Override
    protected String rereduceStageExpression() {
        String escapedAlias = StringEscapeUtils.escapeJavaScript(getAlias());
        return "values.reduce((a, b) => a + b[\"" + escapedAlias + "\"], 0) / values.length";
    }
}
