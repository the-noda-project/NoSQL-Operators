package gr.ds.unipi.noda.api.couchdb.filterOperators.geoperators.geoTextualOperators.geoTextualConstraintOperators;

import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.geographicalOperators.GeographicalOperator;
import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.geometries.Geometry;
import gr.ds.unipi.noda.api.core.operators.filterOperators.textualOperators.conditionalTextualOperators.ConditionalTextualOperator;
import gr.ds.unipi.noda.api.couchdb.filterOperators.FilterStrategy;

import java.util.Arrays;
import java.util.Collections;
import java.util.Map;

public abstract class GeoTextualConstraintOperator<U extends Geometry> extends gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.geoTextualOperators.geoTextualConstraintOperators.GeoTextualConstraintOperator<FilterStrategy, U> {
    protected GeoTextualConstraintOperator(GeographicalOperator<FilterStrategy, U> geographicalOperator, ConditionalTextualOperator<FilterStrategy> conditionalTextualOperator) {
        super(geographicalOperator, conditionalTextualOperator);
    }

    @Override
    public FilterStrategy getOperatorExpression() {
        final FilterStrategy textualOperator = (FilterStrategy) getConditionalTextualOperator().getOperatorExpression();
        final FilterStrategy geographicalOperator = getGeographicalOperator().getOperatorExpression();

        return new FilterStrategy() {
            @Override
            public CharSequence asMapFilter() {
                return geographicalOperator.asMapFilter() + "&&" + textualOperator.asMapFilter();
            }

            @Override
            public Map<String, Object> asFindFilter() {
                return Collections.singletonMap("$and",
                        Arrays.asList(geographicalOperator.asFindFilter(), textualOperator.asFindFilter())
                );
            }
        };
    }
}
