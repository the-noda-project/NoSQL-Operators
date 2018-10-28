package com.github.unipi.trackandknow.nosqldbs;


import com.sun.istack.internal.Nullable;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class ConditionOperator {

    private final ConditionOperatorType conditionOperatorType;
    private final List<ConditionOperator> conditionOperatorChildren;
    private final String fieldName;
    private final T value;

    public ConditionOperatorType getConditionOperatorType() {
        return conditionOperatorType;
    }

    public List<ConditionOperator> getConditionOperatorChildren() {
        return conditionOperatorChildren;
    }

    public String getFieldName() {
        return fieldName;
    }

    public T getValue() {
        return value;
    }

    private ConditionOperator(ConditionOperatorType conditionOperatorType, @Nullable List<ConditionOperator> conditionOperatorChildren, @Nullable String fieldName, @Nullable T value){

        this.conditionOperatorType = conditionOperatorType;
        this.conditionOperatorChildren = conditionOperatorChildren;
        this.fieldName = fieldName;
        this.value = value;
    }


    public static <T> ConditionOperator<T> gte(String fieldName, T value){
        return new ConditionOperator<T>(ConditionOperatorType.GTE, null, fieldName, value);
    }

    public static ConditionOperator and(ConditionOperator... conditionOperator){
        check(conditionOperator);
        return new ConditionOperator(ConditionOperatorType.AND, Collections.unmodifiableList(Arrays.asList(conditionOperator)), null, null);
    }

    private static void check(ConditionOperator... conditionOperator){
        if(conditionOperator.length<2){
            try {
                throw new Exception("Less than two children");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
