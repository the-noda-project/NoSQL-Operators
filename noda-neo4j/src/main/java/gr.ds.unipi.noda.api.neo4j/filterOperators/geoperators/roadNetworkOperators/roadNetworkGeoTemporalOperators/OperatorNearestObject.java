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

        StringBuilder sb = new StringBuilder();
        sb.append(getGeometry().getPoint().getLatitude());
        sb.append(";");
        sb.append(getGeometry().getPoint().getLongitude());
        sb.append(";");
        sb.append(getTemporalType().getLowerBound().getTime());
        sb.append(";");
        sb.append(getTemporalType().getUpperBound().getTime());
        sb.append(";");
        sb.append("noda.roadnetwork.closestObject");

        return sb;
    }

    public static OperatorNearestObject newOperatorNearestObject(String locationField, Point geometry, String temporalField, TemporalBounds temporalType){
        return new OperatorNearestObject(locationField, geometry, temporalField, temporalType);
    }
}
