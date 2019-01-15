package com.github.unipi.trackandknow.nosqldbs.sortOperator;

public class SortingOperators {

    public static SortingOperator asc(String fieldName){
        return OperatorAsc.newOperatorAsc(fieldName);
    }

    public static SortingOperator desc(String fieldName){
        return OperatorDesc.newOperatorDesc(fieldName);
    }
}
