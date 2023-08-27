package gr.ds.unipi.noda.api.cassandra.filterOperators.geoperators.geographicalOperators;

import gr.ds.unipi.noda.api.core.config.AppConfig;
import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.geometries.Geometry;

abstract class GeographicalOperator<T extends Geometry> extends gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.geographicalOperators.GeographicalOperator<Object, T> {
    protected final int geoHashLength ;

    protected GeographicalOperator(String fieldName, T geometry) {
        super(fieldName, geometry);
        geoHashLength = AppConfig.cassandra().getConfig("spatialOp").getInt("geoHashLength");
    }

    @Override
    public StringBuilder getOperatorExpression(){
        return null;
    }
}
