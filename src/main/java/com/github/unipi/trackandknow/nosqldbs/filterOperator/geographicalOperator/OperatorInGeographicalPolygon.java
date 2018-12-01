package com.github.unipi.trackandknow.nosqldbs.filterOperator.geographicalOperator;

public class OperatorInGeographicalPolygon extends GeographicalOperatorBasedOnShape {

    private OperatorInGeographicalPolygon(String fieldName, Coordinates... coordinates) {
        super(fieldName, coordinates);
    }

    public static OperatorInGeographicalPolygon newOperatorInGeographicalPolygon(String fieldName, Coordinates...  coordinates) {
        return new OperatorInGeographicalPolygon(fieldName, coordinates);
    }

}
