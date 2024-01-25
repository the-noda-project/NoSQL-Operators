package gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.roadNetworkOperators;

import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.geoTemporalOperators.temporal.TemporalBounds;
import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.geometries.Circle;
import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.geometries.Point;
import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.geometries.Rectangle;
import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.trajectoryOperators.TrajectoryOperator;

public abstract class BaseRoadNetworkOperatorFactory {
    public abstract RoadNetworkOperator newOperatorRoadNetworkNearestInRange(String objectIdField, String segmentField, Circle circle, String temporalFieldName, TemporalBounds temporalBounds);
    public abstract RoadNetworkOperator newOperatorRoadNetworkNearestObject(String objectIdField, String segmentField, Point point, TemporalBounds temporalBounds);
    public abstract RoadNetworkOperator newOperatorRoadNetworkShortestPath(String objectIdField, String segmentField, Rectangle rectangle);

}
