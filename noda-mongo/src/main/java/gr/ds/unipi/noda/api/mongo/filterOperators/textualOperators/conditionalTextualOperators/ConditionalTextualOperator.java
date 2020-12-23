package gr.ds.unipi.noda.api.mongo.filterOperators.textualOperators.conditionalTextualOperators;

public abstract class ConditionalTextualOperator extends gr.ds.unipi.noda.api.core.operators.filterOperators.textualOperators.conditionalTextualOperators.ConditionalTextualOperator<Object> {
    public ConditionalTextualOperator(String fieldName, String[] elements) {
        super(fieldName, elements);
    }

    public Object getOperatorExpression() {
        return null;
    }
}
