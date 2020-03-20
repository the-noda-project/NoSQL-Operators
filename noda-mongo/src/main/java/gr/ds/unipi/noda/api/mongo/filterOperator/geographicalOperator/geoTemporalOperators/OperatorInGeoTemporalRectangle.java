package gr.ds.unipi.noda.api.mongo.filterOperator.geographicalOperator.geoTemporalOperators;


import gr.ds.unipi.noda.api.core.operators.FilterOperators;
import gr.ds.unipi.noda.api.core.operators.filterOperators.geographicalOperators.GeographicalOperator;
import gr.ds.unipi.noda.api.core.operators.filterOperators.geographicalOperators.geoSpatialOperators.GeoSpatialOperator;
import gr.ds.unipi.noda.api.core.operators.filterOperators.geographicalOperators.geoTemporalOperators.temporal.TemporalBounds;
import gr.ds.unipi.noda.api.core.operators.filterOperators.geographicalOperators.geometries.Rectangle;
import gr.ds.unipi.noda.api.mongo.filterOperator.geographicalOperator.geoSpatialOperators.MongoDBGeoSpatialOperatorFactory;
import gr.ds.unipi.noda.api.mongo.filterOperator.geographicalOperator.geoSpatialOperators.OperatorInGeoRectangle;

public class OperatorInGeoTemporalRectangle extends GeoTemporalOperator<Rectangle, TemporalBounds> {

    private final OperatorInGeoRectangle operatorInGeoRectangle;

    protected OperatorInGeoTemporalRectangle(String fieldName, Rectangle geometry, String temporalFieldName, TemporalBounds temporalType) {
        super(fieldName, geometry, temporalFieldName, temporalType);
        operatorInGeoRectangle = OperatorInGeoRectangle.newOperatorInGeoRectangle(fieldName, geometry);
    }

    public static OperatorInGeoTemporalRectangle newOperatorInGeoTemporalRectangle(String fieldName, Rectangle geometry, String temporalFieldName, TemporalBounds temporalType){
        return new OperatorInGeoTemporalRectangle(fieldName, geometry, temporalFieldName, temporalType);
    }

    @Override
    public StringBuilder getOperatorExpression() {
        return GeoTemporalOperator.formGeometryAndTemporalBoundsExpression(operatorInGeoRectangle.getOperatorExpression(), this.getTemporalFieldName(), this.getTemporalType());
    }
}
