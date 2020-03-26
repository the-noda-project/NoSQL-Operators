package gr.ds.unipi.noda.api.YYYDataBase.filterOperator.textualOperators;

final class OperatorAllKeywords extends TextualOperator {

    private OperatorAllKeywords(String fieldName, String[] elements){
        super(fieldName, elements);
    }

    public static OperatorAllKeywords newOperatorAllKeywords(String fieldName, String keyword1, String keyword2, String... keywords){
        return new OperatorAllKeywords(fieldName, TextualOperator.allKeywordsToArray(keyword1, keyword2, keywords));
    }

}
