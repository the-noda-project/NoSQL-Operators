package gr.ds.unipi.noda.api.neo4j.filterOperators.geoperators.geoTemporalOperators;

import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.geoTemporalOperators.temporal.TemporalBounds;
import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.geometries.Circle;
import gr.ds.unipi.noda.api.neo4j.filterOperators.geoperators.geographicalOperators.OperatorInGeographicalCircle;

final class OperatorInGeoTemporalCircle extends GeoTemporalOperator<Circle, TemporalBounds> {

    protected OperatorInGeoTemporalCircle(String fieldName, Circle circle, String temporalFieldName, TemporalBounds temporalType) {
        super(OperatorInGeographicalCircle.newOperatorInGeographicalCircle(fieldName, circle), temporalFieldName, temporalType);
    }

    public static OperatorInGeoTemporalCircle newOperatorInGeoTemporalCircle(String fieldName, Circle circle, String temporalFieldName, TemporalBounds temporalType) {
        return new OperatorInGeoTemporalCircle(fieldName, circle, temporalFieldName, temporalType);
    }

}
