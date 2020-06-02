package gr.ds.unipi.noda.api.redisearch.filterOperators.textualOperators.conditionalTextualOperator;

import gr.ds.unipi.noda.api.core.constants.StringPool;
import gr.ds.unipi.noda.api.core.operators.filterOperators.comparisonOperators.ComparisonOperator;
import gr.ds.unipi.noda.api.core.operators.filterOperators.textualOperators.TextualOperator;
import gr.ds.unipi.noda.api.redisearch.filterOperators.RediSearchPostFilterOperator;
import io.redisearch.querybuilder.Node;
import io.redisearch.querybuilder.QueryBuilder;
import io.redisearch.querybuilder.Value;
import io.redisearch.querybuilder.Values;

import java.util.Arrays;
import java.util.stream.Stream;

public final class OperatorAllKeywords extends ConditionalTextualOperator {

    private OperatorAllKeywords(String fieldName, String[] elements){
        super(fieldName, elements);
    }

    public static OperatorAllKeywords newOperatorAllKeywords(String fieldName, String keyword1, String keyword2, String... keywords){
        return new OperatorAllKeywords(fieldName, TextualOperator.twoKeywordsAtLeastToArray(keyword1, keyword2, keywords));
    }

    @Override
    protected Node getOperatorField() {
        return QueryBuilder.intersect(getFieldName(), Arrays.stream(getKeywords()).map(Values::value).toArray(Value[]::new));
    }

    @Override
    protected StringBuilder getPostOperatorField() {
        StringBuilder sb = new StringBuilder();
        Stream.of(getKeywords())
        .forEach(t -> sb.append(((RediSearchPostFilterOperator)ComparisonOperator.comparisonOperator.newOperatorEq(getFieldName(), t))
                .getPostOperatorExpression()).append(StringPool.DOUBLE_AMPERSAND));
        return sb;
    }
}
