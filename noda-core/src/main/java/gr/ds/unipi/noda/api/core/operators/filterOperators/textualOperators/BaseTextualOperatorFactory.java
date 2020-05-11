package gr.ds.unipi.noda.api.core.operators.filterOperators.textualOperators;

import gr.ds.unipi.noda.api.core.operators.filterOperators.textualOperators.conditionalTextualOperators.ConditionalTextualOperator;

public abstract class BaseTextualOperatorFactory {

    public abstract ConditionalTextualOperator newOperatorAnyKeywords(String fieldName, String keyword, String... keywords);

    public abstract ConditionalTextualOperator newOperatorAllKeywords(String fieldName, String keyword1, String keyword2, String... keywords);

}
