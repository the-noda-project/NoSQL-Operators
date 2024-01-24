package gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.trajectoryOperators;

import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.geoTemporalOperators.GeoTemporalOperator;
import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.geoTemporalOperators.temporal.TemporalBounds;
import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.geometries.Rectangle;

public abstract class BaseTrajectoryOperatorFactory {

    public abstract TrajectoryOperator newOperatorTrajectoriesInGeoTemporalRectangle(String objectIdField, String segmentField, Rectangle rectangle, String temporalFieldName, TemporalBounds temporalBounds);

    public abstract TrajectoryOperator newOperatorTrajectoriesInGeoRectangle(String objectIdField, String segmentField, Rectangle rectangle);


}
