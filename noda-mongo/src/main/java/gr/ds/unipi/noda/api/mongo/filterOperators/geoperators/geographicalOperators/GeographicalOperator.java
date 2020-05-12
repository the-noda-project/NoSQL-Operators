package gr.ds.unipi.noda.api.mongo.filterOperators.geoperators.geographicalOperators;

import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.Coordinates;
import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.geometries.Geometry;

abstract class GeographicalOperator<T extends Geometry> extends gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.geographicalOperators.GeographicalOperator<StringBuilder, T> {
    protected GeographicalOperator(String fieldName, T geometry) {
        super(fieldName, geometry);
    }

    protected static StringBuilder formOperatorExpressionForMultiPointGeometry(String fieldName, Coordinates[] coordinates) {
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
