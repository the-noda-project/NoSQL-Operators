package gr.ds.unipi.noda.api.mongo.filterOperators.geographicalOperators.geoTemporalOperators;


import gr.ds.unipi.noda.api.core.operators.filterOperators.geographicalOperators.geoTemporalOperators.temporal.TemporalBounds;
import gr.ds.unipi.noda.api.core.operators.filterOperators.geographicalOperators.geometries.Rectangle;
import gr.ds.unipi.noda.api.mongo.filterOperators.geographicalOperators.geoSpatialOperators.OperatorInGeoRectangle;

public final class OperatorInGeoTemporalRectangle extends GeoTemporalOperator<Rectangle, TemporalBounds> {

    private final OperatorInGeoRectangle operatorInGeoRectangle;

    protected OperatorInGeoTemporalRectangle(String fieldName, Rectangle rectangle, String temporalFieldName, TemporalBounds temporalType) {
        super(fieldName, rectangle, temporalFieldName, temporalType);
        operatorInGeoRectangle = OperatorInGeoRectangle.newOperatorInGeoRectangle(fieldName, rectangle);
    }

    public static OperatorInGeoTemporalRectangle newOperatorInGeoTemporalRectangle(String fieldName, Rectangle rectangle, String temporalFieldName, TemporalBounds temporalType) {
        return new OperatorInGeoTemporalRectangle(fieldName, rectangle, temporalFieldName, temporalType);
    }

    @Override
    public StringBuilder getOperatorExpression() {
        return GeoTemporalOperator.formGeometryAndTemporalBoundsExpression(operatorInGeoRectangle.getOperatorExpression(), this.getTemporalFieldName(), this.getTemporalType());
    }
}
