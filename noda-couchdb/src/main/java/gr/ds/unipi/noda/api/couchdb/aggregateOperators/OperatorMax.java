package gr.ds.unipi.noda.api.couchdb.aggregateOperators;

import org.apache.commons.lang3.StringEscapeUtils;

final class OperatorMax extends AggregateOperator {

    private OperatorMax(String fieldName) {
        super(fieldName, "max_" + fieldName);
    }

    public static OperatorMax newOperatorMax(String fieldName) {
        return new OperatorMax(fieldName);
    }

    @Override
    protected String reduceStageExpression() {
        String escapedFieldName = StringEscapeUtils.escapeEcmaScript(getFieldName());
        return "Math.max.apply(null, values.map(a => a[\"" + escapedFieldName + "\"]))";
    }

    @Override
    protected String rereduceStageExpression() {
        String escapedAlias = StringEscapeUtils.escapeEcmaScript(getAlias());
        return "values.reduce((a, b) => Math.max(a, b[\"" + escapedAlias + "\"]), -Infinity)";
    }
}
