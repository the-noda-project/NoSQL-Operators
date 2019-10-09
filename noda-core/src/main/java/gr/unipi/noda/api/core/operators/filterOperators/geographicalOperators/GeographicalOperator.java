package gr.unipi.noda.api.core.operators.filterOperators.geographicalOperators;

import gr.unipi.noda.api.core.operators.filterOperators.FilterOperator;

import java.util.function.Predicate;

public abstract class GeographicalOperator<T> implements FilterOperator<T> {

    private final String fieldName;
    private final Coordinates[] coordinatesArray;//Contains all the points for a shape. For example, the array contains three points if the shape is triangle.

    protected GeographicalOperator(String fieldName, Coordinates[] coordinatesArray) {
        this.fieldName = fieldName;
        this.coordinatesArray = coordinatesArray;
        checkCoordinates();
    }

    protected Coordinates[] getCoordinatesArray() {
        return coordinatesArray;
    }

    protected String getFieldName() {
        return fieldName;
    }

    protected void checkCoordinates() {

        for (Coordinates c : coordinatesArray) {
            if (longitudeOutOfRange.test(c.getLongitude()) || latitudeOutOfRange.test(c.getLatitude())) {
                try {
                    throw new Exception("Longitude - Latitude values are incorrect");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    Predicate<Double> longitudeOutOfRange = (longitude) -> ((Double.compare(longitude.doubleValue(), 180) == 1) || (Double.compare(longitude.doubleValue(), -180) == -1));
    Predicate<Double> latitudeOutOfRange = (latitude) -> ((Double.compare(latitude.doubleValue(), 90) == 1) || (Double.compare(latitude.doubleValue(), -90) == -1));

    public static BaseGeographicalOperatorFactory geographicalOperator;

}
