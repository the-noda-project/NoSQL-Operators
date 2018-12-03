package com.github.unipi.trackandknow.nosqldbs.filterOperator.geographicalOperator;

public class OperatorInGeographicalBox extends GeographicalOperatorBasedOnShape {

    private final Coordinates lowerBound;
    private final Coordinates upperBound;

    public OperatorInGeographicalBox(String fieldName, Coordinates lowerBound, Coordinates upperBound) {

        super(fieldName, lowerBound,Coordinates.newCoordinates(upperBound.getLongitude(), lowerBound.getLatitude()),upperBound,Coordinates.newCoordinates(lowerBound.getLongitude(), upperBound.getLatitude()));
        this.lowerBound = lowerBound;
        this.upperBound = upperBound;
    }

    public static OperatorInGeographicalBox newOperatorInGeographicalBox(String fieldName, Coordinates lowerBound, Coordinates upperBound){
        return new OperatorInGeographicalBox(fieldName, lowerBound, upperBound);
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
