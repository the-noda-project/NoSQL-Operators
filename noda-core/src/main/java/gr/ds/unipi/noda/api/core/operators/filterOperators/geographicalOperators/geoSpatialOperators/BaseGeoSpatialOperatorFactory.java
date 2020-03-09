package gr.ds.unipi.noda.api.core.operators.filterOperators.geographicalOperators.geoSpatialOperators;

import gr.ds.unipi.noda.api.core.operators.filterOperators.geographicalOperators.GeographicalOperator;
import gr.ds.unipi.noda.api.core.operators.filterOperators.geographicalOperators.geometries.Circle;
import gr.ds.unipi.noda.api.core.operators.filterOperators.geographicalOperators.geometries.Point;
import gr.ds.unipi.noda.api.core.operators.filterOperators.geographicalOperators.geometries.Polygon;
import gr.ds.unipi.noda.api.core.operators.filterOperators.geographicalOperators.geometries.Rectangle;

public abstract class BaseGeoSpatialOperatorFactory {

    public abstract GeographicalOperator newOperatorInGeoPolygon(String fieldName, Polygon polygon);

    public abstract GeographicalOperator newOperatorInGeoRectangle(String fieldName, Rectangle rectangle);

    public abstract GeographicalOperator newOperatorInGeoCircleKm(String fieldName, Circle circle);

    public abstract GeographicalOperator newOperatorInGeoCircleMeters(String fieldName, Circle circle);

    public abstract GeographicalOperator newOperatorInGeoCircleMiles(String fieldName, Circle circle);

    public abstract GeographicalOperator newOperatorGeoNearestNeighbors(String fieldName, Point point, int neighbors);

}
