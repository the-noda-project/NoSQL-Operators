package gr.unipi.noda.api.core.operators.filterOperators.geographicalOperators;

public abstract class BaseGeographicalOperatorFactory {

    public abstract GeographicalOperator newOperatorInGeoPolygon(String fieldName, Coordinates coordinates1, Coordinates coordinates2, Coordinates coordinates3, Coordinates... coordinates);

    public abstract GeographicalOperator newOperatorInGeoBox(String fieldName, Coordinates lowerBoundPoint, Coordinates upperBoundPoint);

    public abstract GeographicalOperator newOperatorInGeoCircleKm(String fieldName, Coordinates point, double radius);

    public abstract GeographicalOperator newOperatorInGeoCircleMeters(String fieldName, Coordinates point, double radius);

    public abstract GeographicalOperator newOperatorInGeoCircleMiles(String fieldName, Coordinates point, double radius);

    public abstract GeographicalOperator newOperatorNearestNeighbors(String fieldName, Coordinates point, int neighbors);

}
