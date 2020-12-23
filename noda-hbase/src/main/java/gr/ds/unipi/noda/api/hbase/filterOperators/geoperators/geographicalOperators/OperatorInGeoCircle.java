package gr.ds.unipi.noda.api.hbase.filterOperators.geoperators.geographicalOperators;

import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.geometries.Circle;
import gr.ds.unipi.noda.api.hbase.filterOperators.geoperators.geographicalOperators.customFilters.CircleFilter;
import gr.ds.unipi.noda.api.hbase.filterOperators.geoperators.geographicalOperators.customFilters.generated.CircleFilterProtos;
import org.apache.hadoop.hbase.filter.Filter;
import org.apache.hadoop.hbase.util.Bytes;

public final class OperatorInGeoCircle extends GeographicalOperator<Circle> {

    private OperatorInGeoCircle(String fieldName, Circle circle) {
        super(fieldName, circle);
    }

    public static OperatorInGeoCircle newOperatorInGeoCircle(String fieldName, Circle circle) {
        return new OperatorInGeoCircle(fieldName, circle);
    }

    @Override
    protected Filter geometryRefactor() {
        CircleFilterProtos.CircleFilter.Coordinates centerCoordinates = CircleFilterProtos.CircleFilter.Coordinates.newBuilder().setLongitude(getGeometry().getCircleCenter().getLongitude()).setLatitude(getGeometry().getCircleCenter().getLatitude()).build();
        return CircleFilter.newCircleFilter(Bytes.toBytes(getFieldName()), Bytes.toBytes("longitude"),Bytes.toBytes("latitude"),centerCoordinates, getGeometry().getRadius());
    }

}