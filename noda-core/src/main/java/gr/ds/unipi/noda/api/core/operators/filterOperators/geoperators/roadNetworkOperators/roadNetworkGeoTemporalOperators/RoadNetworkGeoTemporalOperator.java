package gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.roadNetworkOperators.roadNetworkGeoTemporalOperators;

import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.geoTemporalOperators.temporal.Temporal;
import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.geometries.Geometry;
import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.roadNetworkOperators.roadNetworkGeoOperators.RoadNetworkGeoOperator;

public abstract class RoadNetworkGeoTemporalOperator<T, U extends Geometry, S extends Temporal> extends RoadNetworkGeoOperator<T, U> {
    private final String temporalField;
    private final S temporalType;

    protected RoadNetworkGeoTemporalOperator(String locationField, U geometry, String temporalField, S temporalType) {
        super(locationField, geometry);
        this.temporalField = temporalField;
        this.temporalType = temporalType;
    }
    protected String getTemporalField() {
        return temporalField;
    }

    protected S getTemporalType() {
        return temporalType;
    }
}
