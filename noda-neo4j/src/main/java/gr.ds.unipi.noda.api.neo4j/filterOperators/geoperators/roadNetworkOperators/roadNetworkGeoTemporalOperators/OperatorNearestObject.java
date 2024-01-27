package gr.ds.unipi.noda.api.neo4j.filterOperators.geoperators.roadNetworkOperators.roadNetworkGeoTemporalOperators;

import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.geoTemporalOperators.temporal.TemporalBounds;
import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.geometries.Point;
import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.roadNetworkOperators.roadNetworkGeoTemporalOperators.RoadNetworkGeoTemporalOperator;

public class OperatorNearestObject extends RoadNetworkGeoTemporalOperator<StringBuilder, Point, TemporalBounds> {
    protected OperatorNearestObject(String locationField, Point geometry, String temporalField, TemporalBounds temporalType) {
        super(locationField, geometry, temporalField, temporalType);
    }

    @Override
    public StringBuilder getOperatorExpression() {
        return null;
    }

    public static OperatorNearestObject newOperatorNearestObject(String locationField, Point geometry, String temporalField, TemporalBounds temporalType){
        return new OperatorNearestObject(locationField, geometry, temporalField, temporalType);
    }
}
