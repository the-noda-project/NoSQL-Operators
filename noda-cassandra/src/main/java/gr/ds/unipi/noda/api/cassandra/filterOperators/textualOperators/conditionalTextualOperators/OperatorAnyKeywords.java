package gr.ds.unipi.noda.api.cassandra.filterOperators.textualOperators.conditionalTextualOperators;

import java.util.Arrays;
import java.util.stream.Collectors;

public final class OperatorAnyKeywords extends ConditionalTextualOperator {

    private OperatorAnyKeywords(String fieldName, String[] elements) {
        super(fieldName, elements);
    }

    public static OperatorAnyKeywords newOperatorAnyKeywords(String fieldName, String keyword, String... keywords) {
        return new OperatorAnyKeywords(fieldName, oneKeywordsAtLeastToArray(keyword, keywords));
    }

    @Override
    public StringBuilder getOperatorExpression() {
        StringBuilder operation = new StringBuilder("ANY(");
        operation.append(getFieldName()).append(",[");
        operation.append(Arrays.stream(getKeywords()).map(keyword -> '\'' + keyword + '\'').collect(Collectors.joining(",")));
        operation.append("])");
        return operation;
    }
}
