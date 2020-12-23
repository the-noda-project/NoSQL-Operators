package gr.ds.unipi.noda.api.core.operators.filterOperators.textualOperators.conditionalTextualOperators;

import gr.ds.unipi.noda.api.core.operators.filterOperators.textualOperators.TextualOperator;

public abstract class ConditionalTextualOperator<T> extends TextualOperator<T> {

    protected ConditionalTextualOperator(String fieldName, String[] keywords) {
        super(fieldName, keywords);
    }
}
