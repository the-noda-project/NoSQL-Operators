package gr.ds.unipi.noda.api.mongo.filterOperator.geographicalOperator.geoTemporalOperators;

import gr.ds.unipi.noda.api.core.operators.filterOperators.geographicalOperators.geoTemporalOperators.temporal.TemporalBounds;
import gr.ds.unipi.noda.api.core.operators.filterOperators.geographicalOperators.geometries.Circle;
import gr.ds.unipi.noda.api.mongo.filterOperator.geographicalOperator.geoSpatialOperators.OperatorInGeoCircle;

public class OperatorInGeoTemporalCircle extends GeoTemporalOperator<Circle, TemporalBounds> {
    private final OperatorInGeoCircle operatorInGeoCircle;

    protected OperatorInGeoTemporalCircle(String fieldName, Circle circle, String temporalFieldName, TemporalBounds temporalType) {
        super(fieldName, circle, temporalFieldName, temporalType);
        operatorInGeoCircle = OperatorInGeoCircle.newOperatorInGeoCircle(fieldName, circle);
    }

    public static OperatorInGeoTemporalCircle newOperatorInGeoTemporalCircle(String fieldName, Circle circle, String temporalFieldName, TemporalBounds temporalType){
        return new OperatorInGeoTemporalCircle(fieldName, circle, temporalFieldName, temporalType);
    }

    @Override
    public StringBuilder getOperatorExpression() {
        return GeoTemporalOperator.formGeometryAndTemporalBoundsExpression(operatorInGeoCircle.getOperatorExpression(), this.getTemporalFieldName(), this.getTemporalType());
    }
}
