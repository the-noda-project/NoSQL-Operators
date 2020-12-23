package gr.ds.unipi.noda.api.hbase.filterOperators.geoperators.geographicalOperators;

import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.Coordinates;
import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.geometries.Polygon;
import gr.ds.unipi.noda.api.hbase.filterOperators.geoperators.geographicalOperators.customFilters.PolygonFilter;
import gr.ds.unipi.noda.api.hbase.filterOperators.geoperators.geographicalOperators.customFilters.generated.PolygonFilterProtos;
import org.apache.hadoop.hbase.filter.Filter;
import org.apache.hadoop.hbase.util.Bytes;

import java.util.ArrayList;
import java.util.List;

public final class OperatorInGeoPolygon extends GeographicalOperator<Polygon> {

    private OperatorInGeoPolygon(String fieldName, Polygon polygon) {
        super(fieldName, polygon);
    }

    @Override
    protected Filter geometryRefactor() {
        List<PolygonFilterProtos.PolygonFilter.Coordinates> coordinatesList = new ArrayList<>();

        for (Coordinates coordinates : getGeometry().getCoordinatesArray()) {
            coordinatesList.add(PolygonFilterProtos.PolygonFilter.Coordinates.newBuilder().setLongitude(coordinates.getLongitude()).setLatitude(coordinates.getLatitude()).build());
        }

        return PolygonFilter.newPolygonFilter(Bytes.toBytes(getFieldName()), Bytes.toBytes("longitude"), Bytes.toBytes("latitude"), coordinatesList);
    }

    public static OperatorInGeoPolygon newOperatorInGeoPolygon(String fieldName, Polygon polygon) {
        return new OperatorInGeoPolygon(fieldName, polygon);
    }


}
