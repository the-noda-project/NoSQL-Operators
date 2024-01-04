package gr.ds.unipi.noda.api.parquet.filterOperators.textualOperators.conditionalTextualOperators;

public final class OperatorAnyKeywords extends ConditionalTextualOperator {

    private OperatorAnyKeywords(String fieldName, String[] elements){
        super(fieldName, elements);
    }

    public static OperatorAnyKeywords newOperatorAnyKeywords(String fieldName, String keyword, String... keywords){
        return new OperatorAnyKeywords(fieldName, oneKeywordsAtLeastToArray(keyword, keywords));
    }

}
