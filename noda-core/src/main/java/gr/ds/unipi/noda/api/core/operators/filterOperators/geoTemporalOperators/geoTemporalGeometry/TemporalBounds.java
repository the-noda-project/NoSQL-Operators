package gr.ds.unipi.noda.api.core.operators.filterOperators.geoTemporalOperators.geoTemporalGeometry;

import java.util.Date;

public class TemporalBounds extends Temporal {

    protected TemporalBounds(Date[] dates) {
        super(dates);
    }

    public static TemporalBounds newTemporalBounds(Date lowerBound, Date upperBound){
        return new TemporalBounds(new Date[]{lowerBound, upperBound});
    }

    public Date getLowerBound(){
        return getDates()[0];
    }
    public Date getUpperBound(){
        return getDates()[1];
    }
}
