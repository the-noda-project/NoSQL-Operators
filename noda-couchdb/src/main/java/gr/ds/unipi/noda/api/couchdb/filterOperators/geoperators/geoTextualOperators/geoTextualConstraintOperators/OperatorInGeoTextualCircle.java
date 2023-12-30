package gr.ds.unipi.noda.api.couchdb.filterOperators.geoperators.geoTextualOperators.geoTextualConstraintOperators;

import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.geometries.Circle;
import gr.ds.unipi.noda.api.core.operators.filterOperators.textualOperators.conditionalTextualOperators.ConditionalTextualOperator;
import gr.ds.unipi.noda.api.couchdb.filterOperators.FilterStrategy;
import gr.ds.unipi.noda.api.couchdb.filterOperators.geoperators.geographicalOperators.OperatorInGeoCircle;

public class OperatorInGeoTextualCircle extends GeoTextualConstraintOperator<Circle> {
    protected OperatorInGeoTextualCircle(String fieldName, Circle circle, ConditionalTextualOperator<FilterStrategy> conditionalTextualOperator) {
        super(OperatorInGeoCircle.newOperatorInGeoCircle(fieldName, circle), conditionalTextualOperator);
    }

    public static OperatorInGeoTextualCircle newOperatorInGeoTextualCircle(String fieldName, Circle circle, ConditionalTextualOperator<FilterStrategy> conditionalTextualOperator) {
        return new OperatorInGeoTextualCircle(fieldName, circle, conditionalTextualOperator);
    }
}
