package gr.ds.unipi.noda.api.hbase.filterOperator.geographicalOperators.geoSpatialOperators;

import gr.ds.unipi.noda.api.core.operators.filterOperators.geographicalOperators.Coordinates;
import gr.ds.unipi.noda.api.core.operators.filterOperators.geographicalOperators.geometries.Polygon;
import gr.ds.unipi.noda.api.hbase.filterOperator.geographicalOperators.geoSpatialOperators.customFilters.PolygonFilter;
import gr.ds.unipi.noda.api.hbase.filterOperator.geographicalOperators.geoSpatialOperators.customFilters.generated.FilterProtos;
import org.apache.hadoop.hbase.filter.Filter;
import org.apache.hadoop.hbase.util.Bytes;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

final class OperatorInGeoPolygon extends GeoSpatialOperator<Polygon> {

    private OperatorInGeoPolygon(String fieldName, Polygon polygon) {
        super(fieldName, polygon);
    }

    @Override
    protected Filter geometryRefactor() {
        List<FilterProtos.PolygonFilter.Coordinates> coordinatesList = new ArrayList<>();

        for (Coordinates coordinates : getGeometry().getCoordinatesArray()) {
            coordinatesList.add(FilterProtos.PolygonFilter.Coordinates.newBuilder().setLongitude(coordinates.getLongitude()).setLatitude(coordinates.getLatitude()).build());
        }

        return PolygonFilter.newPolygonFilter(Bytes.toBytes(getFieldName()),Bytes.toBytes("lon"),Bytes.toBytes("lat"),coordinatesList);
    }

    public static OperatorInGeoPolygon newOperatorInGeoPolygon(String fieldName, Polygon polygon) {
        return new OperatorInGeoPolygon(fieldName, polygon);
    }


}
