package gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.geometries;

import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.Coordinates;

import java.util.Arrays;
import java.util.function.Predicate;

public abstract class Geometry {

    private final Coordinates[] coordinatesArray;//Contains all the points for a shape. For example, the array contains three points if the shape is triangle.

    protected Geometry(Coordinates[] coordinatesArray) {
        this.coordinatesArray = coordinatesArray;
        checkCoordinates();
    }

    public Coordinates[] getCoordinatesArray() {
        return coordinatesArray;
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

    public abstract Rectangle getMbr();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Geometry geometry = (Geometry) o;

        // Probably incorrect - comparing Object[] arrays with Arrays.equals
        return Arrays.equals(coordinatesArray, geometry.coordinatesArray);
    }

    @Override
    public int hashCode() {
        int result = Arrays.hashCode(coordinatesArray);
        result = 31 * result + getClass().hashCode();
        return result;
    }
}
