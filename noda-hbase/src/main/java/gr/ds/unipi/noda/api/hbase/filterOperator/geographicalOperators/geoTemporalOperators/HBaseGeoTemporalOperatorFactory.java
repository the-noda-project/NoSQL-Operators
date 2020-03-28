package gr.ds.unipi.noda.api.hbase.filterOperator.geographicalOperators.geoTemporalOperators;

import gr.ds.unipi.noda.api.core.operators.filterOperators.geographicalOperators.GeographicalOperator;
import gr.ds.unipi.noda.api.core.operators.filterOperators.geographicalOperators.geoTemporalOperators.BaseGeoTemporalOperatorFactory;
import gr.ds.unipi.noda.api.core.operators.filterOperators.geographicalOperators.geoTemporalOperators.temporal.TemporalBounds;
import gr.ds.unipi.noda.api.core.operators.filterOperators.geographicalOperators.geometries.Circle;
import gr.ds.unipi.noda.api.core.operators.filterOperators.geographicalOperators.geometries.Point;
import gr.ds.unipi.noda.api.core.operators.filterOperators.geographicalOperators.geometries.Polygon;
import gr.ds.unipi.noda.api.core.operators.filterOperators.geographicalOperators.geometries.Rectangle;

public final class HBaseGeoTemporalOperatorFactory extends BaseGeoTemporalOperatorFactory {
    @Override
    public GeographicalOperator newOperatorInGeoTemporalPolygon(String fieldName, Polygon polygon, String temporalFieldName, TemporalBounds temporalBounds) {
        return OperatorInGeoTemporalPolygon.newOperatorInGeoTemporalPolygon(fieldName, polygon, temporalFieldName, temporalBounds);
    }

    @Override
    public GeographicalOperator newOperatorInGeoTemporalRectangle(String fieldName, Rectangle rectangle, String temporalFieldName, TemporalBounds temporalBounds) {
        return OperatorInGeoTemporalRectangle.newOperatorInGeoTemporalRectangle(fieldName, rectangle, temporalFieldName, temporalBounds);
    }

    @Override
    public GeographicalOperator newOperatorInGeoTemporalCircleKm(String fieldName, Circle circle, String temporalFieldName, TemporalBounds temporalBounds) {
        return OperatorInGeoTemporalCircle.newOperatorInGeoTemporalCircle(fieldName, circle, temporalFieldName, temporalBounds);
    }

    @Override
    public GeographicalOperator newOperatorInGeoTemporalCircleMeters(String fieldName, Circle circle, String temporalFieldName, TemporalBounds temporalBounds) {
        return OperatorInGeoTemporalCircle.newOperatorInGeoTemporalCircle(fieldName, circle, temporalFieldName, temporalBounds);
    }

    @Override
    public GeographicalOperator newOperatorInGeoTemporalCircleMiles(String fieldName, Circle circle, String temporalFieldName, TemporalBounds temporalBounds) {
        return OperatorInGeoTemporalCircle.newOperatorInGeoTemporalCircle(fieldName, circle, temporalFieldName, temporalBounds);
    }

    @Override
    public GeographicalOperator newOperatorGeoTemporalNearestNeighbors(String fieldName, Point point, int neighbors) {
        return null;
    }
}
