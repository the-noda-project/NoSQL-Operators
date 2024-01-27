package gr.ds.unipi.noda.api.yyydatabase.filterOperators.geoperators.roadNetworkOperators.roadNetworkGeoTemporalOperators;

import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.geoTemporalOperators.temporal.TemporalBounds;
import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.geometries.Point;
import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.roadNetworkOperators.roadNetworkGeoTemporalOperators.RoadNetworkGeoTemporalOperator;

public class OperatorNearestInNetworkRange extends RoadNetworkGeoTemporalOperator<Object, Point, TemporalBounds> {
    private final double distance;
    protected OperatorNearestInNetworkRange(String locationField, Point geometry, double distance, String temporalField, TemporalBounds temporalType) {
        super(locationField, geometry, temporalField, temporalType);
        this.distance=distance;
    }

    @Override
    public Object getOperatorExpression() {
        return null;
    }

    public double getDistance(){
        return distance;
    }
    public static OperatorNearestInNetworkRange newOperatorNearestInNetworkRange(String locationField, Point geometry, double distance, String temporalField, TemporalBounds temporalType){
        return new OperatorNearestInNetworkRange(locationField, geometry, distance, temporalField, temporalType);
    }
}
