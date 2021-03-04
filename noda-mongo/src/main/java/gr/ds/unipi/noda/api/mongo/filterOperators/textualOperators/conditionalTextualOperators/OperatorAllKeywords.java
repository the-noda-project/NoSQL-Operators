package gr.ds.unipi.noda.api.mongo.filterOperators.textualOperators.conditionalTextualOperators;

import gr.ds.unipi.noda.api.core.operators.filterOperators.textualOperators.TextualOperator;

public final class OperatorAllKeywords extends ConditionalTextualOperator {

    protected OperatorAllKeywords(String fieldName, String[] elements) {
        super(fieldName, elements);
    }

    public static OperatorAllKeywords newOperatorAllKeywords(String fieldName, String keyword1, String keyword2, String... keywords) {
        return new OperatorAllKeywords(fieldName, TextualOperator.twoKeywordsAtLeastToArray(keyword1, keyword2, keywords));
    }

}
