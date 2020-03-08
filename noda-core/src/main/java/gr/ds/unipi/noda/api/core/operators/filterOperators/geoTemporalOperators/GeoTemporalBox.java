package gr.ds.unipi.noda.api.core.operators.filterOperators.geoTemporalOperators;

import gr.ds.unipi.noda.api.core.operators.filterOperators.geoTemporalOperators.geoTemporalGeometry.SingleTemporalValue;
import gr.ds.unipi.noda.api.core.operators.filterOperators.geographicalOperators.Coordinates;
import gr.ds.unipi.noda.api.core.operators.filterOperators.geographicalOperators.geometries.Point;
import gr.ds.unipi.noda.api.core.operators.filterOperators.geographicalOperators.geometries.Polygon;

import java.util.Date;

public class GeoTemporalBox extends GeoTemporalOperator<StringBuilder, Polygon, SingleTemporalValue> {

    protected GeoTemporalBox(String fieldName, String temporalFieldName, TemporalGeometry temporalGeometry) {
        super(fieldName, temporalFieldName, temporalGeometry);

    }

    @Override
    public StringBuilder getOperatorExpression() {
        return null;
    }

    public static GeoTemporalBox newGeoTemporalBox(){

        new GeoTemporalBox().
        TemporalGeometry.newTemporalGeometry(SingleTemporalValue.newSingleTemporalValue(new Date()), Point.newPoint(Coordinates.newCoordinates(1,2)));
    }
}
