package gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.trajectoryOperators.trajectoryGeoOperators;

import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.geometries.Geometry;
import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.trajectoryOperators.TrajectoryOperator;

public abstract class TrajectoryGeoOperator<T, U extends Geometry> extends TrajectoryOperator<T> {
    private final U geometry;

    protected TrajectoryGeoOperator(String fieldName, U geometry) {
        super(fieldName);
        this.geometry = geometry;
    }

    protected U getGeometry() {
        return geometry;
    }
}
