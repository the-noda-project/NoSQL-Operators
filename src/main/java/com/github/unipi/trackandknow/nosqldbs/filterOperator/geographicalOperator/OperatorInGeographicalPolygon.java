package com.github.unipi.trackandknow.nosqldbs.filterOperator.geographicalOperator;

public class OperatorInGeographicalPolygon extends GeographicalOperatorBasedOnPoints {

    private OperatorInGeographicalPolygon(String fieldName, Coordinates... coordinates) {
        super(fieldName, coordinates);

    }

    public static OperatorInGeographicalPolygon newOperatorInGeographicalPolygon(String fieldName, Coordinates... coordinates) {
        return new OperatorInGeographicalPolygon(fieldName, coordinates);
    }

    @Override
    protected void checkCoordinates() {
        super.checkCoordinates();

        if (getCoordinatesArray().length < 3) {
            try {
                throw new Exception("Three points-coordinates should be defined at least for Polygon formation");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
