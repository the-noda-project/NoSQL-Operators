package gr.ds.unipi.noda.api.YYYDataBase.filterOperator.textualOperators;

import gr.ds.unipi.noda.api.core.constants.StringPool;
import gr.ds.unipi.noda.api.core.operators.filterOperators.comparisonOperators.ComparisonOperator;
import java.util.Arrays;
import java.util.stream.Stream;

class OperatorAnyKeywords extends TextualOperator {

    private OperatorAnyKeywords(String fieldName, String[] elements){
        super(fieldName, elements);
    }

    public static OperatorAnyKeywords newOperatorAnyKeywords(String fieldName, String keyword, String... keywords){
        return new OperatorAnyKeywords(fieldName, TextualOperator.anyKeywordsToArray(keyword, keywords));
    }

}
