package com.github.unipi.trackandknow.nosqldbs.filterOperator.geographicalOperator;

public class OperatorNearestNeighbors extends GeographicalOperatorBasedOnPoint {

    private final int neighbors;

    private OperatorNearestNeighbors(String fieldName, double longitude, double latitude, int neighbors) {

        super(fieldName, longitude, latitude);
        this.neighbors = neighbors;
    }

    public static OperatorNearestNeighbors newOperatorNearestNeighbors(String fieldName, double longitude, double latitude, int neighbors) {
        return new OperatorNearestNeighbors(fieldName, longitude, latitude, neighbors);
    }

    @Override
    public StringBuilder getJsonStringBuilder() {



        return "{ $geoNear: { near: {type: \"Point\", coordinates: ["+getLongitude()+", "+getLatitude()+"]}," +
                "key: "+ ((!getFieldName().contains(".")) ? getFieldName() : "\"" + getFieldName() + "\"") +" ," +
                "maxDistance: "+ +"," + "num: "+ neighbors+" ," + "distanceField: \"distance\" ," + "spherical: true" + "} }";

    }
}
