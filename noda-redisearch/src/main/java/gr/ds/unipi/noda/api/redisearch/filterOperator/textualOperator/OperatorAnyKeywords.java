package gr.ds.unipi.noda.api.redisearch.filterOperator.textualOperator;

import gr.ds.unipi.noda.api.core.constants.StringPool;
import gr.ds.unipi.noda.api.core.operators.filterOperators.comparisonOperators.ComparisonOperator;
import gr.ds.unipi.noda.api.redisearch.filterOperator.RediSearchPostFilterOperator;

import java.util.Arrays;
import java.util.stream.Stream;

class OperatorAnyKeywords extends TextualOperator {

    private OperatorAnyKeywords(String fieldName, String[] elements){
        super(fieldName, elements);
    }

    public static OperatorAnyKeywords newOperatorAnyKeywords(String fieldName, String keyword, String... keywords){
        String[] keywordsArray;

        if (keywords.length == 0) {
            keywordsArray = new String[]{keyword};
        } else {
            keywordsArray = new String[keywords.length + 1];
            keywordsArray[0] = keyword;

            int i = 1;
            for (String kwrds : keywords) {
                keywordsArray[i++] = kwrds;
            }
        }

        return new OperatorAnyKeywords(fieldName, keywordsArray);
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
