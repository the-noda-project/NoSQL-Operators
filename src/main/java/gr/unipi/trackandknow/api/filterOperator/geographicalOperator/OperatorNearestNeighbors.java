package gr.unipi.trackandknow.api.filterOperator.geographicalOperator;

public class OperatorNearestNeighbors extends GeographicalOperatorBasedOnSinglePoint {

    private final int neighbors;

    private OperatorNearestNeighbors(String fieldName, Coordinates point, int neighbors) {
        super(fieldName, point);
        this.neighbors = neighbors;
    }

    public static OperatorNearestNeighbors newOperatorNearestNeighbors(String fieldName, Coordinates point, int neighbors) {
        return new OperatorNearestNeighbors(fieldName, point, neighbors);
    }

    @Override
    int getNumberOfResultsForJsonStringBuilder() {
        return neighbors;
    }

    @Override
    double getRadiusForJsonStringBuilder() {
        return 5;
    }

}
