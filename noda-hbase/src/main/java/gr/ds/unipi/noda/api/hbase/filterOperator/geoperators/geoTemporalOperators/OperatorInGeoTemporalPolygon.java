package gr.ds.unipi.noda.api.hbase.filterOperator.geoperators.geoTemporalOperators;

import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.Coordinates;
import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.geoTemporalOperators.temporal.TemporalBounds;
import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.geometries.Polygon;
import gr.ds.unipi.noda.api.hbase.filterOperator.geoperators.geoTemporalOperators.customFilters.PolygonTemporalFilter;
import gr.ds.unipi.noda.api.hbase.filterOperator.geoperators.geoTemporalOperators.customFilters.generated.PolygonTemporalFilterProtos;
import gr.ds.unipi.noda.api.hbase.filterOperator.geoperators.geographicalOperators.OperatorInGeoPolygon;
import gr.ds.unipi.noda.api.hbase.filterOperator.geoperators.geographicalOperators.customFilters.PolygonFilter;
import gr.ds.unipi.noda.api.hbase.filterOperator.geoperators.geographicalOperators.customFilters.generated.PolygonFilterProtos;
import org.apache.hadoop.hbase.filter.Filter;
import org.apache.hadoop.hbase.util.Bytes;

import java.util.ArrayList;
import java.util.List;

final class OperatorInGeoTemporalPolygon extends GeoTemporalOperator<Polygon, TemporalBounds> {

    protected OperatorInGeoTemporalPolygon(String fieldName, Polygon polygon, String temporalFieldName, TemporalBounds temporalType) {
        super(OperatorInGeoPolygon.newOperatorInGeoPolygon(fieldName, polygon), temporalFieldName, temporalType);
    }

    public static OperatorInGeoTemporalPolygon newOperatorInGeoTemporalPolygon(String fieldName, Polygon polygon, String temporalFieldName, TemporalBounds temporalType) {
        return new OperatorInGeoTemporalPolygon(fieldName, polygon, temporalFieldName, temporalType);
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

        List<PolygonTemporalFilterProtos.PolygonTemporalFilter.Coordinates> coordinatesList = new ArrayList<>();

        for (Coordinates coordinates : getGeographicalOperator().getGeometry().getCoordinatesArray()) {
            coordinatesList.add(PolygonTemporalFilterProtos.PolygonTemporalFilter.Coordinates.newBuilder().setLongitude(coordinates.getLongitude()).setLatitude(coordinates.getLatitude()).build());
        }

        return PolygonTemporalFilter.newPolygonTemporalFilter(Bytes.toBytes(getGeographicalOperator().getFieldName()),Bytes.toBytes("lon"),Bytes.toBytes("lat"),coordinatesList, Bytes.toBytes(temporalNames[0]), Bytes.toBytes(temporalNames[1]), getTemporalType().getLowerBound().getTime(), getTemporalType().getUpperBound().getTime());
    }

}
