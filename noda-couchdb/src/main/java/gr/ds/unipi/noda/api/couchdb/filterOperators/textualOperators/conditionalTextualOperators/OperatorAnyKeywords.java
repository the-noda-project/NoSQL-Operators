package gr.ds.unipi.noda.api.couchdb.filterOperators.textualOperators.conditionalTextualOperators;

import gr.ds.unipi.noda.api.couchdb.filterOperators.FilterStrategy;
import org.apache.commons.lang3.StringEscapeUtils;

import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
import java.util.stream.Collectors;

public final class OperatorAnyKeywords extends ConditionalTextualOperator {
    private OperatorAnyKeywords(String fieldName, String[] elements) {
        super(fieldName, elements);
    }

    public static OperatorAnyKeywords newOperatorAnyKeywords(String fieldName, String keyword, String... keywords) {
        return new OperatorAnyKeywords(fieldName, oneKeywordsAtLeastToArray(keyword, keywords));
    }

    @Override
    public FilterStrategy getOperatorExpression() {
        return new FilterStrategy() {
            @Override
            public CharSequence asMapFilter() {
                String keywords = Arrays.stream(getKeywords())
                        .map(kw -> '"' + StringEscapeUtils.escapeEcmaScript(kw) + '"')
                        .collect(Collectors.joining(","));

                return "[" + keywords + "].some(kw => doc[\"" + StringEscapeUtils.escapeEcmaScript(getFieldName()) +
                        "\"].includes(kw))";
            }

            @Override
            public Map<String, Object> asFindFilter() {
                return Collections.singletonMap(getFieldName(),
                        Collections.singletonMap("$elemMatch", Collections.singletonMap("$or", getKeywords()))
                );
            }
        };
    }
}
