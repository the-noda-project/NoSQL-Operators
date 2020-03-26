package gr.ds.unipi.noda.api.mongo.filterOperators.comparisonOperators;

import java.text.SimpleDateFormat;
import java.util.Date;

abstract class ComparisonOperator<U> extends gr.ds.unipi.noda.api.core.operators.filterOperators.comparisonOperators.ComparisonOperator<StringBuilder, U> {

    protected ComparisonOperator(String fieldName, U fieldValue) {
        super(fieldName, fieldValue);
    }

    protected abstract String getOperatorJsonField();

    @Override
    public StringBuilder getOperatorExpression() {
        StringBuilder sb = new StringBuilder();
        sb.append("{ ");

        if (!getFieldName().contains(".")) {
            sb.append(getFieldName());
        } else {
            sb.append("\"" + getFieldName() + "\"");
        }

        sb.append(": { $");
        sb.append(getOperatorJsonField());
        sb.append(": ");

        if ((getFieldValue().getClass() == String.class)) {
            sb.append("\"" + getFieldValue() + "\"");
        } else if ((getFieldValue().getClass() == Date.class)) {


            sb.append("new Date(\"" + new SimpleDateFormat("EEE MMM dd yyyy HH:mm:ss z").format(getFieldValue()) + "\")");
        } else {
            sb.append("\"" + getFieldValue() + "\"");
        }

        sb.append("} }");

        return sb;

    }
}
