package com.github.unipi.trackandknow.nosqldbs.filterOperator.geographicalOperator;

public abstract class GeographicalOperatorBasedOnSinglePoint extends GeographicalOperator {

    protected GeographicalOperatorBasedOnSinglePoint(String fieldName, Coordinates point){
        super(fieldName, point);
    }

    protected double getLongitude(){
        return getCoordinatesArray()[0].getLongitude();
    }

    protected double getLatitude(){
        return getCoordinatesArray()[0].getLatitude();
    }

    abstract int getNumberOfResultsForJsonStringBuilder();
    abstract double getRadiusForJsonStringBuilder();

    @Override
    public StringBuilder getJsonStringBuilder() {

        StringBuilder sb = new StringBuilder();
        sb.append("{ $geoNear: { near: {type: \"Point\", coordinates: ["+getLongitude()+", "+getLatitude()+"]}," +
                //"key: "+ ((!getFieldName().contains(".")) ? getFieldName() : "\"" + getFieldName() + "\"") +" ," +
                "key: "+ "\"" + getFieldName() + "\"" +" ," +

                "maxDistance: "+ getRadiusForJsonStringBuilder() +"," + "num: "+ getNumberOfResultsForJsonStringBuilder() + " ," + "distanceField: \"distance\" ," + "spherical: true" + "} }");

        return sb;

    }
}
