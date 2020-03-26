package gr.ds.unipi.noda.api.YYYDataBase.filterOperator.textualOperators;

import gr.ds.unipi.noda.api.core.operators.filterOperators.textualOperators.BaseTextualOperatorFactory;
import gr.ds.unipi.noda.api.core.operators.filterOperators.textualOperators.TextualOperator;

public final class YYYDataBaseTextualOperatorFactory extends BaseTextualOperatorFactory {
    @Override
    public TextualOperator newOperatorAnyKeywords(String fieldName, String keyword, String... keywords) {
        return null;
    }

    @Override
    public TextualOperator newOperatorAllKeywords(String fieldName, String keyword1, String keyword2, String... keywords) {
        return null;
    }
}
