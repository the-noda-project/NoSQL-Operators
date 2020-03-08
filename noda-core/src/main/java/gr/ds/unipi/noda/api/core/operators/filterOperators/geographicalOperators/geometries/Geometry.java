package gr.ds.unipi.noda.api.core.operators.filterOperators.geographicalOperators.geometries;

import gr.ds.unipi.noda.api.core.operators.filterOperators.geographicalOperators.Coordinates;

import java.util.function.Predicate;

public abstract class Geometry {

    private final Coordinates[] coordinatesArray;//Contains all the points for a shape. For example, the array contains three points if the shape is triangle.

    protected Geometry(Coordinates[] coordinatesArray) {
        checkCoordinates();
        this.coordinatesArray = coordinatesArray;
    }

    public Coordinates[] getCoordinatesArray() {
        return coordinatesArray;
    }

    private void checkCoordinates() {

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

}
