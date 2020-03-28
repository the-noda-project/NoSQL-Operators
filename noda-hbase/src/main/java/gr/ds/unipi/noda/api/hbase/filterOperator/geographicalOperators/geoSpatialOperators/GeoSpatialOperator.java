package gr.ds.unipi.noda.api.hbase.filterOperator.geographicalOperators.geoSpatialOperators;

import gr.ds.unipi.noda.api.core.operators.filterOperators.geographicalOperators.geometries.Geometry;

abstract class GeoSpatialOperator<T extends Geometry> extends gr.ds.unipi.noda.api.core.operators.filterOperators.geographicalOperators.geoSpatialOperators.GeoSpatialOperator<Object, T> {
    protected GeoSpatialOperator(String fieldName, T geometry) {
        super(fieldName, geometry);
    }

    @Override
    public Object getOperatorExpression(){
        return null;
    }
}
