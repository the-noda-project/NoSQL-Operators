package gr.ds.unipi.noda.api.cassandra.filterOperators.geoperators.geoTemporalOperators;

import gr.ds.unipi.noda.api.cassandra.filterOperators.geoperators.geographicalOperators.OperatorInGeoCircle;
import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.geoTemporalOperators.temporal.TemporalBounds;
import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.geometries.Circle;

public class OperatorInGeoTemporalCircle extends GeoTemporalOperator<Circle, TemporalBounds> {

    protected OperatorInGeoTemporalCircle(String fieldName, Circle circle, String temporalFieldName, TemporalBounds temporalType) {
        super(OperatorInGeoCircle.newOperatorInGeoCircle(fieldName, circle), temporalFieldName, temporalType);
    }

    public static OperatorInGeoTemporalCircle newOperatorInGeoTemporalCircle(String fieldName, Circle circle, String temporalFieldName, TemporalBounds temporalType) {
        return new OperatorInGeoTemporalCircle(fieldName, circle, temporalFieldName, temporalType);
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
