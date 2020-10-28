package gr.ds.unipi.noda.api.mongo.filterOperators.geoperators.geoTemporalOperators;

import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.geoTemporalOperators.temporal.SingleTemporalValue;
import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.geoTemporalOperators.temporal.Temporal;
import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.geoTemporalOperators.temporal.TemporalBounds;
import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.geographicalOperators.GeographicalOperator;
import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.geometries.Geometry;
import gr.ds.unipi.noda.api.mongo.filterOperators.geoperators.geographicalOperators.MongoDBGeographicalOperatorFactory;

import java.text.SimpleDateFormat;

abstract class GeoTemporalOperator<T extends Geometry, U extends Temporal> extends gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.geoTemporalOperators.GeoTemporalOperator<StringBuilder, T, U> {
    protected GeoTemporalOperator(GeographicalOperator<StringBuilder,T> geographicalOperator, String temporalFieldName, U temporalType) {
        super(geographicalOperator, temporalFieldName, temporalType);
    }

    static StringBuilder getTemporalBoundsExpression(String temporalFieldName, TemporalBounds temporalBounds) {
        StringBuilder sb = new StringBuilder();

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

        return sb;
    }

    @Override
    public StringBuilder getOperatorExpression(){

        if (getTemporalType() instanceof TemporalBounds) {

            StringBuilder sb = new StringBuilder();
            sb.append("{ $and: [");
            sb.append(MongoDBGeographicalOperatorFactory.getGeometryExpression(getGeographicalOperator().getFieldName(), getGeographicalOperator().getGeometry()));
            sb.append(", ");
            sb.append(MongoDBGeographicalOperatorFactory.getExpressionOfSpatialHilbertIndexes(getGeographicalOperator().getGeometry().getMbr()));
            sb.append(", ");
            sb.append(getTemporalBoundsExpression(getTemporalFieldName(), (TemporalBounds) getTemporalType()));
            sb.append(" ] }");
            return sb;
        }
        else{
            try {
                throw new Exception(getTemporalType().getClass()+" is not supported on GeoTemporal operators");
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }
    }
}
