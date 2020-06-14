package gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.geographicalOperators;

import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.geometries.Circle;
import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.geometries.Point;
import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.geometries.Polygon;
import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.geometries.Rectangle;

public abstract class BaseGeographicalOperatorFactory {

    public abstract GeographicalOperator newOperatorInGeoPolygon(String fieldName, Polygon polygon);

    public abstract GeographicalOperator newOperatorInGeoRectangle(String fieldName, Rectangle rectangle);

    public abstract GeographicalOperator newOperatorInGeoCircle(String fieldName, Circle circle);

    public abstract GeographicalOperator newOperatorGeoNearestNeighbors(String fieldName, Point point, int neighbors);

}
