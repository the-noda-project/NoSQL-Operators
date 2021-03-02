package gr.ds.unipi.noda.api.hbase.filterOperators.geoperators.geoTemporalOperators;

import gr.ds.unipi.noda.api.core.constants.Commons;
import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.geoTemporalOperators.BaseGeoTemporalOperatorFactory;
import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.geoTemporalOperators.temporal.TemporalBounds;
import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.geometries.*;
import gr.ds.unipi.noda.api.hbase.filterOperators.geoperators.geographicalOperators.HBaseGeographicalOperatorFactory;

import java.util.Date;

public final class HBaseGeoTemporalOperatorFactory extends BaseGeoTemporalOperatorFactory {
    @Override
    public GeoTemporalOperator newOperatorInGeoTemporalPolygon(String fieldName, Polygon polygon, String temporalFieldName, TemporalBounds temporalBounds) {
        return OperatorInGeoTemporalPolygon.newOperatorInGeoTemporalPolygon(fieldName, polygon, temporalFieldName, temporalBounds);
    }

    @Override
    public GeoTemporalOperator newOperatorInGeoTemporalRectangle(String fieldName, Rectangle rectangle, String temporalFieldName, TemporalBounds temporalBounds) {
        return OperatorInGeoTemporalRectangle.newOperatorInGeoTemporalRectangle(fieldName, rectangle, temporalFieldName, temporalBounds);
    }

    @Override
    public GeoTemporalOperator newOperatorInGeoTemporalCircleKm(String fieldName, Circle circle, String temporalFieldName, TemporalBounds temporalBounds) {
        return OperatorInGeoTemporalCircle.newOperatorInGeoTemporalCircle(fieldName, circle, temporalFieldName, temporalBounds);
    }

    @Override
    public GeoTemporalOperator newOperatorInGeoTemporalCircleMeters(String fieldName, Circle circle, String temporalFieldName, TemporalBounds temporalBounds) {
        return OperatorInGeoTemporalCircle.newOperatorInGeoTemporalCircle(fieldName, circle, temporalFieldName, temporalBounds);
    }

    @Override
    public GeoTemporalOperator newOperatorInGeoTemporalCircleMiles(String fieldName, Circle circle, String temporalFieldName, TemporalBounds temporalBounds) {
        return OperatorInGeoTemporalCircle.newOperatorInGeoTemporalCircle(fieldName, circle, temporalFieldName, temporalBounds);
    }

    @Override
    public GeoTemporalOperator newOperatorGeoTemporalNearestNeighbors(String fieldName, Point point, int neighbors) {
        return null;
    }

    public static String getGeoHashPart(Geometry geometry) {

        int length = 5;
        String geoHash = HBaseGeographicalOperatorFactory.getGeoHashPart(geometry);

        return String.format("%-" + length + "s", geoHash).replace(' ', '?');
    }

    public static String getTemporalPart(Date lowerDate, Date upperDate) {
        return String.format("%-13s", Commons.commonPrefix(String.valueOf(lowerDate.getTime()), String.valueOf(upperDate.getTime()))).replace(' ', '?');
    }
}
