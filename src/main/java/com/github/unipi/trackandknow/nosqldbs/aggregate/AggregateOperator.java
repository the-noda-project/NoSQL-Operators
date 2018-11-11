package com.github.unipi.trackandknow.nosqldbs.aggregate;

import com.github.unipi.trackandknow.nosqldbs.Operator;

public interface AggregateOperator extends Operator {

    AggregateOperator as(String alias);

}
