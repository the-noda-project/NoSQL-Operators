package gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.geoTextualOperators.geoTextualConstraintOperators;

import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.geoTextualOperators.GeoTextualOperator;
import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.geographicalOperators.GeographicalOperator;
import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.geometries.Geometry;
import gr.ds.unipi.noda.api.core.operators.filterOperators.textualOperators.conditionalTextualOperators.ConditionalTextualOperator;

public abstract class GeoTextualConstraintOperator<T, U extends Geometry> extends GeoTextualOperator<T, U> {

    private final ConditionalTextualOperator conditionalTextualOperator;

    protected GeoTextualConstraintOperator(GeographicalOperator<T, U> geographicalOperator, ConditionalTextualOperator conditionalTextualOperator) {
        super(geographicalOperator);
        this.conditionalTextualOperator = conditionalTextualOperator;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        GeoTextualConstraintOperator<?, ?> that = (GeoTextualConstraintOperator<?, ?>) o;

        return conditionalTextualOperator.equals(that.conditionalTextualOperator);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + conditionalTextualOperator.hashCode();
        return result;
    }

    public ConditionalTextualOperator getConditionalTextualOperator() {
        return conditionalTextualOperator;
    }
}
