package gr.unipi.trackandknow.api.filterOperator.geographicalOperator;

public class OperatorInGeographicalCircle extends GeographicalOperatorBasedOnSinglePoint {

    private final double radius;//radius is in meters

    private OperatorInGeographicalCircle(String fieldName, Coordinates point, double radius) {
        super(fieldName, point);
        this.radius = radius;
    }

    public static OperatorInGeographicalCircle newOperatorInGeographicalCircle(String fieldName, Coordinates point, double radius) {
        return new OperatorInGeographicalCircle(fieldName, point, radius);
    }

    @Override
    int getNumberOfResultsForJsonStringBuilder() {
        return Integer.MAX_VALUE;
    }

    @Override
    double getRadiusForJsonStringBuilder() {
        return radius;
    }

}