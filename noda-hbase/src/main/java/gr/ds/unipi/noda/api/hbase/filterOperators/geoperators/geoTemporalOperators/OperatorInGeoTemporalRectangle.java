package gr.ds.unipi.noda.api.hbase.filterOperators.geoperators.geoTemporalOperators;


import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.geoTemporalOperators.temporal.TemporalBounds;
import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.geometries.Rectangle;
import gr.ds.unipi.noda.api.hbase.filterOperators.geoperators.geoTemporalOperators.customFilters.RectangleTemporalFilter;
import gr.ds.unipi.noda.api.hbase.filterOperators.geoperators.geoTemporalOperators.customFilters.generated.RectangleTemporalFilterProtos;
import gr.ds.unipi.noda.api.hbase.filterOperators.geoperators.geographicalOperators.OperatorInGeoRectangle;
import org.apache.hadoop.hbase.filter.Filter;
import org.apache.hadoop.hbase.util.Bytes;

final class OperatorInGeoTemporalRectangle extends GeoTemporalOperator<Rectangle, TemporalBounds> {

    protected OperatorInGeoTemporalRectangle(String fieldName, Rectangle rectangle, String temporalFieldName, TemporalBounds temporalType) {
        super(OperatorInGeoRectangle.newOperatorInGeoRectangle(fieldName, rectangle), temporalFieldName, temporalType);
    }

    public static OperatorInGeoTemporalRectangle newOperatorInGeoTemporalRectangle(String fieldName, Rectangle rectangle, String temporalFieldName, TemporalBounds temporalType) {
        return new OperatorInGeoTemporalRectangle(fieldName, rectangle, temporalFieldName, temporalType);
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

        RectangleTemporalFilterProtos.RectangleTemporalFilter.Coordinates lowerCoordinates = RectangleTemporalFilterProtos.RectangleTemporalFilter.Coordinates.newBuilder().setLongitude(getGeographicalOperator().getGeometry().getLowerBound().getLongitude()).setLatitude(getGeographicalOperator().getGeometry().getLowerBound().getLatitude()).build();
        RectangleTemporalFilterProtos.RectangleTemporalFilter.Coordinates upperCoordinates = RectangleTemporalFilterProtos.RectangleTemporalFilter.Coordinates.newBuilder().setLongitude(getGeographicalOperator().getGeometry().getUpperBound().getLongitude()).setLatitude(getGeographicalOperator().getGeometry().getUpperBound().getLatitude()).build();
        return RectangleTemporalFilter.newRectangleTemporalFilter(Bytes.toBytes(getGeographicalOperator().getFieldName()), Bytes.toBytes("longitude"),Bytes.toBytes("latitude"),lowerCoordinates, upperCoordinates, Bytes.toBytes(temporalNames[0]), Bytes.toBytes(temporalNames[1]), getTemporalType().getLowerBound().getTime(), getTemporalType().getUpperBound().getTime());
    }

}
