package gr.ds.unipi.noda.api.core.operators.filterOperators.geographicalOperators.geometries;

import gr.ds.unipi.noda.api.core.operators.filterOperators.geographicalOperators.Coordinates;

public class Circle extends Geometry {

    private final double radius; //stored in meters unit
    private Circle(Coordinates[] coordinatesArray, double radius) {
        super(coordinatesArray);
        this.radius = radius;
    }

    public static Circle newCircleKm(Coordinates coordinates, double radius){
        return new Circle(new Coordinates[]{coordinates}, radius * 1000);
    }

    public static Circle newCircleMeters(Coordinates coordinates, double radius){
        return new Circle(new Coordinates[]{coordinates}, radius);
    }

    public static Circle newCircleMiles(Coordinates coordinates, double radius){
        return new Circle(new Coordinates[]{coordinates}, radius * 1609.344);
    }

    public Coordinates getCircleCenter(){
        return getCoordinatesArray()[0];
    }

    public double getRadius() {
        return radius;
    }
}
