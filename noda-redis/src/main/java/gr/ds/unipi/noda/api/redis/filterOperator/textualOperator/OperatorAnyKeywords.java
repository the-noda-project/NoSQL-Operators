package gr.ds.unipi.noda.api.redis.filterOperator.textualOperator;

class OperatorAnyKeywords extends TextualOperator {

    private OperatorAnyKeywords(String fieldName, String[] elements, int condition){
        super(fieldName, elements, condition);
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

        return new OperatorAnyKeywords(fieldName, keywordsArray, 0);
    }

    @Override
    public Object getOperatorExpression() {
        return null;
    }
}
