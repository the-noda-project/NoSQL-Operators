package gr.ds.unipi.noda.api.neo4j.filterOperators.geoperators.roadNetworkOperators.roadNetworkGeoOperators;

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
        return null;
    }

    public Point getDestinationPoint(){
        return destinationPoint;
    }

    public static OperatorShortestPath newOperatorShortestPath(String locationField, Point geometry, Point destinationPoint){
        return new OperatorShortestPath(locationField, geometry, destinationPoint);
    }
}
