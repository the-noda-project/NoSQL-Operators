package gr.ds.unipi.noda.api.core.operators.filterOperators.textualOperators;

import gr.ds.unipi.noda.api.core.operators.filterOperators.FilterOperator;

public abstract class TextualOperator<T> implements FilterOperator<T> {

    private final String fieldName;
    private final String[] elements;

    protected TextualOperator(String fieldName, String[] elements){
        this.fieldName = fieldName;
        this.elements = elements;
    }

    protected String[] getElements() {
        return elements;
    }

    protected String getFieldName() {
        return fieldName;
    }

    public static BaseTextualOperatorFactory textualOperator;

    public static String[] allKeywordsToArray(String keyword1, String keyword2, String... keywords){
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
        return keywordsArray;
    }

    public static String[] anyKeywordsToArray(String keyword, String... keywords){
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
        return keywordsArray;
    }
}
