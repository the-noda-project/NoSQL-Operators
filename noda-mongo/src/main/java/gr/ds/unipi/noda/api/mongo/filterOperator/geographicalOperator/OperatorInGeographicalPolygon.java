package gr.ds.unipi.noda.api.mongo.filterOperator.geographicalOperator;

import gr.ds.unipi.noda.api.core.operators.filterOperators.geographicalOperators.Coordinates;

class OperatorInGeographicalPolygon extends GeographicalOperatorBasedOnPoints {

    private OperatorInGeographicalPolygon(String fieldName, Coordinates[] coordinates) {
        super(fieldName, coordinates);
    }

    public static OperatorInGeographicalPolygon newOperatorInGeographicalPolygon(String fieldName, Coordinates coordinates1, Coordinates coordinates2, Coordinates coordinates3, Coordinates... coordinates) {

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

        return new OperatorInGeographicalPolygon(fieldName, coordinatesArray);
    }

}
