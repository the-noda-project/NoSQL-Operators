package gr.ds.unipi.noda.api.core.operators.filterOperators.geographicalOperators.geometries;

import gr.ds.unipi.noda.api.core.operators.filterOperators.geographicalOperators.Coordinates;

public class Polygon extends Geometry {

    protected Polygon(Coordinates[] coordinatesArray) {
        super(coordinatesArray);
        checkCoordinates();
    }

    public static Polygon newPolygon(Coordinates coordinates1, Coordinates coordinates2, Coordinates coordinates3, Coordinates... coordinates){

        Coordinates[] coordinatesArray;

        if (coordinates.length == 0) {
            coordinatesArray = new Coordinates[]{coordinates1, coordinates2, coordinates3};
        } else {
            coordinatesArray = new Coordinates[coordinates.length + 3];
            coordinatesArray[0] = coordinates1;
            coordinatesArray[1] = coordinates2;
            coordinatesArray[2] = coordinates3;

            int i = 3;
            for (Coordinates coords : coordinates) {
                coordinatesArray[i++] = coords;
            }
        }

        return new Polygon(coordinatesArray);
    }

    @Override
    protected void checkCoordinates() {
        if (getCoordinatesArray().length < 3) {
            try {
                throw new Exception("Three points-coordinates should be defined at least for the formation of Polygon");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public boolean contains(Point point) {
        int i;
        int j;
        boolean result = false;
        for (i = 0, j = getCoordinatesArray().length - 1; i < getCoordinatesArray().length; j = i++) {
            if ((getCoordinatesArray()[i].getLatitude() > point.getPoint().getLatitude()) != (getCoordinatesArray()[j].getLatitude() > point.getPoint().getLatitude()) &&
                    (point.getPoint().getLongitude() < (getCoordinatesArray()[j].getLongitude() - getCoordinatesArray()[i].getLongitude()) * (point.getPoint().getLatitude() - getCoordinatesArray()[i].getLatitude()) / (getCoordinatesArray()[j].getLatitude()-getCoordinatesArray()[i].getLatitude()) + getCoordinatesArray()[i].getLongitude())) {
                result = !result;
            }
        }
        return result;
    }

    public Rectangle getMbr(){

        double minLon = Integer.MAX_VALUE;
        double minLat = Integer.MAX_VALUE;
        double maxLon = Integer.MIN_VALUE;
        double maxLat = Integer.MIN_VALUE;

        for(int i=0;i<getCoordinatesArray().length;i++){

            if(Double.compare(getCoordinatesArray()[i].getLongitude(), minLon) == -1){
                minLon = getCoordinatesArray()[i].getLongitude();
            }
            if(Double.compare(getCoordinatesArray()[i].getLatitude(), minLat) == -1){
                minLat = getCoordinatesArray()[i].getLatitude();
            }
            if(Double.compare(getCoordinatesArray()[i].getLongitude(), maxLon) == 1){
                maxLon = getCoordinatesArray()[i].getLongitude();
            }
            if(Double.compare(getCoordinatesArray()[i].getLatitude(), maxLat) == 1){
                maxLat = getCoordinatesArray()[i].getLatitude();
            }

        }

        return Rectangle.newRectangle(Coordinates.newCoordinates(minLon, minLat), Coordinates.newCoordinates(maxLon, maxLat));
    }

}
