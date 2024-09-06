package gr.ds.unipi.noda.api.neo4j.filterOperators.geoperators.roadNetworkOperators.roadNetworkGeoTemporalOperators;

import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.geoTemporalOperators.temporal.TemporalBounds;
import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.geometries.Point;
import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.roadNetworkOperators.roadNetworkGeoTemporalOperators.RoadNetworkGeoTemporalOperator;

public class OperatorNearestInNetworkRange extends RoadNetworkGeoTemporalOperator<StringBuilder, Point, TemporalBounds> {
    private final double distance;
    protected OperatorNearestInNetworkRange(String locationField, Point geometry, double distance, String temporalField, TemporalBounds temporalType) {
        super(locationField, geometry, temporalField, temporalType);
        this.distance=distance;
    }

    @Override
    public StringBuilder getOperatorExpression() {

        StringBuilder sb = new StringBuilder();
        sb.append(getGeometry().getPoint().getLatitude());
        sb.append(";");
        sb.append(getGeometry().getPoint().getLongitude());
        sb.append(";");
        sb.append((long) getDistance());
        sb.append(";");
        sb.append(getTemporalType().getLowerBound().getTime());
        sb.append(";");
        sb.append(getTemporalType().getUpperBound().getTime());
        sb.append(";");
        sb.append("noda.roadnetwork.nearest");



        return sb;
    }

    public double getDistance(){
        return distance;
    }
    public static OperatorNearestInNetworkRange newOperatorNearestInNetworkRange(String locationField, Point geometry, double distance, String temporalField, TemporalBounds temporalType){
        return new OperatorNearestInNetworkRange(locationField, geometry, distance, temporalField, temporalType);
    }
}
