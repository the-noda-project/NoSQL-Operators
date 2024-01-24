package gr.ds.unipi.noda.api.yyydatabase.filterOperators.geoperators.trajectoryOperators.trajectoryGeoOperators;

import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.geometries.Geometry;

public abstract class TrajectoryGeoOperator<U extends Geometry> extends gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.trajectoryOperators.trajectoryGeoOperators.TrajectoryGeoOperator<Object, U> {

    protected TrajectoryGeoOperator(String fieldName, String segmentField, U geometry) {
        super(fieldName, segmentField, geometry);
    }
}
