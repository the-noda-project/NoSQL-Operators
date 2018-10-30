package com.github.unipi.trackandknow.nosqldbs.filteroperator.geographical;

public class OperatorInGeographicalRange<T extends Number> implements GeographicalOperator<T> {

    private final String fieldName;
    private final T longitude;
    private final T latitude;
    private final double radius;

    @Override
    public String getFieldName() {
        return fieldName;
    }

    private OperatorInGeographicalRange(String fieldName, T longitude, T latitude, double radius) {
        checkLonLatRange(longitude, latitude);
        this.fieldName = fieldName;
        this.longitude = longitude;
        this.latitude = latitude;
        this.radius = radius;
    }

    public static <T extends Number> OperatorInGeographicalRange newOperatorInGeographicalRange(String fieldName, T longitude, T latitude, double radius) {
        return new OperatorInGeographicalRange(fieldName, longitude, latitude, radius);
    }

    @Override
    public String getJsonString() {

        return "{ " + ((!fieldName.contains(".")) ? fieldName : "\"" + fieldName + "\"") +
                ": { $geoWithin : { $centerSphere : [ ["+longitude+", "+latitude+"], "+ radius +" ] } } }";
    }


}
