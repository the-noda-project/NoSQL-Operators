package gr.ds.unipi.noda.api.couchdb.filterOperators.comparisonOperators;

import gr.ds.unipi.noda.api.couchdb.filterOperators.FilterStrategy;
import org.apache.commons.lang3.StringEscapeUtils;

import java.util.Collections;
import java.util.Date;
import java.util.Map;

abstract class ComparisonOperator<U> extends gr.ds.unipi.noda.api.core.operators.filterOperators.comparisonOperators.ComparisonOperator<FilterStrategy, U> {
    protected ComparisonOperator(String fieldName, U fieldValue) {
        super(fieldName, fieldValue);
    }

    abstract protected String mapOperatorSymbol();

    abstract protected String mangoOperatorSymbol();

    @Override
    public FilterStrategy getOperatorExpression() {
        return new FilterStrategy() {
            @Override
            public String getMapFilter() {
                final String fieldName = "doc[\"" + StringEscapeUtils.escapeEcmaScript(getFieldName()) + "\"]";
                final Object fieldValue = getFieldValue();

                String left, right;
                // Convert dates to epoch time format
                if (fieldValue instanceof Date) {
                    left = "Date.parse(" + fieldName + ")";
                    right = Long.toString(((Date) fieldValue).toInstant().getEpochSecond());
                } else if (fieldValue instanceof String) {
                    left = fieldName;
                    right = '"' + String.valueOf(StringEscapeUtils.escapeEcmaScript((String) fieldValue)) + '"';
                } else {
                    left = fieldName;
                    right = String.valueOf(fieldValue);
                }

                return left + mapOperatorSymbol() + right;
            }

            @Override
            public Map<String, Object> getFindFilter() {
                return Collections.singletonMap(getFieldName(),
                        Collections.singletonMap(mangoOperatorSymbol(), getFieldValue())
                );
            }
        };
    }
}
