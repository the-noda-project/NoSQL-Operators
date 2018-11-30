package com.github.unipi.trackandknow.nosqldbs.filteroperator.logical;

import com.github.unipi.trackandknow.nosqldbs.filteroperator.FilterOperator;

public interface LogicalOperator extends FilterOperator {

    FilterOperator[] getfilterOperatorChildren();

    int getLogicalOperatorId();

    @Override
    default StringBuilder getJsonStringBuilder(){
        return formJsonStringOfLogicalOperator();
    }

    default StringBuilder formJsonStringOfLogicalOperator(){

        StringBuilder sb = new StringBuilder();

        switch(getLogicalOperatorId()){
            case 0:
                sb.append("{ $or: [ ");
                break;
        }

        for(FilterOperator fop: getfilterOperatorChildren()){

            sb.append(fop.getJsonStringBuilder());
            sb.append(", ");

        }
        sb.deleteCharAt(sb.lastIndexOf(", "));

        sb.append(" ] }");

        return sb;
    }


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
