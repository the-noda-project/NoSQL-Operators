package gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.geoTemporalOperators.temporal;

import java.util.Arrays;
import java.util.Date;

public abstract class Temporal {

    private final Date[] dates;

    protected Temporal(Date[] dates) {
        this.dates = dates;
    }

    protected Date[] getDates() {
        return dates;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Temporal temporal = (Temporal) o;

        // Probably incorrect - comparing Object[] arrays with Arrays.equals
        return Arrays.equals(dates, temporal.dates);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(dates);
    }
}
