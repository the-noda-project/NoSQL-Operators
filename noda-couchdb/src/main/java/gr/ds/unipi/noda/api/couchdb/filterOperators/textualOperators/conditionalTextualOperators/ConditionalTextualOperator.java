package gr.ds.unipi.noda.api.couchdb.filterOperators.textualOperators.conditionalTextualOperators;

import org.apache.commons.lang.StringEscapeUtils;

import java.util.Arrays;
import java.util.stream.Collectors;

public abstract class ConditionalTextualOperator extends gr.ds.unipi.noda.api.core.operators.filterOperators.textualOperators.conditionalTextualOperators.ConditionalTextualOperator<String> {
    protected ConditionalTextualOperator(String fieldName, String[] elements) {
        super(fieldName, elements);
    }

    abstract protected String operatorSymbol();

    public String getOperatorExpression() {
        String escapedFieldName = StringEscapeUtils.escapeJavaScript(getFieldName());
        return "(" + Arrays.stream(getKeywords())
                .map(keyword -> "doc[\"" + escapedFieldName + "\"].includes(\"" +
                        StringEscapeUtils.escapeJavaScript(keyword) + "\")" + operatorSymbol())
                .collect(Collectors.joining(operatorSymbol())) + ")";
    }
}
