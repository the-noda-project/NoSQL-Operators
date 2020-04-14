package gr.ds.unipi.noda.api.hbase.filterOperator.geographicalOperators.geoSpatialOperators;

import gr.ds.unipi.noda.api.core.operators.filterOperators.geographicalOperators.geometries.Polygon;
import org.apache.hadoop.hbase.filter.Filter;

final class OperatorInGeoPolygon extends GeoSpatialOperator<Polygon> {

    private OperatorInGeoPolygon(String fieldName, Polygon polygon) {
        super(fieldName, polygon);
    }

    @Override
    protected Filter geometryRefactor() {
        return null;
    }

    public static OperatorInGeoPolygon newOperatorInGeoPolygon(String fieldName, Polygon polygon) {
        return new OperatorInGeoPolygon(fieldName, polygon);
    }



}
