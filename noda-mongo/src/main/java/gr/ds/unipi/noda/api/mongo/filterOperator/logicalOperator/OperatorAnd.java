package gr.ds.unipi.noda.api.mongo.filterOperator.logicalOperator;

import gr.ds.unipi.noda.api.core.operators.filterOperators.FilterOperator;

class OperatorAnd extends LogicalOperator {

    private OperatorAnd(FilterOperator filterOperator1, FilterOperator filterOperator2, FilterOperator... filterOperators) {
        super(filterOperator1, filterOperator2, filterOperators);
    }

    @Override
    protected String getOperatorJsonField() {
        return "and";
    }

    public static OperatorAnd newOperatorAnd(FilterOperator filterOperator1, FilterOperator filterOperator2, FilterOperator... filterOperators) {
        return new OperatorAnd(filterOperator1, filterOperator2, filterOperators);
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
