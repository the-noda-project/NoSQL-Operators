package gr.unipi.noda.api.core.operators.filterOperators.geographicalOperators;

public abstract class GeographicalOperatorBasedOnPoints<T> extends GeographicalOperator<T> {

    protected GeographicalOperatorBasedOnPoints(String fieldName, Coordinates[] coordinates) {

//        Coordinates[] coordinatesArray;
//
//        if (coordinates.length == 0) {
//            coordinatesArray = new Coordinates[]{coordinates2, coordinates3};
//        } else {
//            coordinatesArray = new Coordinates[coordinates.length + 2];
//            coordinatesArray[0] = coordinates2;
//            coordinatesArray[1] = coordinates3;
//
//            int i = 2;
//            for (Coordinates coords : coordinates) {
//                coordinatesArray[i++] = coords;
//            }
//        }

        super(fieldName, coordinates);
        checkCoordinates();
    }

    @Override
    protected void checkCoordinates() {
        if (getCoordinatesArray().length < 3) {
            try {
                throw new Exception("Three points-coordinates should be defined at least for the formation of GeographicalOperatorBasedOnPoints Operator");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
