package com.github.unipi.trackandknow.nosqldbs.filterOperator.geographicalOperator;

public class OperatorInGeographicalCircle extends GeographicalOperatorBasedOnPoint {

    private final double radius;

    private OperatorInGeographicalCircle(String fieldName, Coordinates point, double radius) {
        super(fieldName, point);
        this.radius = radius;
    }

    public static OperatorInGeographicalCircle newOperatorInGeographicalCircle(String fieldName, Coordinates point, double radius){
        return new OperatorInGeographicalCircle(fieldName, point, radius);
    }

    @Override
    public StringBuilder getJsonStringBuilder()
    {

        StringBuilder sb = new StringBuilder();
        sb.append("{ ");

        if(!getFieldName().contains(".")){
            sb.append(getFieldName());
        }
        else{
            sb.append("\"" + getFieldName() + "\"");
        }

        sb.append(": { $geoWithin : { $centerSphere : [ [");
        sb.append(getLongitude());
        sb.append(", ");
        sb.append(getLatitude());
        sb.append("], ");
        sb.append(radius);
        sb.append(" ] } } }");

        return sb;
    }
}
