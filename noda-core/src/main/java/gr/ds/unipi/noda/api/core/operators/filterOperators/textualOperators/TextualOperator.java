package gr.ds.unipi.noda.api.core.operators.filterOperators.textualOperators;

import gr.ds.unipi.noda.api.core.operators.filterOperators.FilterOperator;

public abstract class TextualOperator<T> implements FilterOperator<T> {

    private final String fieldName;
    private final String[] elements;
    private final int condition;//0 for or (any), 1 for and (all)

    protected TextualOperator(String fieldName, String[] elements, int condition){
        this.fieldName = fieldName;
        this.elements = elements;
        this.condition = condition;
    }

    protected String[] getElements() {
        return elements;
    }

    protected String getFieldName() {
        return fieldName;
    }

    protected int getCondition() {
        return condition;
    }

    public static BaseTextualOperatorFactory textualOperator;


}
