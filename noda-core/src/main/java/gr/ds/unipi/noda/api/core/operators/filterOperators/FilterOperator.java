package gr.ds.unipi.noda.api.core.operators.filterOperators;

import gr.ds.unipi.noda.api.core.operators.Operator;

public interface FilterOperator<T> extends Operator<T> {

    default StringBuilder toString(String level){
        return null;
    }
}
