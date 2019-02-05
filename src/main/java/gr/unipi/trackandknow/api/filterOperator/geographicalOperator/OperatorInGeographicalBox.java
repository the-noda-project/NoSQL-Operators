package gr.unipi.trackandknow.api.filterOperator.geographicalOperator;

public class OperatorInGeographicalBox extends GeographicalOperatorBasedOnPoints {

    private final Coordinates lowerBound;
    private final Coordinates upperBound;

    public OperatorInGeographicalBox(String fieldName, Coordinates lowerBound, Coordinates upperBound) {

        super(fieldName, lowerBound, Coordinates.newCoordinates(upperBound.getLongitude(), lowerBound.getLatitude()), upperBound, Coordinates.newCoordinates(lowerBound.getLongitude(), upperBound.getLatitude()));
        this.lowerBound = lowerBound;
        this.upperBound = upperBound;
    }

    public static OperatorInGeographicalBox newOperatorInGeographicalBox(String fieldName, Coordinates lowerBound, Coordinates upperBound) {
        return new OperatorInGeographicalBox(fieldName, lowerBound, upperBound);
    }

}
