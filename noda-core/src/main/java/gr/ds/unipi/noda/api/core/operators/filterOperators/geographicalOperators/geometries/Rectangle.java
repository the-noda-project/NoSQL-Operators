package gr.ds.unipi.noda.api.core.operators.filterOperators.geographicalOperators.geometries;

import gr.ds.unipi.noda.api.core.operators.filterOperators.geographicalOperators.Coordinates;

public class Rectangle extends Geometry {

    private Rectangle(Coordinates lowerBound, Coordinates upperBound) {
        super(new Coordinates[]{lowerBound, Coordinates.newCoordinates(upperBound.getLongitude(), lowerBound.getLatitude()), upperBound, Coordinates.newCoordinates(lowerBound.getLongitude(), upperBound.getLatitude())});
    }

    public static Rectangle newRectangle(Coordinates lowerBound, Coordinates upperBound){
        return new Rectangle(lowerBound, upperBound);
    }

    public Coordinates getLowerBound() {
        return getCoordinatesArray()[0];
    }

    public Coordinates getUpperBound() {
        return getCoordinatesArray()[2];
    }
}
