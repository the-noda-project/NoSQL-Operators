package gr.unipi.trackandknow.api.filterOperator.geographicalOperator;

public abstract class GeographicalOperatorBasedOnSinglePoint extends GeographicalOperator {

    protected GeographicalOperatorBasedOnSinglePoint(String fieldName, Coordinates point) {
        super(fieldName, point);
    }

    protected double getLongitude() {
        return getCoordinatesArray()[0].getLongitude();
    }

    protected double getLatitude() {
        return getCoordinatesArray()[0].getLatitude();
    }

    //abstract int getNumberOfResultsForJsonStringBuilder();

    //abstract double getRadiusForJsonStringBuilder();

}
