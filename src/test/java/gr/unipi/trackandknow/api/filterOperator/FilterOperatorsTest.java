package gr.unipi.trackandknow.api.filterOperator;

import org.junit.Test;

public class FilterOperatorsTest {

    @Test
    public void comparisonOperators() {
        System.out.println(FilterOperators.and(FilterOperators.gte("d.y",2),FilterOperators.gte("d",5)).getJsonStringBuilder().toString());
    }

    @Test
    public void geoOperator() {
        //System.out.println(FilterOperators.inGeoBox("location",3,4,5,6).getJsonStringBuilder().toString());
    }


}