package com.github.unipi.trackandknow.nosqldbs.filterOperator.geographicalOperator;

public class OperatorInGeographicalCircle extends GeographicalOperatorBasedOnSinglePoint {

    private final double radius;//radius is in meters

    private OperatorInGeographicalCircle(String fieldName, Coordinates point, double radius) {
        super(fieldName, point);
        this.radius = radius;
    }

    public static OperatorInGeographicalCircle newOperatorInGeographicalCircle(String fieldName, Coordinates point, double radius) {
        return new OperatorInGeographicalCircle(fieldName, point, radius);
    }

    @Override
    int getNumberOfResultsForJsonStringBuilder() {
        return Integer.MAX_VALUE;
    }

    @Override
    double getRadiusForJsonStringBuilder() {
        return radius;
    }

//    @Override
//    public StringBuilder getJsonStringBuilder()
//    {
//
//        StringBuilder sb = new StringBuilder();
//        sb.append("{ ");
//
//        if(!getFieldName().contains(".")){
//            sb.append(getFieldName());
//        }
//        else{
//            sb.append("\"" + getFieldName() + "\"");
//        }
//
//        sb.append(": { $geoWithin : { $centerSphere : [ [");
//        sb.append(getLongitude());
//        sb.append(", ");
//        sb.append(getLatitude());
//        sb.append("], ");
//        sb.append(radius);
//        sb.append(" ] } } }");
//
//        return sb;
//    }
}


//package com.github.unipi.trackandknow.nosqldbs.filterOperator.geographicalOperator;
//
//public class OperatorInGeographicalRange implements GeographicalOperator {
//
//    private final String fieldName;
//    private final double longitude;
//    private final double latitude;
//    private final double radius;
//
//    @Override
//    public String getFieldName() {
//        return fieldName;
//    }
//
//    private OperatorInGeographicalRange(String fieldName, T longitude, T latitude, double radius) {
//        checkLonLatRange(longitude, latitude);
//        this.fieldName = fieldName;
//        this.longitude = longitude;
//        this.latitude = latitude;
//        this.radius = radius;
//    }
//
//    public static <T extends Number> OperatorInGeographicalRange newOperatorInGeographicalRange(String fieldName, T longitude, T latitude, double radius) {
//        return new OperatorInGeographicalRange(fieldName, longitude, latitude, radius);
//    }
//
//    @Override
//    public String getJsonString() {
//
//
//
//        return "{ " + ((!fieldName.contains(".")) ? fieldName : "\"" + fieldName + "\"") +
//                ": { $geoWithin : { $centerSphere : [ ["+longitude+", "+latitude+"], "+ radius +" ] } } }";
//    }
//
//
//}