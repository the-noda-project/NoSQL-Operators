package gr.ds.unipi.noda.api.hbase.filterOperator.textualOperators.conditionalTextualOperators;

import gr.ds.unipi.noda.api.core.operators.filterOperators.textualOperators.TextualOperator;

public final class OperatorAnyKeywords extends ConditionalTextualOperator {

    private OperatorAnyKeywords(String fieldName, String[] elements){
        super(fieldName, elements);
    }

    public static OperatorAnyKeywords newOperatorAnyKeywords(String fieldName, String keyword, String... keywords){
        return new OperatorAnyKeywords(fieldName, TextualOperator.oneKeywordsAtLeastToArray(keyword, keywords));
    }

}
