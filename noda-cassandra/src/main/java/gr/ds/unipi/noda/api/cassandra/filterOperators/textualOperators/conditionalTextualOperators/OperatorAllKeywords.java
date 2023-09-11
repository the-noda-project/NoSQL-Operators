package gr.ds.unipi.noda.api.cassandra.filterOperators.textualOperators.conditionalTextualOperators;

import java.util.Arrays;
import java.util.stream.Collectors;

public final class OperatorAllKeywords extends ConditionalTextualOperator {

    private OperatorAllKeywords(String fieldName, String[] elements) {
        super(fieldName, elements);
    }

    public static OperatorAllKeywords newOperatorAllKeywords(String fieldName, String keyword1, String keyword2, String... keywords) {
        return new OperatorAllKeywords(fieldName, twoKeywordsAtLeastToArray(keyword1, keyword2, keywords));
    }

    @Override
    public StringBuilder getOperatorExpression() {
        StringBuilder operation = new StringBuilder("ALL(");
        operation.append(getFieldName()).append(",[");
        operation.append(Arrays.stream(getKeywords()).map(keyword -> '\'' + keyword + '\'').collect(Collectors.joining(",")));
        operation.append("])");
        return operation;
    }
}
