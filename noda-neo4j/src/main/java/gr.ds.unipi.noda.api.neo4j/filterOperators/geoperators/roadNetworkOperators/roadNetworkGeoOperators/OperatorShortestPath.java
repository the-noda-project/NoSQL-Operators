package gr.ds.unipi.noda.api.neo4j.filterOperators.geoperators.roadNetworkOperators.roadNetworkGeoOperators;

import gr.ds.unipi.noda.api.core.operators.filterOperators.FilterOperator;
import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.geometries.Point;
import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.roadNetworkOperators.roadNetworkGeoOperators.RoadNetworkGeoOperator;

public class OperatorShortestPath extends RoadNetworkGeoOperator<StringBuilder, Point> {

    private final Point destinationPoint;
    private OperatorShortestPath(String locationField, Point geometry, Point destinationPoint) {
        super(locationField, geometry);
        this.destinationPoint = destinationPoint;
    }

    @Override
    public StringBuilder getOperatorExpression() {
        StringBuilder sb = new StringBuilder();
        sb.append(getGeometry().getPoint().getLatitude());
        sb.append(";");
        sb.append(getGeometry().getPoint().getLongitude());
        sb.append(";");
        sb.append(getDestinationPoint().getPoint().getLatitude());
        sb.append(";");
        sb.append(getDestinationPoint().getPoint().getLongitude());
        sb.append(";");
        sb.append(getLocationField());
        sb.append(";");
        sb.append("noda.roadnetwork.closestPath");

        return sb;
    }

    public Point getDestinationPoint(){
        return destinationPoint;
    }

    public static OperatorShortestPath newOperatorShortestPath(String locationField, Point geometry, Point destinationPoint){
        return new OperatorShortestPath(locationField, geometry, destinationPoint);
    }
}
