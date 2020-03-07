package gr.ds.unipi.noda.api.redis.filterOperator.textualOperator;

abstract class TextualOperator extends gr.ds.unipi.noda.api.core.operators.filterOperators.textualOperators.TextualOperator {

    TextualOperator(String fieldName, String[] elements, int condition) {
        super(fieldName, elements, condition);
    }
}
