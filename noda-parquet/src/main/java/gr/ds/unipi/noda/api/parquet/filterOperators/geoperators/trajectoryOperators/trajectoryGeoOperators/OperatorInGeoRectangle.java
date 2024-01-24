package gr.ds.unipi.noda.api.parquet.filterOperators.geoperators.trajectoryOperators.trajectoryGeoOperators;

import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.geometries.Rectangle;

public final class OperatorInGeoRectangle extends TrajectoryGeoOperator<Rectangle> {
    private OperatorInGeoRectangle(String objectIdField, String segmentField, Rectangle geometry) {
        super(objectIdField, segmentField, geometry);
    }

    @Override
    public Object getOperatorExpression() {
        return null;
    }

    public static OperatorInGeoRectangle newOperatorInGeoRectangle (String objectIdField, String segmentField, Rectangle geometry){
        return new OperatorInGeoRectangle(objectIdField, segmentField, geometry);
    }
}
