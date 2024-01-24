package gr.ds.unipi.noda.api.yyydatabase.filterOperators.geoperators.trajectoryOperators.trajectoryGeoTemporalOperators;

import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.geoTemporalOperators.GeoTemporalOperator;
import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.geoTemporalOperators.temporal.TemporalBounds;
import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.geometries.Rectangle;

public class OperatorInGeoTemporalRectangle extends TrajectoryGeoTemporalOperator<Rectangle, TemporalBounds>{

    private OperatorInGeoTemporalRectangle(String fieldName, String segmentField, Rectangle geometry, TemporalBounds temporalType) {
        super(fieldName, segmentField, geometry, temporalType);
    }

    @Override
    public Object getOperatorExpression() {
        return null;
    }

    public static OperatorInGeoTemporalRectangle newOperatorInGeoTemporalRectangle(String fieldName, String segmentField, Rectangle geometry, TemporalBounds temporalType){
        return new OperatorInGeoTemporalRectangle(fieldName, segmentField, geometry, temporalType);
    }
}
