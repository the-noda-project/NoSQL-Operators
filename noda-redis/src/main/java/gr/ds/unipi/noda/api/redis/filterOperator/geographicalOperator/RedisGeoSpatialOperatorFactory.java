package gr.ds.unipi.noda.api.redis.filterOperator.geographicalOperator;

import gr.ds.unipi.noda.api.core.operators.filterOperators.FilterOperator;
import gr.ds.unipi.noda.api.core.operators.filterOperators.geographicalOperators.Coordinates;
import gr.ds.unipi.noda.api.core.operators.filterOperators.geographicalOperators.GeographicalOperator;
import gr.ds.unipi.noda.api.core.operators.filterOperators.geographicalOperators.geoSpatialOperators.BaseGeoSpatialOperatorFactory;

/**
 * @author adimo on 11/10/2019
 */
public class RedisGeoSpatialOperatorFactory extends BaseGeoSpatialOperatorFactory {
    @Override
    public GeographicalOperator newOperatorInGeoPolygon(String fieldName, Coordinates coordinates1, Coordinates coordinates2, Coordinates coordinates3, Coordinates... coordinates) {
        throw new UnsupportedOperationException("InGeoPolygon primitive is not supported");
    }

    @Override
    public GeographicalOperator newOperatorInGeoRectangle(String fieldName, Coordinates lowerBoundPoint, Coordinates upperBoundPoint) {
        throw new UnsupportedOperationException("InGeoRectangle primitive is not supported");
    }

    @Override
    public GeographicalOperator newOperatorInGeoCircleKm(String fieldName, Coordinates point, double radius) {
        return OperatorInGeographicalCircle.newOperatorInGeographicalCircle(fieldName, point, radius, GeographicalOperatorBasedOnSinglePoint.Unit.km);
    }

    @Override
    public GeographicalOperator newOperatorInGeoCircleMeters(String fieldName, Coordinates point, double radius) {
        return OperatorInGeographicalCircle.newOperatorInGeographicalCircle(fieldName, point, radius, GeographicalOperatorBasedOnSinglePoint.Unit.m);
    }

    @Override
    public GeographicalOperator newOperatorInGeoCircleMiles(String fieldName, Coordinates point, double radius) {
        return OperatorInGeographicalCircle.newOperatorInGeographicalCircle(fieldName, point, radius, GeographicalOperatorBasedOnSinglePoint.Unit.mi);
    }

    @Override
    public GeographicalOperator newOperatorGeoNearestNeighbors(String fieldName, Coordinates point, int neighborsCount) {
        return OperatorGeoNearestNeighbors.newOperatorGeoNearestNeighbors(fieldName, point, neighborsCount);
    }

    public static boolean isOperatorGeoNearestNeighbor(FilterOperator filterOperator) {
        return filterOperator instanceof OperatorGeoNearestNeighbors;
    }
}
