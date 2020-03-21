package gr.ds.unipi.noda.api.core.operators.filterOperators.geographicalOperators.geometries;

import gr.ds.unipi.noda.api.core.operators.filterOperators.geographicalOperators.Coordinates;

public class Circle extends Geometry {

    public enum Unit {
        M(1),
        KM(1000),
        MI(1609.344),
        FT(3.280839895);
        public double metersEquivalent;

        Unit(double i) {
            this.metersEquivalent = i;
        }
    }

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