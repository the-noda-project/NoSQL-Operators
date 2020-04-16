package gr.ds.unipi.noda.api.hbase.filterOperator.textualOperators;

final class OperatorAnyKeywords extends TextualOperator {

    private OperatorAnyKeywords(String fieldName, String[] elements) {
        super(fieldName, elements);
    }

    public static OperatorAnyKeywords newOperatorAnyKeywords(String fieldName, String keyword, String... keywords) {
        return new OperatorAnyKeywords(fieldName, anyKeywordsToArray(keyword, keywords));
    }

}
