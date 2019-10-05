package gr.unipi.noda.api.mongo.filterOperator.geographicalOperator;

import gr.unipi.noda.api.core.operators.filterOperators.geographicalOperators.Coordinates;

public abstract class GeographicalOperatorBasedOnPoints extends gr.unipi.noda.api.core.operators.filterOperators.geographicalOperators.GeographicalOperatorBasedOnPoints<StringBuilder> {

    protected GeographicalOperatorBasedOnPoints(String fieldName, Coordinates[] coordinates) {
        super(fieldName, coordinates);
    }

    @Override
    public StringBuilder getOperatorExpression() {

        StringBuilder sb = new StringBuilder();
        sb.append("{ ");

        if (!getFieldName().contains(".")) {
            sb.append(getFieldName());
        } else {
            sb.append("\"" + getFieldName() + "\"");
        }

        sb.append(": { $geoWithin: { $geometry: { type:\"Polygon\", coordinates:[ [");

        for (Coordinates c : getCoordinatesArray()) {
            sb.append(" [");
            sb.append(c.getLongitude());
            sb.append(",");
            sb.append(c.getLatitude());

            sb.append("]");
            sb.append(",");
        }

        //In MongoDB the last point should coincide with the coordinates of the starting point
        sb.append(" [");
        sb.append(getCoordinatesArray()[0].getLongitude());
        sb.append(",");
        sb.append(getCoordinatesArray()[0].getLatitude());
        sb.append("]");

        sb.append("] ] } } } }");

        return sb;

    }

}
