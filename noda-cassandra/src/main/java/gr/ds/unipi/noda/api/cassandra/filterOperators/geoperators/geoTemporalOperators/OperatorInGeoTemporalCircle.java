package gr.ds.unipi.noda.api.cassandra.filterOperators.geoperators.geoTemporalOperators;

import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.geoTemporalOperators.temporal.TemporalBounds;
import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.geometries.Circle;
import gr.ds.unipi.noda.api.cassandra.filterOperators.geoperators.geographicalOperators.OperatorInGeoCircle;
import org.apache.log4j.helpers.ISO8601DateFormat;

import java.text.DateFormat;

final class OperatorInGeoTemporalCircle extends GeoTemporalOperator<Circle, TemporalBounds> {

    protected OperatorInGeoTemporalCircle(String fieldName, Circle circle, String temporalFieldName, TemporalBounds temporalType) {
        super(OperatorInGeoCircle.newOperatorInGeoCircle(fieldName, circle), temporalFieldName, temporalType);
    }

    public static OperatorInGeoTemporalCircle newOperatorInGeoTemporalCircle(String fieldName, Circle circle, String temporalFieldName, TemporalBounds temporalType) {
        return new OperatorInGeoTemporalCircle(fieldName, circle, temporalFieldName, temporalType);
    }

    @Override
    public StringBuilder getOperatorExpression(){
        StringBuilder operation = new StringBuilder("");
        operation.append(getGeographicalOperator().getOperatorExpression());
        operation.append(" AND ");
        DateFormat df = new ISO8601DateFormat();
        String startDate = df.format(getTemporalType().getLowerBound()).replace(",", "+")+"0";
        String endDate= df.format(getTemporalType().getUpperBound()).replace(",", "+")+"0";
        operation.append(getTemporalFieldName()).append(" >= ").append('\''+startDate+'\'').append(" AND ");
        operation.append(getTemporalFieldName()).append(" <= ").append('\''+endDate+'\'');
        return operation;
    }

}
