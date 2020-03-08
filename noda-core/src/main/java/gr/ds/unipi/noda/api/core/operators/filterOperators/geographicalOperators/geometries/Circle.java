package gr.ds.unipi.noda.api.core.operators.filterOperators.geographicalOperators.geometries;

import gr.ds.unipi.noda.api.core.operators.filterOperators.geographicalOperators.Coordinates;

public class Circle extends Geometry {

    private final double radius;
    private Circle(Coordinates[] coordinatesArray, double radius) {
        super(coordinatesArray);
        this.radius = radius;
    }

    public static Circle newCircle(Coordinates coordinates, double radius){
        return new Circle(new Coordinates[]{coordinates}, radius);
    }

    public Coordinates getCircleCenter(){
        return getCoordinatesArray()[0];
    }

    public double getRadius() {
        return radius;
    }
}
