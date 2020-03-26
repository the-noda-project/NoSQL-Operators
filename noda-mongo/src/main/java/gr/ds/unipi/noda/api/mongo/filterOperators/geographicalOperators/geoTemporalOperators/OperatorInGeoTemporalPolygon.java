package gr.ds.unipi.noda.api.mongo.filterOperators.geographicalOperators.geoTemporalOperators;

import gr.ds.unipi.noda.api.core.operators.filterOperators.geographicalOperators.geoTemporalOperators.temporal.TemporalBounds;
import gr.ds.unipi.noda.api.core.operators.filterOperators.geographicalOperators.geometries.Polygon;
import gr.ds.unipi.noda.api.mongo.filterOperators.geographicalOperators.geoSpatialOperators.OperatorInGeoPolygon;

public final class OperatorInGeoTemporalPolygon extends GeoTemporalOperator<Polygon, TemporalBounds> {

    private final OperatorInGeoPolygon operatorInGeoPolygon;

    protected OperatorInGeoTemporalPolygon(String fieldName, Polygon polygon, String temporalFieldName, TemporalBounds temporalType) {
        super(fieldName, polygon, temporalFieldName, temporalType);
        operatorInGeoPolygon = OperatorInGeoPolygon.newOperatorInGeoPolygon(fieldName, polygon);
    }

    public static OperatorInGeoTemporalPolygon newOperatorInGeoTemporalPolygon(String fieldName, Polygon polygon, String temporalFieldName, TemporalBounds temporalType) {
        return new OperatorInGeoTemporalPolygon(fieldName, polygon, temporalFieldName, temporalType);
    }

    @Override
    public StringBuilder getOperatorExpression() {
        return GeoTemporalOperator.formGeometryAndTemporalBoundsExpression(operatorInGeoPolygon.getOperatorExpression(), this.getTemporalFieldName(), this.getTemporalType());
    }
}
