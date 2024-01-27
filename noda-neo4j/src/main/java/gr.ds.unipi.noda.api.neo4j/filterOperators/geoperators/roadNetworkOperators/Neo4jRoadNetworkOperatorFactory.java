package gr.ds.unipi.noda.api.neo4j.filterOperators.geoperators.roadNetworkOperators;

import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.geoTemporalOperators.temporal.TemporalBounds;
import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.geometries.Point;
import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.roadNetworkOperators.BaseRoadNetworkOperatorFactory;
import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.roadNetworkOperators.RoadNetworkOperator;
import gr.ds.unipi.noda.api.neo4j.filterOperators.geoperators.roadNetworkOperators.roadNetworkGeoOperators.OperatorShortestPath;
import gr.ds.unipi.noda.api.neo4j.filterOperators.geoperators.roadNetworkOperators.roadNetworkGeoTemporalOperators.OperatorNearestInNetworkRange;
import gr.ds.unipi.noda.api.neo4j.filterOperators.geoperators.roadNetworkOperators.roadNetworkGeoTemporalOperators.OperatorNearestObject;

public class Neo4jRoadNetworkOperatorFactory extends BaseRoadNetworkOperatorFactory {
    @Override
    public RoadNetworkOperator newOperatorRoadNetworkNearest(String locationField, Point point, double distance, String temporalField, TemporalBounds temporalBounds) {
        return OperatorNearestInNetworkRange.newOperatorNearestInNetworkRange(locationField, point, distance, temporalField, temporalBounds);
    }

    @Override
    public RoadNetworkOperator newOperatorRoadNetworkNearestObject(String locationField, Point point, String temporalField, TemporalBounds temporalBounds) {
        return OperatorNearestObject.newOperatorNearestObject(locationField, point, temporalField, temporalBounds);
    }

    @Override
    public RoadNetworkOperator newOperatorRoadNetworkShortestPath(String locationField, Point point1, Point point2) {
        return OperatorShortestPath.newOperatorShortestPath(locationField, point1, point2);
    }
}
