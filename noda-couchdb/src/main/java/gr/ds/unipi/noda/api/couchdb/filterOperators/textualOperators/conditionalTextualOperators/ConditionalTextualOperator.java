package gr.ds.unipi.noda.api.couchdb.filterOperators.textualOperators.conditionalTextualOperators;

import com.google.gson.Gson;

import java.util.Arrays;
import java.util.stream.Collectors;

public abstract class ConditionalTextualOperator extends gr.ds.unipi.noda.api.core.operators.filterOperators.textualOperators.conditionalTextualOperators.ConditionalTextualOperator<String> {
    protected ConditionalTextualOperator(String fieldName, String[] elements) {
        super(fieldName, elements);
    }

    abstract protected String operatorSymbol();

    public String getOperatorExpression() {
        Gson gson = new Gson();
        return "(" + Arrays.stream(getKeywords())
                .map(keyWord -> "doc[" + gson.toJson(getFieldName()) + "].includes(" + gson.toJson(keyWord) + ")")
                .collect(Collectors.joining(operatorSymbol())) + ")";
    }
}
