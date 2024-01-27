package gr.ds.unipi.noda.api.yyydatabase.filterOperators.geoperators.roadNetworkOperators.roadNetworkGeoOperators;

import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.geometries.Point;
import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.roadNetworkOperators.roadNetworkGeoOperators.RoadNetworkGeoOperator;

public class OperatorShortestPath extends RoadNetworkGeoOperator<Object, Point> {

    private final Point destinationPoint;
    private OperatorShortestPath(String locationField, Point geometry, Point destinationPoint) {
        super(locationField, geometry);
        this.destinationPoint = destinationPoint;
    }

    @Override
    public Object getOperatorExpression() {
        return null;
    }

    public Point getDestinationPoint(){
        return destinationPoint;
    }

    public static OperatorShortestPath newOperatorShortestPath(String locationField, Point geometry, Point destinationPoint){
        return new OperatorShortestPath(locationField, geometry, destinationPoint);
    }
}
