package gr.unipi.noda.api.mongo.filterOperator.geographicalOperator;

import gr.unipi.noda.api.core.operators.filterOperators.geographicalOperators.Coordinates;

abstract class GeographicalOperatorBasedOnSinglePoint extends gr.unipi.noda.api.core.operators.filterOperators.geographicalOperators.GeographicalOperatorBasedOnSinglePoint<StringBuilder> {

    protected GeographicalOperatorBasedOnSinglePoint(String fieldName, Coordinates point) {
        super(fieldName, point);
    }

}
