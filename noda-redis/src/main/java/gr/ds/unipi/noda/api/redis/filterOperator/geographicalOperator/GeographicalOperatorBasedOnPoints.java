package gr.ds.unipi.noda.api.redis.filterOperator.geographicalOperator;

import gr.ds.unipi.noda.api.core.operators.filterOperators.geographicalOperators.Coordinates;

abstract class GeographicalOperatorBasedOnPoints extends gr.ds.unipi.noda.api.core.operators.filterOperators.geographicalOperators.GeographicalOperatorBasedOnPoints<ZRangeInfo> {
    protected GeographicalOperatorBasedOnPoints(String fieldName, Coordinates[] coordinates) {
        super(fieldName, coordinates);
    }

    protected abstract ZRangeInfo getOperatorField();

    @Override
    public ZRangeInfo getOperatorExpression() {
        return getOperatorField();
    }
}
