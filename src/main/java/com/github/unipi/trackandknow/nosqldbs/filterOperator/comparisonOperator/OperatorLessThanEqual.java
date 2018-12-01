package com.github.unipi.trackandknow.nosqldbs.filterOperator.comparisonOperator;

public class OperatorLessThanEqual<T extends Number> extends ComparisonOperator<T> {

    private OperatorLessThanEqual(String fieldName, T fieldValue) {

        super(fieldName, fieldValue);
    }

    @Override
    protected String getOperatorJsonField() {
        return "lte";
    }

    public static <T extends Number> OperatorLessThanEqual newOperatorLessThanEqual(String fieldName, T fieldValue) {
        return new OperatorLessThanEqual(fieldName, fieldValue);
    }

//    @Override
//    public StringBuilder getJsonString() {
//        return "{ " + ((!fieldName.contains(".")) ? fieldName : "\"" + fieldName + "\"") +
//                ": { $lte: " + fieldValue + " } }";
//    }

}
