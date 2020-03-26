package gr.ds.unipi.noda.api.redisearch.filterOperators.textualOperators;

import gr.ds.unipi.noda.api.core.constants.StringPool;
import gr.ds.unipi.noda.api.core.operators.filterOperators.comparisonOperators.ComparisonOperator;
import gr.ds.unipi.noda.api.redisearch.filterOperators.RediSearchPostFilterOperator;

import java.util.Arrays;
import java.util.stream.Stream;

class OperatorAllKeywords extends TextualOperator {

    private OperatorAllKeywords(String fieldName, String[] elements){
        super(fieldName, elements);
    }

    public static OperatorAllKeywords newOperatorAllKeywords(String fieldName, String keyword1, String keyword2, String... keywords){
        return new OperatorAllKeywords(fieldName, TextualOperator.allKeywordsToArray(keyword1, keyword2, keywords));
    }

    @Override
    protected String getOperatorField() {
        return String.join(StringPool.SPACE, Arrays.asList(getElements()));
    }

    @Override
    protected StringBuilder getPostOperatorField() {
        StringBuilder sb = new StringBuilder();
        Stream.of(getElements())
        .forEach(t -> sb.append(((RediSearchPostFilterOperator)ComparisonOperator.comparisonOperator.newOperatorEq(getFieldName(), t))
                .getPostOperatorExpression()).append(StringPool.DOUBLE_AMPERSAND));
        return sb;
    }
}
