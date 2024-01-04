package gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.geometries;

import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.Coordinates;

public class LineString extends Geometry {

    private final Rectangle mbr;
    private LineString(Coordinates[] coordinatesArray) {
        super(coordinatesArray);

        double minLongitude = Double.MAX_VALUE;
        double minLatitude = Double.MAX_VALUE;
        double maxLongitude = Double.MIN_VALUE;
        double maxLatitude = Double.MIN_VALUE;

        for (Coordinates coordinates : coordinatesArray) {
            if(Double.compare(coordinates.getLongitude(),minLongitude)==-1){
                minLongitude = coordinates.getLongitude();
            }

            if(Double.compare(coordinates.getLatitude(),minLatitude)==-1){
                minLatitude = coordinates.getLatitude();
            }

            if(Double.compare(coordinates.getLongitude(),maxLongitude)==1){
                maxLongitude = coordinates.getLongitude();
            }

            if(Double.compare(coordinates.getLatitude(),maxLatitude)==1){
                maxLatitude = coordinates.getLatitude();
            }

        }

        mbr = Rectangle.newRectangle(Coordinates.newCoordinates(minLongitude, minLatitude), Coordinates.newCoordinates(maxLongitude,maxLatitude));
    }

    @Override
    public Rectangle getMbr() {
        return mbr;
    }

    public static LineString newLineString(Coordinates coordinates) {
        return new LineString(new Coordinates[]{coordinates});
    }
}
