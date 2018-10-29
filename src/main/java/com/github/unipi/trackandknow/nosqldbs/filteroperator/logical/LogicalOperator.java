package com.github.unipi.trackandknow.nosqldbs.filteroperator.logical;

import com.github.unipi.trackandknow.nosqldbs.filteroperator.FilterOperator;

public interface LogicalOperator extends FilterOperator {

    default void checkNumberOfChildrenCondition(FilterOperator... filterOperatorChildren)
    {
        if(filterOperatorChildren.length < 2){
            try {
                throw new Exception("Less than two children");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
