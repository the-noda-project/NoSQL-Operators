package com.github.unipi.trackandknow.nosqldbs.filterOperator.geographicalOperator;

public abstract class GeographicalOperatorBasedOnPoint extends GeographicalOperator {

    protected GeographicalOperatorBasedOnPoint(String fieldName, double longitude, double latitude){
        super(fieldName, Coordinates.newCoordinates(longitude, latitude));
    }

    protected double getLongitude(){
        return getCoordinatesArray()[0].getLongitude();
    }

    protected double getLatitude(){
        return getCoordinatesArray()[0].getLatitude();
    }
}
