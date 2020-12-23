package gr.ds.unipi.noda.api.core.operators.filterOperators.textualOperators.approximateTextualOperators;

import gr.ds.unipi.noda.api.core.operators.filterOperators.textualOperators.TextualOperator;

public abstract class ApproximateTextualOperator extends TextualOperator {

    protected ApproximateTextualOperator(String fieldName, String[] keywords) {
        super(fieldName, keywords);
    }
}
