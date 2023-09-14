package gr.ds.unipi.noda.api.couchdb.aggregateOperators;

import org.apache.commons.lang3.StringEscapeUtils;

public class OperatorCountDistinct extends AggregateOperator {

    private OperatorCountDistinct(String fieldName) {
        super(fieldName, "countDistinct_" + fieldName);
    }

    public static OperatorCountDistinct newOperatorCountDistinct(String fieldName) {
        return new OperatorCountDistinct(fieldName);
    }

    @Override
    protected String reduceStageExpression() {
        String escapedFieldName = StringEscapeUtils.escapeEcmaScript(getAlias());
        return "values.map(a => a[\"" + escapedFieldName + "\"]).filter((a, idx, arr) => arr.indexOf(a) === idx).length";
    }

    @Override
    protected String rereduceStageExpression() {
        String escapedFieldName = StringEscapeUtils.escapeEcmaScript(getAlias());
        return "values.reduce((a, b) => a + b[\"" + escapedFieldName + "\"], 0)";
    }
}
