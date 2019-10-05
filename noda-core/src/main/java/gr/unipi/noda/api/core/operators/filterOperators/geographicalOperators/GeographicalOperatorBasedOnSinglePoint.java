package gr.unipi.noda.api.core.operators.filterOperators.geographicalOperators;

public abstract class GeographicalOperatorBasedOnSinglePoint<T> extends GeographicalOperator<T> {

    protected GeographicalOperatorBasedOnSinglePoint(String fieldName, Coordinates point) {
        super(fieldName, new Coordinates[]{point});
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
