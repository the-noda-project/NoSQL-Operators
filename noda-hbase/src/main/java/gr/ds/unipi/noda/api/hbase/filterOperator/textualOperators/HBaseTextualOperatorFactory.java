package gr.ds.unipi.noda.api.hbase.filterOperator.textualOperators;

import gr.ds.unipi.noda.api.core.operators.filterOperators.textualOperators.BaseTextualOperatorFactory;
import gr.ds.unipi.noda.api.core.operators.filterOperators.textualOperators.TextualOperator;
import gr.ds.unipi.noda.api.core.operators.filterOperators.textualOperators.conditionalTextualOperators.ConditionalTextualOperator;

public final class HBaseTextualOperatorFactory extends BaseTextualOperatorFactory {

    @Override
    public ConditionalTextualOperator newOperatorAnyKeywords(String fieldName, String keyword, String... keywords) {
        return null;
    }

    @Override
    public ConditionalTextualOperator newOperatorAllKeywords(String fieldName, String keyword1, String keyword2, String... keywords) {
        return null;
    }
}
