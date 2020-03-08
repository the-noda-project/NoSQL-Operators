package gr.ds.unipi.noda.api.core.operators.filterOperators.geoTemporalOperators.geoTemporalGeometry;

import java.util.Date;

public class SingleTemporalValue  extends Temporal{

    private SingleTemporalValue(Date[] dates) {
        super(dates);
    }

    public static SingleTemporalValue newSingleTemporalValue(Date date){
        return new SingleTemporalValue(new Date[]{date});
    }

    public Date getSingleTemporalValue(){
        return getDates()[0];
    }
}
