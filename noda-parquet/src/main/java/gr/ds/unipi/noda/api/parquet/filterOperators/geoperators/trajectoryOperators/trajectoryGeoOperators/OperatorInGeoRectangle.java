package gr.ds.unipi.noda.api.parquet.filterOperators.geoperators.trajectoryOperators.trajectoryGeoOperators;

import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.geometries.Rectangle;

public final class OperatorInGeoRectangle extends TrajectoryGeoOperator<Rectangle> {
    private OperatorInGeoRectangle(String fieldName, Rectangle geometry) {
        super(fieldName, geometry);
    }

    @Override
    public Object getOperatorExpression() {
        return null;
    }

    public static OperatorInGeoRectangle newOperatorInGeoRectangle (String fieldName, Rectangle geometry){
        return new OperatorInGeoRectangle(fieldName, geometry);
    }
}
