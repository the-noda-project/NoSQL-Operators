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


}
