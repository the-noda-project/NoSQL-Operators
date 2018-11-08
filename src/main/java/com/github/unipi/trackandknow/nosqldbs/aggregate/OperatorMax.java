package com.github.unipi.trackandknow.nosqldbs.aggregate;

public class OperatorMax implements AggregateOperator {

    private final String fieldName;
    private final String newFieldName;

    private OperatorMax(String fieldName, String newFieldName){
        this.fieldName = fieldName;
        this.newFieldName = newFieldName;
    }

    private OperatorMax(String fieldName){
        this.fieldName = fieldName;
        this.newFieldName = null;
    }

    @Override
    public String getJsonString() {
        String s = "{ $max: " + "\"" + "$"+ fieldName +"\""+  " }";
        if(newFieldName == null){
            return s;
        }
        else{
            return newFieldName + ": " + s;
        }
    }

    public static OperatorMax newOperatorMax(String fieldName){
        return new OperatorMax(fieldName);
    }

    public static OperatorMax newOperatorMax(String fieldName, String newfieldName){
        return new OperatorMax(fieldName, newfieldName);
    }

}
