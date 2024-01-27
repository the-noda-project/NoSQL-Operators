package gr.ds.unipi.noda.api.yyydatabase.filterOperators.geoperators.roadNetworkOperators.roadNetworkGeoTemporalOperators;

import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.geoTemporalOperators.temporal.TemporalBounds;
import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.geometries.Point;
import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.roadNetworkOperators.roadNetworkGeoTemporalOperators.RoadNetworkGeoTemporalOperator;
import gr.ds.unipi.noda.api.yyydatabase.filterOperators.geoperators.roadNetworkOperators.roadNetworkGeoOperators.OperatorShortestPath;

public class OperatorNearestObject extends RoadNetworkGeoTemporalOperator<Object, Point, TemporalBounds> {
    protected OperatorNearestObject(String locationField, Point geometry, String temporalField, TemporalBounds temporalType) {
        super(locationField, geometry, temporalField, temporalType);
    }

    @Override
    public Object getOperatorExpression() {
        return null;
    }

    public static OperatorNearestObject newOperatorNearestObject(String locationField, Point geometry, String temporalField, TemporalBounds temporalType){
        return new OperatorNearestObject(locationField, geometry, temporalField, temporalType);
    }
}
