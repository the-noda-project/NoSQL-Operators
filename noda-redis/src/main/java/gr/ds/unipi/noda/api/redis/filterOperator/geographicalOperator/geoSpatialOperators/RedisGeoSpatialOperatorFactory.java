package gr.ds.unipi.noda.api.redis.filterOperator.geographicalOperator.geoSpatialOperators;

import gr.ds.unipi.noda.api.core.operators.filterOperators.FilterOperator;
import gr.ds.unipi.noda.api.core.operators.filterOperators.geographicalOperators.GeographicalOperator;
import gr.ds.unipi.noda.api.core.operators.filterOperators.geographicalOperators.geoSpatialOperators.BaseGeoSpatialOperatorFactory;
import gr.ds.unipi.noda.api.core.operators.filterOperators.geographicalOperators.geometries.Circle;
import gr.ds.unipi.noda.api.core.operators.filterOperators.geographicalOperators.geometries.Point;
import gr.ds.unipi.noda.api.core.operators.filterOperators.geographicalOperators.geometries.Polygon;
import gr.ds.unipi.noda.api.core.operators.filterOperators.geographicalOperators.geometries.Rectangle;

/**
 * @author adimo on 11/10/2019
 */
public class RedisGeoSpatialOperatorFactory extends BaseGeoSpatialOperatorFactory {
    @Override
    public GeographicalOperator newOperatorInGeoPolygon(String fieldName, Polygon polygon) {
        throw new UnsupportedOperationException("InGeoPolygon primitive is not supported");
    }

    @Override
    public GeographicalOperator newOperatorInGeoRectangle(String fieldName, Rectangle rectangle) {
        return OperatorInGeographicalRectangle.newOperatorInGeographicalRectangle(fieldName, rectangle);
    }

    @Override
    public GeographicalOperator newOperatorInGeoCircleKm(String fieldName, Circle circle) {
        return OperatorInGeographicalCircle.newOperatorInGeographicalCircle(fieldName, circle);
    }

    @Override
    public GeographicalOperator newOperatorInGeoCircleMeters(String fieldName, Circle circle) {
        return OperatorInGeographicalCircle.newOperatorInGeographicalCircle(fieldName, circle);
    }

    @Override
    public GeographicalOperator newOperatorInGeoCircleMiles(String fieldName, Circle circle) {
        return OperatorInGeographicalCircle.newOperatorInGeographicalCircle(fieldName, circle);
    }

    @Override
    public GeographicalOperator newOperatorGeoNearestNeighbors(String fieldName, Point point, int neighbors) {
        return OperatorGeoNearestNeighbors.newOperatorGeoNearestNeighbors(fieldName, point, neighbors);
    }

    public static boolean isOperatorGeoNearestNeighbor(FilterOperator filterOperator) {
        return filterOperator instanceof OperatorGeoNearestNeighbors;
    }

    public static boolean isOperatorGeoBox(FilterOperator filterOperator) {
        return filterOperator instanceof OperatorInGeographicalRectangle;
    }
}
