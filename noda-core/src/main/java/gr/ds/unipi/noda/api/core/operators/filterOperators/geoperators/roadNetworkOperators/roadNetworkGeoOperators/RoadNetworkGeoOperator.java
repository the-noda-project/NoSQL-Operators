package gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.roadNetworkOperators.roadNetworkGeoOperators;

import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.geometries.Geometry;
import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.roadNetworkOperators.RoadNetworkOperator;

public abstract class RoadNetworkGeoOperator<T, U extends Geometry> extends RoadNetworkOperator<T> {
    private final U geometry;
    protected RoadNetworkGeoOperator(String objectIdField, String segmentField, U geometry) {
        super(objectIdField, segmentField);
        this.geometry = geometry;
    }

    protected U getGeometry() {
        return geometry;
    }

}
