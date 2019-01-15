package com.github.unipi.trackandknow.nosqldbs.sortOperator;

public class OperatorDesc extends SortingOperator {

    private OperatorDesc(String fieldName) {
        super(fieldName, -1);
    }

    public static SortingOperator newOperatorDesc(String fieldName) {
        return new OperatorDesc(fieldName);
    }

}
