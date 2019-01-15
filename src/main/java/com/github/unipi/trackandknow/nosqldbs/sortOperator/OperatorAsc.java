package com.github.unipi.trackandknow.nosqldbs.sortOperator;

public class OperatorAsc extends  SortingOperator {

    private OperatorAsc(String fieldName) {
        super(fieldName, 1);
    }

    public static SortingOperator newOperatorAsc(String fieldName){
        return new OperatorAsc(fieldName);
    }
}
