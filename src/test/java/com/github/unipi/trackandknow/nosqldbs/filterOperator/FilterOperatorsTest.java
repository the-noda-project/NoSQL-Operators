package com.github.unipi.trackandknow.nosqldbs.filterOperator;

import org.junit.Test;

public class FilterOperatorsTest {

    @Test
    public void comparisonOperators() {
        System.out.println(FilterOperators.and(FilterOperators.gte("d.y",2),FilterOperators.gte("d",5)).getJsonString());
    }

    @Test
    public void geoOperator() {
        System.out.println(FilterOperators.inGeoBox("location",3,4,5,6).getJsonString());
    }


}