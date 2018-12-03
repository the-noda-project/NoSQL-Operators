package com.github.unipi.trackandknow.nosqldbs.filterOperator.geographicalOperator;

public abstract class GeographicalOperatorBasedOnPoint extends GeographicalOperator {

    protected GeographicalOperatorBasedOnPoint(String fieldName, Coordinates point){
        super(fieldName, point);
    }

    protected double getLongitude(){
        return getCoordinatesArray()[0].getLongitude();
    }

    protected double getLatitude(){
        return getCoordinatesArray()[0].getLatitude();
    }
}
