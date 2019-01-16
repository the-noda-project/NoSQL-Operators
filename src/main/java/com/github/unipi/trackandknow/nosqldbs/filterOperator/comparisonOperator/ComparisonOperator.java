package com.github.unipi.trackandknow.nosqldbs.filterOperator.comparisonOperator;

import com.github.unipi.trackandknow.nosqldbs.filterOperator.FilterOperator;

import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class ComparisonOperator<T> implements FilterOperator {

    private final String fieldName;
    private final T fieldValue;

    protected ComparisonOperator(String fieldName, T fieldValue) {
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
    }

    protected abstract String getOperatorJsonField();

    @Override
    public StringBuilder getJsonStringBuilder() {
        StringBuilder sb = new StringBuilder();
        sb.append("{ ");

        if (!getFieldName().contains(".")) {
            sb.append(getFieldName());
        } else {
            sb.append("\"" + getFieldName() + "\"");
        }

        sb.append(": { $");
        sb.append(getOperatorJsonField());
        sb.append(": ");

        if ((getFieldValue().getClass() == String.class)) {
            sb.append("\"" + getFieldValue() + "\"");
        }
        else if((getFieldValue().getClass() == Date.class)){


            sb.append("new Date(\"" + new SimpleDateFormat("EEE MMM dd yyyy HH:mm:ss z").format(getFieldValue()) + "\")");
        }
        else  {
            sb.append("\""+getFieldValue()+"\"");
        }

        sb.append("} }");

        return sb;

    }

    public String getFieldName() {
        return fieldName;
    }

    public T getFieldValue() {
        return fieldValue;
    }
}
