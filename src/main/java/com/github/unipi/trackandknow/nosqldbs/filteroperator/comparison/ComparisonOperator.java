package com.github.unipi.trackandknow.nosqldbs.filteroperator.comparison;

import com.github.unipi.trackandknow.nosqldbs.filteroperator.FilterOperator;

public interface ComparisonOperator<T> extends FilterOperator {
    String getFieldName();
    T getFieldValue();

}
