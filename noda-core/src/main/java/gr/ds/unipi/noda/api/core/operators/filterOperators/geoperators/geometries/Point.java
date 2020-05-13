package gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.geometries;

import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.Coordinates;

public class Point extends Geometry {

    private Point(Coordinates[] coordinatesArray) {
        super(coordinatesArray);
    }

    public static Point newPoint(Coordinates coordinates) {
        return new Point(new Coordinates[]{coordinates});
    }

    public Coordinates getPoint() {
        return getCoordinatesArray()[0];
    }

    public Rectangle getMbr() {
        return Rectangle.newRectangle(this.getPoint(), this.getPoint());
    }
}
