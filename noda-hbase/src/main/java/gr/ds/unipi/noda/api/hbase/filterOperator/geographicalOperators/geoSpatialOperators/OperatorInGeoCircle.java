package gr.ds.unipi.noda.api.hbase.filterOperator.geographicalOperators.geoSpatialOperators;

import gr.ds.unipi.noda.api.core.operators.filterOperators.geographicalOperators.geometries.Circle;
import gr.ds.unipi.noda.api.hbase.filterOperator.geographicalOperators.geoSpatialOperators.customFilters.CircleFilter;
import gr.ds.unipi.noda.api.hbase.filterOperator.geographicalOperators.geoSpatialOperators.customFilters.generated.CircleFilterProtos;
import org.apache.hadoop.hbase.filter.Filter;
import org.apache.hadoop.hbase.util.Bytes;

final class OperatorInGeoCircle extends GeoSpatialOperator<Circle> {

    private OperatorInGeoCircle(String fieldName, Circle circle) {
        super(fieldName, circle);
    }

    public static OperatorInGeoCircle newOperatorInGeoCircle(String fieldName, Circle circle) {
        return new OperatorInGeoCircle(fieldName, circle);
    }

    @Override
    protected Filter geometryRefactor() {
        CircleFilterProtos.CircleFilter.Coordinates centerCoordinates = CircleFilterProtos.CircleFilter.Coordinates.newBuilder().setLongitude(getGeometry().getCircleCenter().getLongitude()).setLatitude(getGeometry().getCircleCenter().getLatitude()).build();
        return CircleFilter.newCircleFilter(Bytes.toBytes(getFieldName()), Bytes.toBytes("lon"),Bytes.toBytes("lat"),centerCoordinates, getGeometry().getRadius());
    }

}