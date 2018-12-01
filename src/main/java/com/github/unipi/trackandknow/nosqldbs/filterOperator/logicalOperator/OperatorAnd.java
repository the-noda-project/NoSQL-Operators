package com.github.unipi.trackandknow.nosqldbs.filterOperator.logicalOperator;

import com.github.unipi.trackandknow.nosqldbs.filterOperator.FilterOperator;

public class OperatorAnd extends LogicalOperator {

    private OperatorAnd(FilterOperator... filterOperatorChildren){
        super(filterOperatorChildren);
    }

    @Override
    protected String getOperatorJsonField() {
        return "and";
    }

    public static OperatorAnd newOperatorAnd(FilterOperator... filterOperator){
        return new OperatorAnd(filterOperator);
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
