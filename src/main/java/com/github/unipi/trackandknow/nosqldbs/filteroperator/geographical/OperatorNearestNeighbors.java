package com.github.unipi.trackandknow.nosqldbs.filteroperator.geographical;

public class OperatorNearestNeighbors<T extends Number>  implements GeographicalOperator<T> {

    private final String fieldName;
    private final T longitude;
    private final T latitude;
    private final int neighbors;

    private OperatorNearestNeighbors(String fieldName, T longitude, T latitude, int neighbors) {
        checkLonLatRange(longitude, latitude);
        this.fieldName = fieldName;
        this.longitude = longitude;
        this.latitude = latitude;
        this.neighbors = neighbors;
    }

    public static <T extends Number> OperatorNearestNeighbors newOperatorNearestNeighbors(String fieldName, T longitude, T latitude, int neighbors) {
        return new OperatorNearestNeighbors(fieldName, longitude, latitude, neighbors);
    }

    @Override
    public String getFieldName() {
        return fieldName;
    }

    @Override
    public String getJsonString() {

        return "{ $geoNear: { near: {type: \"Point\", coordinates: ["+longitude+", "+latitude+"]}," +
                "key: "+ ((!fieldName.contains(".")) ? fieldName : "\"" + fieldName + "\"") +" ," +
                "maxDistance: "+ +"," + "num: "+ neighbors+" ," + "distanceField: \"distance\" ," + "spherical: true" + "} }";


        return "{ " + ((!fieldName.contains(".")) ? fieldName : "\"" + fieldName + "\"") +
                ": { $geoWithin : { $centerSphere : [ ["+longitude+", "+latitude+"], "+ radius +" ] } } }";
    }
}
