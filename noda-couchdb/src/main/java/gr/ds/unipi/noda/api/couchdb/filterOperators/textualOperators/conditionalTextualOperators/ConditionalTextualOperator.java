package gr.ds.unipi.noda.api.couchdb.filterOperators.textualOperators.conditionalTextualOperators;

import gr.ds.unipi.noda.api.couchdb.filterOperators.FilterStrategy;

public abstract class ConditionalTextualOperator extends gr.ds.unipi.noda.api.core.operators.filterOperators.textualOperators.conditionalTextualOperators.ConditionalTextualOperator<FilterStrategy> {
    protected ConditionalTextualOperator(String fieldName, String[] elements) {
        super(fieldName, elements);
    }
}
