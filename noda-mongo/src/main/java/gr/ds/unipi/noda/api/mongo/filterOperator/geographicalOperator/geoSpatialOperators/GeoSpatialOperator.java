package gr.ds.unipi.noda.api.mongo.filterOperator.geographicalOperator.geoSpatialOperators;

import gr.ds.unipi.noda.api.core.operators.filterOperators.geographicalOperators.Coordinates;
import gr.ds.unipi.noda.api.core.operators.filterOperators.geographicalOperators.geometries.Geometry;

abstract class GeoSpatialOperator<T extends Geometry> extends gr.ds.unipi.noda.api.core.operators.filterOperators.geographicalOperators.geoSpatialOperators.GeoSpatialOperator<StringBuilder, T> {
    protected GeoSpatialOperator(String fieldName, T geometry) {
        super(fieldName, geometry);
    }

    protected static StringBuilder formOperatorExpressionForMultiPointGeometry(String fieldName, Coordinates[] coordinates){
        StringBuilder sb = new StringBuilder();
        sb.append("{ ");

        if (!fieldName.contains(".")) {
            sb.append(fieldName);
        } else {
            sb.append("\"" + fieldName + "\"");
        }

        sb.append(": { $geoWithin: { $geometry: { type:\"Polygon\", coordinates:[ [");

        for (Coordinates c : coordinates) {
            sb.append(" [");
            sb.append(c.getLongitude());
            sb.append(",");
            sb.append(c.getLatitude());

            sb.append("]");
            sb.append(",");
        }

        //In MongoDB the last point should coincide with the coordinates of the starting point
        sb.append(" [");
        sb.append(coordinates[0].getLongitude());
        sb.append(",");
        sb.append(coordinates[0].getLatitude());
        sb.append("]");

        sb.append("] ] } } } }");

        return sb;
    }

}
