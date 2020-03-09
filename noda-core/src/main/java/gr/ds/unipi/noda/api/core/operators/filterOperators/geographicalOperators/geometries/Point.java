package gr.ds.unipi.noda.api.core.operators.filterOperators.geographicalOperators.geometries;

import gr.ds.unipi.noda.api.core.operators.filterOperators.geographicalOperators.Coordinates;

public class Point extends Geometry {

    private Point(Coordinates[] coordinatesArray) {
        super(coordinatesArray);
    }

    public static Point newPoint(Coordinates coordinates){
        return new Point(new Coordinates[]{coordinates});
    }

    public Coordinates getPoint(){
        return getCoordinatesArray()[0];
    }
}
