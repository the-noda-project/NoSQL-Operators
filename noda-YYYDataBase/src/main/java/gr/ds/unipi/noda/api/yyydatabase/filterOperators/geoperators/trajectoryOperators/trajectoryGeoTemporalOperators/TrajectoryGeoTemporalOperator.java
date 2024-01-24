package gr.ds.unipi.noda.api.yyydatabase.filterOperators.geoperators.trajectoryOperators.trajectoryGeoTemporalOperators;

import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.geoTemporalOperators.GeoTemporalOperator;
import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.geoTemporalOperators.temporal.Temporal;
import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.geometries.Geometry;

public abstract class TrajectoryGeoTemporalOperator<U extends Geometry, S extends Temporal> extends gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.trajectoryOperators.trajectoryGeoTemporalOperators.TrajectoryGeoTemporalOperator<Object, U, S> {

    protected TrajectoryGeoTemporalOperator(String fieldName, String segmentField, U geometry, S temporalType) {
        super(fieldName, segmentField, geometry, temporalType);
    }
}
