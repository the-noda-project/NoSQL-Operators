package gr.ds.unipi.noda.api.core.operators.filterOperators.geographicalOperators.geoTemporalOperators.temporal;

import java.util.Date;

public class TemporalBounds extends Temporal {

    protected TemporalBounds(Date[] dates) {
        super(dates);
    }

    public static TemporalBounds newTemporalBounds(Date lowerBound, Date upperBound){
        if(lowerBound.after(upperBound)){
            try {
                throw new Exception("Lower date bound is after the Upper date bound");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return new TemporalBounds(new Date[]{lowerBound, upperBound});
    }

    public Date getLowerBound(){
        return getDates()[0];
    }
    public Date getUpperBound(){
        return getDates()[1];
    }
}
