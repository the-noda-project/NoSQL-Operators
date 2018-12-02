package com.github.unipi.trackandknow.nosqldbs.filterOperator.geographicalOperator;

public class Coordinates<T> {

    private final T longitude;
    private final T latitude;

    private Coordinates(T longitude, T latitude) {
        this.longitude = longitude;
        this.latitude = latitude;
    }

    public static Coordinates<Float> newCoordinates( Float longitude, Float latitude) {
        return new Coordinates(longitude, latitude);
    }

    public static Coordinates<Double> newCoordinates( Double longitude, Double latitude) {
        return new Coordinates(longitude, latitude);
    }


    public T getLongitude() {
        return longitude;
    }

    public T getLatitude() {
        return latitude;
    }


}
