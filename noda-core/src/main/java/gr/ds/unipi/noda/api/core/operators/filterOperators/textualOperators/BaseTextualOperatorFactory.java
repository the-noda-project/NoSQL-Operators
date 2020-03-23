package gr.ds.unipi.noda.api.core.operators.filterOperators.textualOperators;

public abstract class BaseTextualOperatorFactory {

    public abstract TextualOperator newOperatorAnyKeywords(String fieldName, String keyword, String... keywords);

    public abstract TextualOperator newOperatorAllKeywords(String fieldName, String keyword1, String keyword2, String... keywords);

    public abstract TextualOperator newOperatorNoneKeywords(String fieldName, String keyword1, String keyword2, String... keywords);

}
