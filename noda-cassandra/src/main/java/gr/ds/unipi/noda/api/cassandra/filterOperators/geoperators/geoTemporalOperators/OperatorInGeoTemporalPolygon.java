package gr.ds.unipi.noda.api.cassandra.filterOperators.geoperators.geoTemporalOperators;

import gr.ds.unipi.noda.api.cassandra.filterOperators.geoperators.geographicalOperators.OperatorInGeoPolygon;
import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.geoTemporalOperators.temporal.TemporalBounds;
import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.geometries.Polygon;

public class OperatorInGeoTemporalPolygon extends GeoTemporalOperator<Polygon, TemporalBounds> {

    protected OperatorInGeoTemporalPolygon(String fieldName, Polygon polygon, String temporalFieldName, TemporalBounds temporalType) {
        super(OperatorInGeoPolygon.newOperatorInGeoPolygon(fieldName, polygon), temporalFieldName, temporalType);
    }

    public static OperatorInGeoTemporalPolygon newOperatorInGeoTemporalPolygon(String fieldName, Polygon polygon, String temporalFieldName, TemporalBounds temporalType) {
        return new OperatorInGeoTemporalPolygon(fieldName, polygon, temporalFieldName, temporalType);
    }

    @Override
    public String[] getOperatorExpression() {
        String[] operation = new String[3];
        String[] geoOperatorExpression = (String[]) getGeographicalOperator().getOperatorExpression();

        //UDF for the select clause--SELECT clause
        operation[0] = geoOperatorExpression[0];

        //GeoHashes--WHERE clause
        operation[1] = geoOperatorExpression[1];

        //Time bound--WHERE clause
        operation[2] = parseDates(getTemporalType().getLowerBound(), getTemporalType().getUpperBound());

        return operation;
    }

}
