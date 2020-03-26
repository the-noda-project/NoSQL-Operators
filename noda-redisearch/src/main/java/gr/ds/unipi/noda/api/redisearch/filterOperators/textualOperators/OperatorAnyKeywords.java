package gr.ds.unipi.noda.api.redisearch.filterOperators.textualOperators;

import gr.ds.unipi.noda.api.core.constants.StringPool;
import gr.ds.unipi.noda.api.core.operators.filterOperators.comparisonOperators.ComparisonOperator;
import gr.ds.unipi.noda.api.redisearch.filterOperators.RediSearchPostFilterOperator;

import java.util.Arrays;
import java.util.stream.Stream;

class OperatorAnyKeywords extends TextualOperator {

    private OperatorAnyKeywords(String fieldName, String[] elements){
        super(fieldName, elements);
    }

    public static OperatorAnyKeywords newOperatorAnyKeywords(String fieldName, String keyword, String... keywords){
        return new OperatorAnyKeywords(fieldName, TextualOperator.anyKeywordsToArray(keyword, keywords));
    }

    @Override
    protected String getOperatorField() {
        return String.join(StringPool.PIPE, Arrays.asList(getElements()));
    }

    @Override
    protected StringBuilder getPostOperatorField() {
        StringBuilder sb = new StringBuilder();
        Stream.of(getElements())
                .forEach(t -> sb.append(((RediSearchPostFilterOperator) ComparisonOperator.comparisonOperator.newOperatorEq(getFieldName(), t))
                        .getPostOperatorExpression()).append(StringPool.DOUBLE_PIPE));
        return sb;
    }
}
