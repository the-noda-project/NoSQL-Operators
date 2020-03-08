package gr.ds.unipi.noda.api.core.operators.filterOperators.geoSpatialOperators;

import gr.ds.unipi.noda.api.core.operators.filterOperators.geographicalOperators.GeographicalOperator;
import gr.ds.unipi.noda.api.core.operators.filterOperators.geographicalOperators.geometries.Geometry;

public abstract class GeoSpatialOperator<T,U extends Geometry> extends GeographicalOperator<T, U> {
    protected GeoSpatialOperator(String fieldName, U geometry) {
        super(fieldName, geometry);
    }
}
