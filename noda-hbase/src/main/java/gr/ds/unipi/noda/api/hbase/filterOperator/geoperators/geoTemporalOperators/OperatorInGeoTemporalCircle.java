package gr.ds.unipi.noda.api.hbase.filterOperator.geoperators.geoTemporalOperators;

import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.geoTemporalOperators.temporal.TemporalBounds;
import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.geometries.Circle;
import gr.ds.unipi.noda.api.hbase.filterOperator.geoperators.geoTemporalOperators.customFilters.CircleTemporalFilter;
import gr.ds.unipi.noda.api.hbase.filterOperator.geoperators.geoTemporalOperators.customFilters.generated.CircleTemporalFilterProtos;
import gr.ds.unipi.noda.api.hbase.filterOperator.geoperators.geographicalOperators.OperatorInGeoCircle;
import gr.ds.unipi.noda.api.hbase.filterOperator.geoperators.geographicalOperators.customFilters.CircleFilter;
import gr.ds.unipi.noda.api.hbase.filterOperator.geoperators.geographicalOperators.customFilters.generated.CircleFilterProtos;
import org.apache.hadoop.hbase.filter.Filter;
import org.apache.hadoop.hbase.util.Bytes;

final class OperatorInGeoTemporalCircle extends GeoTemporalOperator<Circle, TemporalBounds> {

    protected OperatorInGeoTemporalCircle(String fieldName, Circle circle, String temporalFieldName, TemporalBounds temporalType) {
        super(OperatorInGeoCircle.newOperatorInGeoCircle(fieldName, circle), temporalFieldName, temporalType);
    }

    public static OperatorInGeoTemporalCircle newOperatorInGeoTemporalCircle(String fieldName, Circle circle, String temporalFieldName, TemporalBounds temporalType) {
        return new OperatorInGeoTemporalCircle(fieldName, circle, temporalFieldName, temporalType);
    }

    @Override
    protected Filter geometryRefactor() {

        String[] temporalNames = getTemporalFieldName().split(":");

        if (temporalNames.length != 2) {
            try {
                throw new Exception("");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        CircleTemporalFilterProtos.CircleTemporalFilter.Coordinates centerCoordinates = CircleTemporalFilterProtos.CircleTemporalFilter.Coordinates.newBuilder().setLongitude(getGeographicalOperator().getGeometry().getCircleCenter().getLongitude()).setLatitude(getGeographicalOperator().getGeometry().getCircleCenter().getLatitude()).build();
        return CircleTemporalFilter.newCircleTemporalFilter(Bytes.toBytes(getGeographicalOperator().getFieldName()), Bytes.toBytes("longitude"),Bytes.toBytes("latitude"),centerCoordinates, getGeographicalOperator().getGeometry().getRadius(), Bytes.toBytes(temporalNames[0]), Bytes.toBytes(temporalNames[1]), getTemporalType().getLowerBound().getTime(), getTemporalType().getUpperBound().getTime());
    }

}
