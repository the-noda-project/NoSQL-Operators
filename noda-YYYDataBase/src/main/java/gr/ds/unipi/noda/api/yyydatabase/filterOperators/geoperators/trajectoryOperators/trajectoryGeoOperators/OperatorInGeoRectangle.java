package gr.ds.unipi.noda.api.yyydatabase.filterOperators.geoperators.trajectoryOperators.trajectoryGeoOperators;

import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.geometries.Rectangle;

public final class OperatorInGeoRectangle extends TrajectoryGeoOperator<Rectangle> {
    private OperatorInGeoRectangle(String fieldName, String segmentField, Rectangle geometry) {
        super(fieldName, segmentField, geometry);
    }

    @Override
    public Object getOperatorExpression() {
        return null;
    }

    public static OperatorInGeoRectangle newOperatorInGeoRectangle (String fieldName, String segmentField, Rectangle geometry){
        return new OperatorInGeoRectangle(fieldName, segmentField, geometry);
    }
}
