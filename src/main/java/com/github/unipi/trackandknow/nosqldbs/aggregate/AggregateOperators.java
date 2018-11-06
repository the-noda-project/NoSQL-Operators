package com.github.unipi.trackandknow.nosqldbs.aggregate;

import com.github.unipi.trackandknow.nosqldbs.filteroperator.FilterOperator;
import com.github.unipi.trackandknow.nosqldbs.filteroperator.comparison.OperatorGreaterThanEqual;
import com.github.unipi.trackandknow.nosqldbs.filteroperator.logical.OperatorAnd;
import com.github.unipi.trackandknow.nosqldbs.filteroperator.logical.OperatorOr;

public class AggregateOperators {

    public static AggregateOperator max(String fieldName) {
        return OperatorMax.newOperatorMax(fieldName);
    }

    public static AggregateOperator max(String fieldName, String newFieldName) {
        return OperatorMax.newOperatorMax(fieldName, newFieldName);
    }

}
