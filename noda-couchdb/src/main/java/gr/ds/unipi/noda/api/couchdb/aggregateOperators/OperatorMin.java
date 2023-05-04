package gr.ds.unipi.noda.api.couchdb.aggregateOperators;

import org.apache.commons.lang.StringEscapeUtils;

final class OperatorMin extends AggregateOperator {

    private OperatorMin(String fieldName) {
        super(fieldName, "min_" + fieldName);
    }

    public static OperatorMin newOperatorMin(String fieldName) {
        return new OperatorMin(fieldName);
    }

    @Override
    protected String reduceStageExpression() {
        String escapedFieldName = StringEscapeUtils.escapeJavaScript(getFieldName());
        return "Math.min.apply(null, values.map(a => a[\"" + escapedFieldName + "\"]))";
    }

    @Override
    protected String rereduceStageExpression() {
        String escapedAlias = StringEscapeUtils.escapeJavaScript(getAlias());
        return "values.reduce((a, b) => Math.min(a, b[\"" + escapedAlias + "\"]), Infinity)";
    }
}
