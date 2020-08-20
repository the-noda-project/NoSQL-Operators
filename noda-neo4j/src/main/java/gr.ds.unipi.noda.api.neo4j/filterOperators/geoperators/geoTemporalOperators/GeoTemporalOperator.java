package gr.ds.unipi.noda.api.neo4j.filterOperators.geoperators.geoTemporalOperators;

import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.geoTemporalOperators.temporal.Temporal;
import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.geographicalOperators.GeographicalOperator;
import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.geometries.Geometry;

abstract class GeoTemporalOperator<T extends Geometry, U extends Temporal> extends gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.geoTemporalOperators.GeoTemporalOperator<StringBuilder, T, U> {
    protected GeoTemporalOperator(GeographicalOperator<StringBuilder,T> geographicalOperator, String temporalFieldName, U temporalType) {
        super(geographicalOperator, temporalFieldName, temporalType);
    }


    @Override
    public StringBuilder getOperatorExpression(){
        return null;
    }
}
