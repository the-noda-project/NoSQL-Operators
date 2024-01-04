package gr.ds.unipi.noda.api.parquet.filterOperators.textualOperators.conditionalTextualOperators;

public abstract class ConditionalTextualOperator extends gr.ds.unipi.noda.api.core.operators.filterOperators.textualOperators.conditionalTextualOperators.ConditionalTextualOperator<Object> {
    protected ConditionalTextualOperator(String fieldName, String[] elements) {
        super(fieldName, elements);
    }

     public Object getOperatorExpression(){
        return null;
     }
}
