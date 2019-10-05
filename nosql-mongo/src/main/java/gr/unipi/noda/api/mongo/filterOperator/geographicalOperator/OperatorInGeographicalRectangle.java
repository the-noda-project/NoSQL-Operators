package gr.unipi.noda.api.mongo.filterOperator.geographicalOperator;

import gr.unipi.noda.api.core.operators.filterOperators.geographicalOperators.Coordinates;

public class OperatorInGeographicalRectangle extends GeographicalOperatorBasedOnPoints {

    public OperatorInGeographicalRectangle(String fieldName, Coordinates lowerBound, Coordinates upperBound) {
        super(fieldName, new Coordinates[]{lowerBound, Coordinates.newCoordinates(upperBound.getLongitude(), lowerBound.getLatitude()), upperBound, Coordinates.newCoordinates(lowerBound.getLongitude(), upperBound.getLatitude())});
    }

    public static OperatorInGeographicalRectangle newOperatorInGeographicalBox(String fieldName, Coordinates lowerBound, Coordinates upperBound) {
        return new OperatorInGeographicalRectangle(fieldName, lowerBound, upperBound);
    }

}
