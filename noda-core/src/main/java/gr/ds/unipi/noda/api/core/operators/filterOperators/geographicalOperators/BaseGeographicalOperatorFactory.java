package gr.ds.unipi.noda.api.core.operators.filterOperators.geographicalOperators;

public abstract class BaseGeographicalOperatorFactory {

    public abstract GeographicalOperator newOperatorInGeoPolygon(String fieldName, Coordinates coordinates1, Coordinates coordinates2, Coordinates coordinates3, Coordinates... coordinates);

    public abstract GeographicalOperator newOperatorInGeoRectangle(String fieldName, Coordinates lowerBoundPoint, Coordinates upperBoundPoint);

    public abstract GeographicalOperator newOperatorInGeoCircleKm(String fieldName, Coordinates point, double radius);

    public abstract GeographicalOperator newOperatorInGeoCircleMeters(String fieldName, Coordinates point, double radius);

    public abstract GeographicalOperator newOperatorInGeoCircleMiles(String fieldName, Coordinates point, double radius);

    public abstract GeographicalOperator newOperatorGeoNearestNeighbors(String fieldName, Coordinates point, int neighbors);

}
