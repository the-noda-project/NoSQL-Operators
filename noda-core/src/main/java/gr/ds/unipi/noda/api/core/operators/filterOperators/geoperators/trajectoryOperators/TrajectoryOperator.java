package gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.trajectoryOperators;

import gr.ds.unipi.noda.api.core.operators.filterOperators.FilterOperator;

public abstract class TrajectoryOperator<T> implements FilterOperator<T> {

    private final String fieldName;

    protected TrajectoryOperator(String fieldName) {
        this.fieldName = fieldName;
    }

    public static BaseTrajectoryOperatorFactory trajectoryOperator;

}
