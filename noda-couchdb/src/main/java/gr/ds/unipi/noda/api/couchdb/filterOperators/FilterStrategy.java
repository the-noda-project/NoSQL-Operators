package gr.ds.unipi.noda.api.couchdb.filterOperators;

import java.util.Map;

public interface FilterStrategy {
    CharSequence getMapFilter();
    Map<String, Object> getFindFilter();
}
