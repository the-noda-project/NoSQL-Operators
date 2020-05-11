package gr.ds.unipi.noda.api.hbase.filterOperator.geoperators.geoTemporalOperators;

import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.geoTemporalOperators.temporal.Temporal;
import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.geographicalOperators.GeographicalOperator;
import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.geometries.Geometry;
import org.apache.hadoop.hbase.filter.Filter;

abstract class GeoTemporalOperator<T extends Geometry, U extends Temporal> extends gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.geoTemporalOperators.GeoTemporalOperator<Filter, T, U> {
    protected GeoTemporalOperator(GeographicalOperator<Filter,T> geographicalOperator, String temporalFieldName, U temporalType) {
        super(geographicalOperator, temporalFieldName, temporalType);
    }

    @Override
    public Filter getOperatorExpression() {
        return null;
    }
}
