package gr.ds.unipi.noda.api.cassandra.filterOperators.geoperators.geoTextualOperators.geoTextualConstraintOperators;

import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.geographicalOperators.GeographicalOperator;
import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.geometries.Geometry;
import gr.ds.unipi.noda.api.core.operators.filterOperators.textualOperators.conditionalTextualOperators.ConditionalTextualOperator;

import java.util.ArrayList;

public abstract class GeoTextualConstraintOperator<U extends Geometry> extends gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.geoTextualOperators.geoTextualConstraintOperators.GeoTextualConstraintOperator<Object,U> {

    protected GeoTextualConstraintOperator(GeographicalOperator<Object, U> geographicalOperator, ConditionalTextualOperator conditionalTextualOperator) {
        super(geographicalOperator, conditionalTextualOperator);
    }

    @Override
    public ArrayList<String> getOperatorExpression() {
        ArrayList<String> operation = new ArrayList<>();
        operation.add(((StringBuilder)getGeographicalOperator().getOperatorExpression()).toString());
        operation.add(((StringBuilder)getConditionalTextualOperator().getOperatorExpression()).toString());
        return operation;
    }
}
