package gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.roadNetworkOperators.roadNetworkGeoOperators;

import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.geometries.Geometry;
import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.roadNetworkOperators.RoadNetworkOperator;

public abstract class RoadNetworkGeoOperator<T, U extends Geometry> extends RoadNetworkOperator<T> {
    private final String locationField;
    private final U geometry;
    protected RoadNetworkGeoOperator(String locationField, U geometry) {
        this.locationField = locationField;
        this.geometry = geometry;
    }

    protected String getLocationField() {
        return locationField;
    }
    protected U getGeometry() {
        return geometry;
    }

}
