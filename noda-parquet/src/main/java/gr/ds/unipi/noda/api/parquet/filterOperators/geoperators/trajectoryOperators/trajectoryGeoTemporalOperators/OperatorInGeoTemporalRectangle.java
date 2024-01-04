package gr.ds.unipi.noda.api.parquet.filterOperators.geoperators.trajectoryOperators.trajectoryGeoTemporalOperators;

import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.geoTemporalOperators.temporal.TemporalBounds;
import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.geometries.Rectangle;

public class OperatorInGeoTemporalRectangle extends TrajectoryGeoTemporalOperator<Rectangle, TemporalBounds>{

    private OperatorInGeoTemporalRectangle(String fieldName, Rectangle geometry, TemporalBounds temporalType) {
        super(fieldName, geometry, temporalType);
    }

    @Override
    public Object getOperatorExpression() {
        return null;
    }

    public static OperatorInGeoTemporalRectangle newOperatorInGeoTemporalRectangle(String fieldName, Rectangle geometry, TemporalBounds temporalType){
        return new OperatorInGeoTemporalRectangle(fieldName, geometry, temporalType);
    }
}
