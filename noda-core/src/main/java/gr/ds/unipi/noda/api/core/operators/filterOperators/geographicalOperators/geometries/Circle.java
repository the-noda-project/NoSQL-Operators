package gr.ds.unipi.noda.api.core.operators.filterOperators.geographicalOperators.geometries;

import gr.ds.unipi.noda.api.core.operators.filterOperators.geographicalOperators.Coordinates;

public class Circle extends Geometry {

    private final double radius; //stored in meters unit
    private final Unit unit;

    private Circle(Coordinates[] coordinatesArray, double radius, Unit unit) {
        super(coordinatesArray);
        this.radius = radius;
        this.unit = unit;
    }

    public static Circle newCircle(Coordinates coordinates, double radius, Unit unit) {
        return new Circle(new Coordinates[]{coordinates}, radius, unit);
    }

    public Coordinates getCircleCenter() {
        return getCoordinatesArray()[0];
    }

    public double getRadius() {
        return radius;
    }

    public double getRadiusInUnit() {
        return radius * unit.metersEquivalent;
    }

    public Unit getUnit() {
        return unit;
    }
}