package gr.ds.unipi.noda.api.neo4j.filterOperators.geoperators.geoTemporalOperators;

import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.geoTemporalOperators.temporal.TemporalBounds;
import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.geometries.Polygon;
import gr.ds.unipi.noda.api.neo4j.filterOperators.geoperators.geographicalOperators.OperatorInGeographicalPolygon;

final class OperatorInGeoTemporalPolygon extends GeoTemporalOperator<Polygon, TemporalBounds> {

    protected OperatorInGeoTemporalPolygon(String fieldName, Polygon polygon, String temporalFieldName, TemporalBounds temporalType) {
        super(OperatorInGeographicalPolygon.newOperatorInGeographicalPolygon(fieldName, polygon), temporalFieldName, temporalType);
    }

    public static OperatorInGeoTemporalPolygon newOperatorInGeoTemporalPolygon(String fieldName, Polygon polygon, String temporalFieldName, TemporalBounds temporalType) {
        return new OperatorInGeoTemporalPolygon(fieldName, polygon, temporalFieldName, temporalType);
    }

}
