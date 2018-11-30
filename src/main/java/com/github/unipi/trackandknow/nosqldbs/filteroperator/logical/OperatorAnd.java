package com.github.unipi.trackandknow.nosqldbs.filteroperator.logical;

import com.github.unipi.trackandknow.nosqldbs.filteroperator.FilterOperator;

public class OperatorAnd implements LogicalOperator {

    private final FilterOperator[] filterOperatorChildren;

    private OperatorAnd(FilterOperator... filterOperatorChildren){
        checkNumberOfChildrenCondition(filterOperatorChildren);
        this.filterOperatorChildren = filterOperatorChildren;
    }

    public static OperatorAnd newOperatorAnd(FilterOperator... filterOperator){
        return new OperatorAnd(filterOperator);
    }

    @Override
    public FilterOperator[] getfilterOperatorChildren() {
        return filterOperatorChildren;
    }

    @Override
    public int getLogicalOperatorId() {
        return 1;
    }

//    @Override
//    public String getJsonString() {
//
//        StringBuilder sb = new StringBuilder();
//
//        for(FilterOperator fop: filterOperatorChildren){
//            sb.append(fop.getJsonString()+", ");
//        }
//
//        sb.deleteCharAt(sb.lastIndexOf(","));
//
//        return "{ $and: [ "+sb.toString()+"] }";
//    }

}
