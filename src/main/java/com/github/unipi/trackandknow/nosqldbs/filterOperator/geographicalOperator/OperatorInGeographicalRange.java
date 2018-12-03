package com.github.unipi.trackandknow.nosqldbs.filterOperator.geographicalOperator;

public class OperatorInGeographicalRange implements GeographicalOperator {

    private final String fieldName;
    private final double longitude;
    private final double latitude;
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
