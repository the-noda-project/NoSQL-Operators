package com.github.unipi.trackandknow.nosqldbs.aggregate;

import org.junit.Test;

import static org.junit.Assert.*;

public class OperatorMaxTest {

    @Test
    public void newOperatorMax() {
        System.out.println(OperatorMax.newOperatorMax("myfield","mynewField").getJsonString());
    }
}