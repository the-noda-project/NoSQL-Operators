package gr.ds.unipi.noda.api.mongo.filterOperators.geoperators.geoTemporalOperators;

import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.geoTemporalOperators.temporal.TemporalBounds;
import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.geometries.Circle;
import gr.ds.unipi.noda.api.mongo.filterOperators.geoperators.geographicalOperators.OperatorInGeoCircle;

public final class OperatorInGeoTemporalCircle extends GeoTemporalOperator<Circle, TemporalBounds> {

    protected OperatorInGeoTemporalCircle(String fieldName, Circle circle, String temporalFieldName, TemporalBounds temporalType) {
        super(OperatorInGeoCircle.newOperatorInGeoCircle(fieldName, circle), temporalFieldName, temporalType);
    }

    public static OperatorInGeoTemporalCircle newOperatorInGeoTemporalCircle(String fieldName, Circle circle, String temporalFieldName, TemporalBounds temporalType) {
        return new OperatorInGeoTemporalCircle(fieldName, circle, temporalFieldName, temporalType);
    }

    @Override
    public StringBuilder getOperatorExpression() {
        return GeoTemporalOperator.formGeometryAndTemporalBoundsExpression(this.getGeographicalOperator().getOperatorExpression(), this.getTemporalFieldName(), this.getTemporalType());
    }
}
