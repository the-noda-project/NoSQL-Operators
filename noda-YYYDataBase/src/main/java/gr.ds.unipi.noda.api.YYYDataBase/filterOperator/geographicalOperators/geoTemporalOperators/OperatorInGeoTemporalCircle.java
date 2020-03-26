package gr.ds.unipi.noda.api.YYYDataBase.filterOperator.geographicalOperators.geoTemporalOperators;

import gr.ds.unipi.noda.api.core.operators.filterOperators.geographicalOperators.geoTemporalOperators.temporal.TemporalBounds;
import gr.ds.unipi.noda.api.core.operators.filterOperators.geographicalOperators.geometries.Circle;

public class OperatorInGeoTemporalCircle extends GeoTemporalOperator<Circle, TemporalBounds> {

    protected OperatorInGeoTemporalCircle(String fieldName, Circle circle, String temporalFieldName, TemporalBounds temporalType) {
        super(fieldName, circle, temporalFieldName, temporalType);
    }

    public static OperatorInGeoTemporalCircle newOperatorInGeoTemporalCircle(String fieldName, Circle circle, String temporalFieldName, TemporalBounds temporalType) {
        return new OperatorInGeoTemporalCircle(fieldName, circle, temporalFieldName, temporalType);
    }

}
