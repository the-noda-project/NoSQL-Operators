package gr.ds.unipi.noda.api.mongo.filterOperator.geographicalOperator.geoTemporalOperators;

import gr.ds.unipi.noda.api.core.operators.filterOperators.geographicalOperators.geoTemporalOperators.temporal.Temporal;
import gr.ds.unipi.noda.api.core.operators.filterOperators.geographicalOperators.geoTemporalOperators.temporal.TemporalBounds;
import gr.ds.unipi.noda.api.core.operators.filterOperators.geographicalOperators.geometries.Geometry;

import java.text.SimpleDateFormat;

abstract class GeoTemporalOperator<T extends Geometry, U extends Temporal> extends gr.ds.unipi.noda.api.core.operators.filterOperators.geographicalOperators.geoTemporalOperators.GeoTemporalOperator<StringBuilder, T, U> {
    protected GeoTemporalOperator(String fieldName, T geometry, String temporalFieldName, U temporalType) {
        super(fieldName, geometry, temporalFieldName, temporalType);
    }

    static StringBuilder formGeometryAndTemporalBoundsExpression(StringBuilder geometryExpr, String temporalFieldName, TemporalBounds temporalBounds){
        StringBuilder sb = new StringBuilder();

        sb.append("{ $");
        sb.append("and");
        sb.append(": [ ");

        sb.append(geometryExpr);
        sb.append(", ");

        sb.append("{ ");
        if (!temporalFieldName.contains(".")) {
            sb.append(temporalFieldName);
        } else {
            sb.append("\"" + temporalFieldName + "\"");
        }
        sb.append(": { ");
        sb.append("$gte: ");
        sb.append("new Date(\"" + new SimpleDateFormat("EEE MMM dd yyyy HH:mm:ss z").format(temporalBounds.getLowerBound()) + "\")");
        sb.append(", $lte: ");
        sb.append("new Date(\"" + new SimpleDateFormat("EEE MMM dd yyyy HH:mm:ss z").format(temporalBounds.getUpperBound()) + "\")");
        sb.append("} }");

        sb.append(" ] }");
        return sb;
    }

}
