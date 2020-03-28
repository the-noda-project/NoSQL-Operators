package gr.ds.unipi.noda.api.hbase.filterOperator.textualOperators;

import gr.ds.unipi.noda.api.core.operators.filterOperators.textualOperators.BaseTextualOperatorFactory;
import gr.ds.unipi.noda.api.core.operators.filterOperators.textualOperators.TextualOperator;

public final class HBaseTextualOperatorFactory extends BaseTextualOperatorFactory {
    @Override
    public TextualOperator newOperatorAnyKeywords(String fieldName, String keyword, String... keywords) {
        return OperatorAnyKeywords.newOperatorAnyKeywords(fieldName, keyword, keywords);
    }

    @Override
    public TextualOperator newOperatorAllKeywords(String fieldName, String keyword1, String keyword2, String... keywords) {
        return OperatorAllKeywords.newOperatorAllKeywords(fieldName, keyword1, keyword2, keywords);
    }
}
