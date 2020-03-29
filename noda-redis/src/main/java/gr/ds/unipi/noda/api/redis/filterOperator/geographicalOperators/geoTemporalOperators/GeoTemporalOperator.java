package gr.ds.unipi.noda.api.redis.filterOperator.geographicalOperators.geoTemporalOperators;

import gr.ds.unipi.noda.api.core.operators.filterOperators.geographicalOperators.geoTemporalOperators.temporal.Temporal;
import gr.ds.unipi.noda.api.core.operators.filterOperators.geographicalOperators.geometries.Geometry;

abstract class GeoTemporalOperator<T extends Geometry, U extends Temporal> extends gr.ds.unipi.noda.api.core.operators.filterOperators.geographicalOperators.geoTemporalOperators.GeoTemporalOperator<Object, T, U> {
    protected GeoTemporalOperator(String fieldName, T geometry, String temporalFieldName, U temporalType) {
        super(fieldName, geometry, temporalFieldName, temporalType);
    }

    @Override
    public Object getOperatorExpression(){
        return null;
    }
}
