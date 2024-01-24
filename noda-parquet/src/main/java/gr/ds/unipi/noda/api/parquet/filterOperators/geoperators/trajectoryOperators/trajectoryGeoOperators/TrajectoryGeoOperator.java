package gr.ds.unipi.noda.api.parquet.filterOperators.geoperators.trajectoryOperators.trajectoryGeoOperators;

import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.geometries.Geometry;

public abstract class TrajectoryGeoOperator<U extends Geometry> extends gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.trajectoryOperators.trajectoryGeoOperators.TrajectoryGeoOperator<Object, U> {

    protected TrajectoryGeoOperator(String objectIdField, String segmentField, U geometry) {
        super(objectIdField, segmentField, geometry);
    }
}
