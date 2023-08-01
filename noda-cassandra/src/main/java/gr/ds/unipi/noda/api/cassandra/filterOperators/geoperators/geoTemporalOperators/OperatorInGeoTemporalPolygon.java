package gr.ds.unipi.noda.api.cassandra.filterOperators.geoperators.geoTemporalOperators;

import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.geoTemporalOperators.temporal.TemporalBounds;
import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.geometries.Polygon;
import gr.ds.unipi.noda.api.cassandra.filterOperators.geoperators.geographicalOperators.OperatorInGeoPolygon;

final class OperatorInGeoTemporalPolygon extends GeoTemporalOperator<Polygon, TemporalBounds> {

    protected OperatorInGeoTemporalPolygon(String fieldName, Polygon polygon, String temporalFieldName, TemporalBounds temporalType) {
        super(OperatorInGeoPolygon.newOperatorInGeoPolygon(fieldName, polygon), temporalFieldName, temporalType);
    }

    public static OperatorInGeoTemporalPolygon newOperatorInGeoTemporalPolygon(String fieldName, Polygon polygon, String temporalFieldName, TemporalBounds temporalType) {
        return new OperatorInGeoTemporalPolygon(fieldName, polygon, temporalFieldName, temporalType);
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
