package gr.ds.unipi.noda.api.cassandra.filterOperators.geoperators.geoTemporalOperators;


import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.geoTemporalOperators.temporal.TemporalBounds;
import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.geometries.Rectangle;
import gr.ds.unipi.noda.api.cassandra.filterOperators.geoperators.geographicalOperators.OperatorInGeoRectangle;
final class OperatorInGeoTemporalRectangle extends GeoTemporalOperator<Rectangle, TemporalBounds> {

    protected OperatorInGeoTemporalRectangle(String fieldName, Rectangle rectangle, String temporalFieldName, TemporalBounds temporalType) {
        super(OperatorInGeoRectangle.newOperatorInGeoRectangle(fieldName, rectangle), temporalFieldName, temporalType);
    }

    public static OperatorInGeoTemporalRectangle newOperatorInGeoTemporalRectangle(String fieldName, Rectangle rectangle, String temporalFieldName, TemporalBounds temporalType) {
        return new OperatorInGeoTemporalRectangle(fieldName, rectangle, temporalFieldName, temporalType);
    }

    @Override
    public String[] getOperatorExpression(){
        String[] operation = new String[2];

        // For the select clause
        String[] geoOpExp = (String[]) getGeographicalOperator().getOperatorExpression();
        operation[0] = geoOpExp[0];

        //For the where clause
        operation[1] = parseDates(getTemporalType().getLowerBound(), getTemporalType().getUpperBound());
        return operation;
    }
}
