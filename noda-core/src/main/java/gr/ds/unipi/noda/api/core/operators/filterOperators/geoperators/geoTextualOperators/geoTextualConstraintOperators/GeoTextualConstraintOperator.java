package gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.geoTextualOperators.geoTextualConstraintOperators;

import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.geoTextualOperators.GeoTextualOperator;
import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.geographicalOperators.GeographicalOperator;
import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.geometries.Geometry;
import gr.ds.unipi.noda.api.core.operators.filterOperators.textualOperators.conditionalTextualOperators.ConditionalTextualOperator;

public abstract class GeoTextualConstraintOperator<T,U extends Geometry> extends GeoTextualOperator<T,U> {

    private final ConditionalTextualOperator conditionalTextualOperator;

    protected GeoTextualConstraintOperator(GeographicalOperator<T, U> geographicalOperator, ConditionalTextualOperator conditionalTextualOperator) {
        super(geographicalOperator);
        this.conditionalTextualOperator = conditionalTextualOperator;
    }

    public ConditionalTextualOperator getConditionalTextualOperator() {
        return conditionalTextualOperator;
    }
}
