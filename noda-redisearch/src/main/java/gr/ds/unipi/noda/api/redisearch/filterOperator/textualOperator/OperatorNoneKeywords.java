package gr.ds.unipi.noda.api.redisearch.filterOperator.textualOperator;

import gr.ds.unipi.noda.api.core.constants.StringPool;
import gr.ds.unipi.noda.api.core.operators.filterOperators.comparisonOperators.ComparisonOperator;
import gr.ds.unipi.noda.api.redisearch.filterOperator.RediSearchPostFilterOperator;

import java.util.Arrays;
import java.util.stream.Stream;

class OperatorNoneKeywords extends TextualOperator {

    private OperatorNoneKeywords(String fieldName, String[] elements, int condition, boolean isNotEqual){
        super(fieldName, elements, condition, isNotEqual);
    }

    public static OperatorNoneKeywords newOperatorAllKeywords(String fieldName, String keyword1, String keyword2, String... keywords){
        String[] keywordsArray;

        if (keywords.length == 0) {
            keywordsArray = new String[]{keyword1, keyword2};
        } else {
            keywordsArray = new String[keywords.length + 2];
            keywordsArray[0] = keyword1;
            keywordsArray[1] = keyword2;

            int i = 2;
            for (String kwrds : keywords) {
                keywordsArray[i++] = kwrds;
            }
        }

        return new OperatorNoneKeywords(fieldName, keywordsArray, 1, true);
    }

    @Override
    protected String getOperatorField() {
        return String.join(StringPool.SPACE, Arrays.asList(getElements()));
    }

    @Override
    protected StringBuilder getPostOperatorField() {
        StringBuilder sb = new StringBuilder();
        Stream.of(getElements())
        .forEach(t -> sb.append(((RediSearchPostFilterOperator)ComparisonOperator.comparisonOperator.newOperatorNe(getFieldName(), t))
                .getPostOperatorExpression()).append(StringPool.DOUBLE_AMPERSAND));
        return sb;
    }
}
