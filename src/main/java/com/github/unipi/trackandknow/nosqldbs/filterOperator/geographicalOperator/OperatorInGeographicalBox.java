package com.github.unipi.trackandknow.nosqldbs.filterOperator.geographicalOperator;

public class OperatorInGeographicalBox<Τ> extends GeographicalOperatorBasedOnShape {

    private final Τ lowerLongitude;
    private final Τ lowerLatitude;
    private final Τ upperLongitude;
    private final Τ upperLatitude;

    public OperatorInGeographicalBox(String fieldName, Τ lowerLongitude, Τ lowerLatitude, Τ upperLongitude, Τ upperLatitude) {
        super(fieldName, Coordinates.newCoordinates(lowerLongitude, lowerLatitude),Coordinates.newCoordinates(upperLongitude, lowerLatitude),Coordinates.newCoordinates(upperLongitude, upperLatitude),Coordinates.newCoordinates(lowerLongitude, upperLatitude),Coordinates.newCoordinates(lowerLongitude, lowerLatitude ));
        this.lowerLongitude = lowerLongitude;
        this.lowerLatitude = lowerLatitude;
        this.upperLongitude = upperLongitude;
        this.upperLatitude = upperLatitude;
    }


    public static OperatorInGeographicalBox<Float> newOperatorInGeographicalBox(String fieldName, Float lowerLongitude, Float lowerLatitude, Float upperLongitude, Float upperLatitude){
        return new OperatorInGeographicalBox(fieldName, lowerLongitude, lowerLatitude, upperLongitude, upperLatitude);
    }

    public static OperatorInGeographicalBox<Double> newOperatorInGeographicalBox(String fieldName, Double lowerLongitude, Double lowerLatitude, Double upperLongitude, Double upperLatitude){
        return new OperatorInGeographicalBox(fieldName, lowerLongitude, lowerLatitude, upperLongitude, upperLatitude);
    }


//    @Override
//    public String getFieldName() {
//        return fieldName;
//    }
//
//    private OperatorInGeographicalBox(String fieldName, T lowerLongitude, T lowerLatitude, T upperLongitude, T upperLatitude) {
//
//        checkLonLatRange(lowerLongitude, lowerLatitude);
//        checkLonLatRange(upperLongitude, upperLatitude);
//        this.fieldName = fieldName;
//        this.lowerLongitude = lowerLongitude;
//        this.lowerLatitude = lowerLatitude;
//        this.upperLongitude = upperLongitude;
//        this.upperLatitude = upperLatitude;
//
//    }
//
//    public static <T extends Number> OperatorInGeographicalBox newOperatorInGeographicalBox(String fieldName, T lowerLongitude, T lowerLatitude, T upperLongitude, T upperLatitude) {
//        return new OperatorInGeographicalBox(fieldName, lowerLongitude, lowerLatitude, upperLongitude, upperLatitude);
//    }
//
//    @Override
//    public StringBuilder getJsonStringBuilder() {
//        return OperatorInGeographicalPolygon.newOperatorInGeographicalPolygon(fieldName, Coordinates.newCoordinates(lowerLongitude, lowerLatitude), Coordinates.newCoordinates(upperLongitude,lowerLatitude), Coordinates.newCoordinates(upperLongitude, upperLatitude), Coordinates.newCoordinates(lowerLongitude, upperLatitude), Coordinates.newCoordinates(lowerLongitude,lowerLatitude)).getJsonStringBuilder();
//
////        return "{ " + ((!fieldName.contains(".")) ? fieldName : "\"" + fieldName + "\"") +
////                ": { $geoWithin: { $geometry: { type:\"Polygon\", coordinates:[ [ ["+lowerLongitude+", "+lowerLatitude+"], ["+upperLongitude+", "+lowerLatitude+"], ["+upperLongitude+", "+upperLatitude+"], ["+lowerLongitude+", "+upperLatitude+"],["+lowerLongitude+", "+lowerLatitude+"] ] ] } } } }";
//    }


}
