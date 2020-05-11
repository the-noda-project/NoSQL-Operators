package gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.geoTemporalOperators;

import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.geographicalOperators.GeographicalOperator;
import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.geoTemporalOperators.temporal.TemporalBounds;
import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.geometries.Circle;
import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.geometries.Point;
import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.geometries.Polygon;
import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.geometries.Rectangle;

public abstract class BaseGeoTemporalOperatorFactory {

    public abstract GeoTemporalOperator newOperatorInGeoTemporalPolygon(String fieldName, Polygon polygon, String temporalFieldName, TemporalBounds temporalBounds);

    public abstract GeoTemporalOperator newOperatorInGeoTemporalRectangle(String fieldName, Rectangle rectangle, String temporalFieldName, TemporalBounds temporalBounds);

    public abstract GeoTemporalOperator newOperatorInGeoTemporalCircleKm(String fieldName, Circle circle, String temporalFieldName, TemporalBounds temporalBounds);

    public abstract GeoTemporalOperator newOperatorInGeoTemporalCircleMeters(String fieldName, Circle circle, String temporalFieldName, TemporalBounds temporalBounds);

    public abstract GeoTemporalOperator newOperatorInGeoTemporalCircleMiles(String fieldName, Circle circle, String temporalFieldName, TemporalBounds temporalBounds);

    public abstract GeoTemporalOperator newOperatorGeoTemporalNearestNeighbors(String fieldName, Point point, int neighbors);

}
