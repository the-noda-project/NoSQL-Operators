package gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.trajectoryOperators.trajectoryGeoTemporalOperators;

import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.geoTemporalOperators.temporal.Temporal;
import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.geometries.Geometry;
import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.trajectoryOperators.trajectoryGeoOperators.TrajectoryGeoOperator;

public abstract class TrajectoryGeoTemporalOperator<T, U extends Geometry, S extends Temporal> extends TrajectoryGeoOperator<T, U> {

    private final S temporalType;

    protected TrajectoryGeoTemporalOperator(String objectIdField, String segmentField, U geometry, S temporalType) {
        super(objectIdField, segmentField, geometry);
        this.temporalType = temporalType;
    }

    protected S getTemporalType() {
        return temporalType;
    }
}
