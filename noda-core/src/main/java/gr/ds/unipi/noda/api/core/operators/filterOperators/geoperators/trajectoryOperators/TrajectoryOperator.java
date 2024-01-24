package gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.trajectoryOperators;

import gr.ds.unipi.noda.api.core.operators.filterOperators.FilterOperator;

public abstract class TrajectoryOperator<T> implements FilterOperator<T> {

    private final String objectIdField;
    private final String segmentField;

    protected TrajectoryOperator(String objectIdField, String segmentField) {
        this.objectIdField = objectIdField;
        this.segmentField = segmentField;
    }

    public static BaseTrajectoryOperatorFactory trajectoryOperator;

    protected String getObjectIdField(){
        return objectIdField;
    }

    protected String getSegmentField(){
        return segmentField;
    }
}
