package com.github.unipi.trackandknow.nosqldbs.aggregateOperator;

import org.junit.Test;

public class OperatorMaxTest {

    @Test
    public void newOperatorMax() {
        System.out.println(OperatorMax.newOperatorMax("myfield").getOperatorJsonField());
    }
}