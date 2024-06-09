package gr.ds.unipi.noda.api.parquet.filterOperators.geoperators.trajectoryOperators;

import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.geoTemporalOperators.temporal.TemporalBounds;
import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.geometries.Rectangle;
import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.trajectoryOperators.BaseTrajectoryOperatorFactory;
import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.trajectoryOperators.TrajectoryOperator;
import gr.ds.unipi.noda.api.parquet.filterOperators.geoperators.trajectoryOperators.trajectoryGeoOperators.OperatorInGeoRectangle;
import gr.ds.unipi.noda.api.parquet.filterOperators.geoperators.trajectoryOperators.trajectoryGeoTemporalOperators.OperatorInGeoTemporalRectangle;

public final class  ParquetTrajectoryOperatorFactory extends BaseTrajectoryOperatorFactory {
    @Override
    public TrajectoryOperator newOperatorTrajectoriesInGeoTemporalRectangle(String objectIdField, String segmentField, Rectangle rectangle, TemporalBounds temporalBounds) {
        return OperatorInGeoTemporalRectangle.newOperatorInGeoTemporalRectangle(objectIdField, segmentField, rectangle, temporalBounds);
    }

    @Override
    public TrajectoryOperator newOperatorTrajectoriesInGeoRectangle(String objectIdField, String segmentField, Rectangle rectangle) {
        return OperatorInGeoRectangle.newOperatorInGeoRectangle(objectIdField, segmentField, rectangle);
    }
}
