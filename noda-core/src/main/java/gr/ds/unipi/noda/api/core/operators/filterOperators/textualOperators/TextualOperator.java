package gr.ds.unipi.noda.api.core.operators.filterOperators.textualOperators;

import gr.ds.unipi.noda.api.core.operators.filterOperators.FilterOperator;

public abstract class TextualOperator<T> implements FilterOperator<T> {

    private final String fieldName;
    private final String[] elements;

    protected TextualOperator(String fieldName, String[] elements){
        this.fieldName = fieldName;
        this.elements = elements;
    }

    protected String[] getElements() {
        return elements;
    }

    protected String getFieldName() {
        return fieldName;
    }

    public static BaseTextualOperatorFactory textualOperator;

}
