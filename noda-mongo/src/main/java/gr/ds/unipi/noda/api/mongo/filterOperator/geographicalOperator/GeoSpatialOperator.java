package gr.ds.unipi.noda.api.mongo.filterOperator.geographicalOperator;

import gr.ds.unipi.noda.api.core.operators.filterOperators.geographicalOperators.Coordinates;
import gr.ds.unipi.noda.api.core.operators.filterOperators.geographicalOperators.geometries.Geometry;

abstract class GeoSpatialOperator<T extends Geometry> extends gr.ds.unipi.noda.api.core.operators.filterOperators.geoSpatialOperators.GeoSpatialOperator<StringBuilder, T> {
    protected GeoSpatialOperator(String fieldName, T geometry) {
        super(fieldName, geometry);
    }

    public StringBuilder getOperatorExpressionForPolygonAndRectangle(){
        StringBuilder sb = new StringBuilder();
        sb.append("{ ");

        if (!getFieldName().contains(".")) {
            sb.append(getFieldName());
        } else {
            sb.append("\"" + getFieldName() + "\"");
        }

        sb.append(": { $geoWithin: { $geometry: { type:\"Polygon\", coordinates:[ [");

        for (Coordinates c : getGeometry().getCoordinatesArray()) {
            sb.append(" [");
            sb.append(c.getLongitude());
            sb.append(",");
            sb.append(c.getLatitude());

            sb.append("]");
            sb.append(",");
        }

        //In MongoDB the last point should coincide with the coordinates of the starting point
        sb.append(" [");
        sb.append(getGeometry().getCoordinatesArray()[0].getLongitude());
        sb.append(",");
        sb.append(getGeometry().getCoordinatesArray()[0].getLatitude());
        sb.append("]");

        sb.append("] ] } } } }");

        return sb;
    }

}
