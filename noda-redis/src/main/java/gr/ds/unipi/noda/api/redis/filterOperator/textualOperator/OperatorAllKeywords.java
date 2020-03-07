package gr.ds.unipi.noda.api.redis.filterOperator.textualOperator;

class OperatorAllKeywords extends TextualOperator {

    private OperatorAllKeywords(String fieldName, String[] elements, int condition){
        super(fieldName, elements, condition);
    }

    public static OperatorAllKeywords newOperatorAllKeywords(String fieldName, String keyword1, String keyword2, String... keywords){
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

        return new OperatorAllKeywords(fieldName, keywordsArray, 1);
    }

    @Override
    public Object getOperatorExpression() {
        return null;
    }
}
