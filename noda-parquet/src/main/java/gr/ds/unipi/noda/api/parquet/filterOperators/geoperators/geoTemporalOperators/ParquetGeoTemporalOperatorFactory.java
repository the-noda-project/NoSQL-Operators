package gr.ds.unipi.noda.api.parquet.filterOperators.geoperators.geoTemporalOperators;

import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.geoTemporalOperators.BaseGeoTemporalOperatorFactory;
import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.geoTemporalOperators.temporal.TemporalBounds;
import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.geometries.Circle;
import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.geometries.Point;
import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.geometries.Polygon;
import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.geometries.Rectangle;

public final class ParquetGeoTemporalOperatorFactory extends BaseGeoTemporalOperatorFactory {
    @Override
    public GeoTemporalOperator newOperatorInGeoTemporalPolygon(String fieldName, Polygon polygon, String temporalFieldName, TemporalBounds temporalBounds) {
        return OperatorInGeoTemporalPolygon.newOperatorInGeoTemporalPolygon(fieldName, polygon, temporalFieldName, temporalBounds);
    }

    @Override
    public GeoTemporalOperator newOperatorInGeoTemporalRectangle(String fieldName, Rectangle rectangle, String temporalFieldName, TemporalBounds temporalBounds) {
        return OperatorInGeoTemporalRectangle.newOperatorInGeoTemporalRectangle(fieldName, rectangle, temporalFieldName, temporalBounds);
    }

    @Override
    public GeoTemporalOperator newOperatorInGeoTemporalCircleKm(String fieldName, Circle circle, String temporalFieldName, TemporalBounds temporalBounds) {
        return OperatorInGeoTemporalCircle.newOperatorInGeoTemporalCircle(fieldName, circle, temporalFieldName, temporalBounds);
    }

    @Override
    public GeoTemporalOperator newOperatorInGeoTemporalCircleMeters(String fieldName, Circle circle, String temporalFieldName, TemporalBounds temporalBounds) {
        return OperatorInGeoTemporalCircle.newOperatorInGeoTemporalCircle(fieldName, circle, temporalFieldName, temporalBounds);
    }

    @Override
    public GeoTemporalOperator newOperatorInGeoTemporalCircleMiles(String fieldName, Circle circle, String temporalFieldName, TemporalBounds temporalBounds) {
        return OperatorInGeoTemporalCircle.newOperatorInGeoTemporalCircle(fieldName, circle, temporalFieldName, temporalBounds);
    }

    @Override
    public GeoTemporalOperator newOperatorGeoTemporalNearestNeighbors(String fieldName, Point point, int neighbors) {
        return null;
    }
}
