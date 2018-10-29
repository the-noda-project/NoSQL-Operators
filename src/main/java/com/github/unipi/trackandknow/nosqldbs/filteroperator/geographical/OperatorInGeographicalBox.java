package com.github.unipi.trackandknow.nosqldbs.filteroperator.geographical;

public class OperatorInGeographicalBox<T extends Number> implements GeographicalOperator<T> {

    private final String fieldName;
    private final T lowerLongitude;
    private final T lowerLatitude;
    private final T upperLongitude;
    private final T upperLatitude;

    @Override
    public String getFieldName() {
        return fieldName;
    }

    private OperatorInGeographicalBox(String fieldName, T lowerLongitude, T lowerLatitude, T upperLongitude, T upperLatitude) {
        checkLonLatRange(lowerLongitude, lowerLatitude, upperLongitude, upperLatitude);
        this.fieldName = fieldName;
        this.lowerLongitude = lowerLongitude;
        this.lowerLatitude = lowerLatitude;
        this.upperLongitude = upperLongitude;
        this.upperLatitude = upperLatitude;

    }

    public static <T extends Number> OperatorInGeographicalBox newOperatorInGeographicalBox(String fieldName, T lowerLongitude, T lowerLatitude, T upperLongitude, T upperLatitude) {
        return new OperatorInGeographicalBox(fieldName, lowerLongitude, lowerLatitude, upperLongitude, upperLatitude);
    }

    @Override
    public String getJsonString() {

        return "{ " + ((!fieldName.contains(".")) ? fieldName : "\"" + fieldName + "\"") +
                ": { $geoWithin: { $polygon: [ ["+lowerLongitude+", "+lowerLatitude+"], ["+upperLongitude+", "+lowerLatitude+"], ["+upperLongitude+", "+upperLatitude+"], ["+lowerLongitude+", "+upperLatitude+"] ]} } }";
    }

}
