package gr.ds.unipi.noda.api.YYYDataBase.filterOperator.geographicalOperators.geoTemporalOperators;

import gr.ds.unipi.noda.api.core.operators.filterOperators.geographicalOperators.geoTemporalOperators.temporal.TemporalBounds;
import gr.ds.unipi.noda.api.core.operators.filterOperators.geographicalOperators.geometries.Polygon;

public class OperatorInGeoTemporalPolygon extends GeoTemporalOperator<Polygon, TemporalBounds> {

    protected OperatorInGeoTemporalPolygon(String fieldName, Polygon polygon, String temporalFieldName, TemporalBounds temporalType) {
        super(fieldName, polygon, temporalFieldName, temporalType);
    }

    public static OperatorInGeoTemporalPolygon newOperatorInGeoTemporalPolygon(String fieldName, Polygon polygon, String temporalFieldName, TemporalBounds temporalType) {
        return new OperatorInGeoTemporalPolygon(fieldName, polygon, temporalFieldName, temporalType);
    }

}
