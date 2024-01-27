package gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.roadNetworkOperators;

import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.geoTemporalOperators.temporal.TemporalBounds;
import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.geometries.Circle;
import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.geometries.Point;
import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.geometries.Rectangle;
import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.trajectoryOperators.TrajectoryOperator;

import java.util.Date;

public abstract class BaseRoadNetworkOperatorFactory {
    public abstract RoadNetworkOperator newOperatorRoadNetworkNearest(String locationField, Point point, double distance, String temporalField, TemporalBounds temporalBounds);
    public abstract RoadNetworkOperator newOperatorRoadNetworkNearestObject(String locationField, Point point, String temporalField, TemporalBounds temporalBounds);
    public abstract RoadNetworkOperator newOperatorRoadNetworkShortestPath(String locationField, Point point1, Point point2);

}
