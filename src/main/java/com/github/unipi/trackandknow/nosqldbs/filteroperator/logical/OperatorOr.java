package com.github.unipi.trackandknow.nosqldbs.filteroperator.logical;

import com.github.unipi.trackandknow.nosqldbs.filteroperator.FilterOperator;

public class OperatorOr implements LogicalOperator {

    private final FilterOperator[] filterOperatorChildren;

    private OperatorOr(FilterOperator... filterOperatorChildren){
        checkNumberOfChildrenCondition(filterOperatorChildren);
        this.filterOperatorChildren = filterOperatorChildren;
    }

    public static OperatorOr newOperatorOr(FilterOperator... filterOperatorChildren){
        return new OperatorOr(filterOperatorChildren);
    }

    @Override
    public FilterOperator[] getfilterOperatorChildren() {
        return filterOperatorChildren;
    }

    @Override
    public int getLogicalOperatorId() {
        return 0;
    }

//    @Override
//    public String getJsonString() {
//
//        StringBuilder sb = new StringBuilder();
//        sb.append(sb);
//
//        for(FilterOperator fop: filterOperatorChildren){
//            sb.append(fop.getJsonString()+", ");
//        }
//
//        sb.deleteCharAt(sb.lastIndexOf(", "));
//
//        return "{ $or: [ "+sb.toString()+"] }";
//    }

}
