package gr.ds.unipi.noda.api.couchdb.filterOperators.textualOperators.conditionalTextualOperators;

import gr.ds.unipi.noda.api.couchdb.filterOperators.FilterStrategy;
import org.apache.commons.lang3.StringEscapeUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
import java.util.stream.Collectors;

public abstract class ConditionalTextualOperator extends gr.ds.unipi.noda.api.core.operators.filterOperators.textualOperators.conditionalTextualOperators.ConditionalTextualOperator<FilterStrategy> {
    protected ConditionalTextualOperator(String fieldName, String[] elements) {
        super(fieldName, elements);
    }

    abstract protected String mapOperatorSymbol();

    abstract protected String mangoOperatorSymbol();

    public FilterStrategy getOperatorExpression() {
        return new FilterStrategy() {
            @Override
            public String asMapFilter() {
                String fieldName = StringEscapeUtils.escapeEcmaScript(getFieldName());

                return "(" + Arrays.stream(getKeywords()).map(kw -> {
                    String keyword = StringEscapeUtils.escapeEcmaScript(kw);
                    return "doc[\"" + fieldName + "\"].includes(\"" + keyword + "\")" + mapOperatorSymbol();
                }).collect(Collectors.joining(mapOperatorSymbol())) + ")";
            }

            @Override
            public Map<String, Object> asFindFilter() {
                ArrayList<Map<String, String>> matches = new ArrayList<>();

                for (String keyword : getKeywords()) {
                    matches.add(Collections.singletonMap(getFieldName(), keyword));
                }

                return Collections.singletonMap(mangoOperatorSymbol(), matches);
            }
        };
    }
}
