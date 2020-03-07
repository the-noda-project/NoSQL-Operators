package gr.ds.unipi.noda.api.neo4j.filterOperator.geographicalOperator;

import gr.ds.unipi.noda.api.core.operators.filterOperators.geographicalOperators.Coordinates;

abstract class GeographicalOperatorBasedOnPoints extends gr.ds.unipi.noda.api.core.operators.filterOperators.geographicalOperators.GeographicalOperatorBasedOnPoints<T> {

    protected GeographicalOperatorBasedOnPoints(String fieldName, Coordinates[] coordinates) {
        super(fieldName, coordinates);
    }

    @Override
    public T getOperatorExpression() {

        return null;

    }

}
