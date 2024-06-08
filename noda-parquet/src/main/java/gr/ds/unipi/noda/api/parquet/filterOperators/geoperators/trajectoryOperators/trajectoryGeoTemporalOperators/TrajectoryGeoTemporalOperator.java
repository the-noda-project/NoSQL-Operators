package gr.ds.unipi.noda.api.parquet.filterOperators.geoperators.trajectoryOperators.trajectoryGeoTemporalOperators;

import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.geoTemporalOperators.temporal.Temporal;
import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.geometries.Geometry;
import org.apache.parquet.filter2.predicate.FilterPredicate;

public abstract class TrajectoryGeoTemporalOperator<U extends Geometry, S extends Temporal> extends gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.trajectoryOperators.trajectoryGeoTemporalOperators.TrajectoryGeoTemporalOperator<Object, U, S> {

    protected TrajectoryGeoTemporalOperator(String objectIdField, String segmentField, U geometry, S temporalType) {
        super(objectIdField, segmentField, geometry, temporalType);
    }

    @Override
    public abstract FilterPredicate getOperatorExpression();
}
