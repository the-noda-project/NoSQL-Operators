package gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.roadNetworkOperators.roadNetworkGeoTemporalOperators;

import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.geoTemporalOperators.temporal.Temporal;
import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.geometries.Geometry;
import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.roadNetworkOperators.roadNetworkGeoOperators.RoadNetworkGeoOperator;

public abstract class RoadNetworkGeoTemporalOperator<T, U extends Geometry, S extends Temporal> extends RoadNetworkGeoOperator<T, U> {

    private final S temporalType;

    protected RoadNetworkGeoTemporalOperator(String objectIdField, String segmentField, U geometry, S temporalType) {
        super(objectIdField, segmentField, geometry);
        this.temporalType = temporalType;
    }

    protected S getTemporalType() {
        return temporalType;
    }
}
