package gr.ds.unipi.noda.api.YYYDataBase.filterOperator.textualOperators;

import gr.ds.unipi.noda.api.core.constants.StringPool;
import gr.ds.unipi.noda.api.core.operators.filterOperators.comparisonOperators.ComparisonOperator;
import java.util.Arrays;
import java.util.stream.Stream;

class OperatorAllKeywords extends TextualOperator {

    private OperatorAllKeywords(String fieldName, String[] elements){
        super(fieldName, elements);
    }

    public static OperatorAllKeywords newOperatorAllKeywords(String fieldName, String keyword1, String keyword2, String... keywords){
        return new OperatorAllKeywords(fieldName, TextualOperator.allKeywordsToArray(keyword1, keyword2, keywords));
    }

}
