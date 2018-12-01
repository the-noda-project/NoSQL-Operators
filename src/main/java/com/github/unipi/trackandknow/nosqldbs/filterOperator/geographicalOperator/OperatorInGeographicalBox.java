package com.github.unipi.trackandknow.nosqldbs.filterOperator.geographicalOperator;

public class OperatorInGeographicalBox extends GeographicalOperatorBasedOnShape {

    private final double lowerLongitude;
    private final double lowerLatitude;
    private final double upperLongitude;
    private final double upperLatitude;

    private OperatorInGeographicalBox(String fieldName, double lowerLongitude, double lowerLatitude, double upperLongitude, double upperLatitude) {
        super(fieldName, Coordinates.newCoordinates(lowerLongitude, lowerLatitude),Coordinates.newCoordinates(upperLongitude, lowerLatitude),Coordinates.newCoordinates(upperLongitude, upperLatitude),Coordinates.newCoordinates(lowerLongitude, upperLatitude),Coordinates.newCoordinates(lowerLongitude, lowerLatitude ));
        this.lowerLongitude = lowerLongitude;
        this.lowerLatitude = lowerLatitude;
        this.upperLongitude = upperLongitude;
        this.upperLatitude = upperLatitude;
    }

    public static OperatorInGeographicalBox newOperatorInGeographicalBox(String fieldName, double lowerLongitude, double lowerLatitude, double upperLongitude, double upperLatitude){
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
