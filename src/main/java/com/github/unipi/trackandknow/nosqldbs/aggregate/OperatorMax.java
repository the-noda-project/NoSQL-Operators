package com.github.unipi.trackandknow.nosqldbs.aggregate;

class OperatorMax implements AggregateOperator {

    private final String fieldName;
    private String alias;

    private OperatorMax(String fieldName){
        this.fieldName = fieldName;
        this.alias = "max("+fieldName+")";
    }

    @Override
    public String getJsonString() {
        return alias + ": { $max: " + "\"" + "$"+ fieldName +"\""+  " }";
    }

    public static OperatorMax newOperatorMax(String fieldName){
        return new OperatorMax(fieldName);
    }

    @Override
    public AggregateOperator as(String alias) {
        this.alias = alias;
        return this;
    }
}
