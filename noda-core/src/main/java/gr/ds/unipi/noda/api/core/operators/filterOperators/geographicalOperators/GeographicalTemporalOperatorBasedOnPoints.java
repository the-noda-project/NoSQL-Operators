package gr.ds.unipi.noda.api.core.operators.filterOperators.geographicalOperators;

import java.util.Date;

public abstract class GeographicalTemporalOperatorBasedOnPoints extends GeographicalTemporalOperator {

    protected GeographicalTemporalOperatorBasedOnPoints(String temporalFieldName, Date[] dateArray, String fieldName, Coordinates... coordinatesArray) {
        super(temporalFieldName, dateArray, fieldName, coordinatesArray);
        checkCoordinates();
    }

    @Override
    protected void checkCoordinates() {
        if (getCoordinatesArray().length < 3) {
            try {
                throw new Exception("Three points-coordinates should be defined at least for the formation of GeographicalOperatorBasedOnPoints Operator");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
