package gr.ds.unipi.noda.api.parquet.filterOperators.geoperators.trajectoryOperators;

import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.geoTemporalOperators.temporal.TemporalBounds;
import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.geometries.Rectangle;
import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.trajectoryOperators.BaseTrajectoryOperatorFactory;
import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.trajectoryOperators.TrajectoryOperator;

public final class  ParquetTrajectoryOperatorFactory extends BaseTrajectoryOperatorFactory {
    @Override
    public TrajectoryOperator newOperatorTrajectoriesInGeoTemporalRectangle(String objectIdField, String segmentField, Rectangle rectangle, String temporalFieldName, TemporalBounds temporalBounds) {
        return null;
    }

    @Override
    public TrajectoryOperator newOperatorTrajectoriesInGeoRectangle(String objectIdField, String segmentField, Rectangle rectangle) {
        return null;
    }
}
