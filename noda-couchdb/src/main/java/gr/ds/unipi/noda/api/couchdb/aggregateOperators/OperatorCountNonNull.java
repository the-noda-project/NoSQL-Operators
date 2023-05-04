package gr.ds.unipi.noda.api.couchdb.aggregateOperators;

import org.apache.commons.lang.StringEscapeUtils;

public class OperatorCountNonNull extends AggregateOperator {

    private OperatorCountNonNull(String fieldName) {
        super(fieldName, "countNonNull_" + fieldName);
    }

    public static OperatorCountNonNull newOperatorCountNonNull(String fieldName) {
        return new OperatorCountNonNull(fieldName);
    }

    @Override
    protected String reduceStageExpression() {
        String escapedFieldName = StringEscapeUtils.escapeJavaScript(getFieldName());
        return "values.map(a => a[\"" + escapedFieldName + "\"]).filter(a => a != null).length";
    }

    @Override
    protected String rereduceStageExpression() {
        String escapedAlias = StringEscapeUtils.escapeJavaScript(getAlias());
        return "values.reduce((a, b) => a + b[\"" + escapedAlias + "\"], 0)";
    }
}
