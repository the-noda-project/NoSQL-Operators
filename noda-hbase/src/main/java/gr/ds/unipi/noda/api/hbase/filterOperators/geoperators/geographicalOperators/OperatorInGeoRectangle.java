package gr.ds.unipi.noda.api.hbase.filterOperators.geoperators.geographicalOperators;

import gr.ds.unipi.noda.api.core.config.AppConfig;
import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.geometries.Rectangle;
import gr.ds.unipi.noda.api.hbase.filterOperators.geoperators.geographicalOperators.customFilters.RectangleFilter;
import gr.ds.unipi.noda.api.hbase.filterOperators.geoperators.geographicalOperators.customFilters.generated.RectangleFilterProtos;
import org.apache.hadoop.hbase.filter.Filter;
import org.apache.hadoop.hbase.util.Bytes;

public final class OperatorInGeoRectangle extends GeographicalOperator<Rectangle> {

    private OperatorInGeoRectangle(String fieldName, Rectangle rectangle) {
        super(fieldName, rectangle);
    }

    public static OperatorInGeoRectangle newOperatorInGeoRectangle(String fieldName, Rectangle rectangle) {
        return new OperatorInGeoRectangle(fieldName, rectangle);
    }

    @Override
    protected Filter geometryRefactor() {

        RectangleFilterProtos.RectangleFilter.Coordinates lowerCoordinates = RectangleFilterProtos.RectangleFilter.Coordinates.newBuilder().setLongitude(getGeometry().getLowerBound().getLongitude()).setLatitude(getGeometry().getLowerBound().getLatitude()).build();
        RectangleFilterProtos.RectangleFilter.Coordinates upperCoordinates = RectangleFilterProtos.RectangleFilter.Coordinates.newBuilder().setLongitude(getGeometry().getUpperBound().getLongitude()).setLatitude(getGeometry().getUpperBound().getLatitude()).build();
        return RectangleFilter.newRectangleFilter(Bytes.toBytes(getFieldName()), Bytes.toBytes(AppConfig.hbase().getString("spatialOp.longitudeQualifier")), Bytes.toBytes(AppConfig.hbase().getString("spatialOp.latitudeQualifier")), lowerCoordinates, upperCoordinates);
    }

}
