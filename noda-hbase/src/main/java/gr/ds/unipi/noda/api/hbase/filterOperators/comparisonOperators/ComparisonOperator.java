package gr.ds.unipi.noda.api.hbase.filterOperators.comparisonOperators;

import org.apache.hadoop.hbase.CompareOperator;
import org.apache.hadoop.hbase.filter.Filter;
import org.apache.hadoop.hbase.filter.SingleColumnValueFilter;
import org.apache.hadoop.hbase.util.Bytes;

abstract class ComparisonOperator<U> extends gr.ds.unipi.noda.api.core.operators.filterOperators.comparisonOperators.ComparisonOperator<Filter, U> {
    protected ComparisonOperator(String fieldName, U fieldValue) {
        super(fieldName, fieldValue);
    }

    protected abstract CompareOperator getComparisonExpression();

    @SuppressWarnings("unchecked")
    @Override
    public Filter getOperatorExpression() {

        String[] names = getFieldName().split(":");

        if (names.length != 2) {
            try {
                throw new Exception("");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        byte[] value = null;

        if (getFieldValue() instanceof Double) {
            value = Bytes.toBytes((double) (Object) getFieldValue());
        } else if (getFieldValue() instanceof Integer) {
            value = Bytes.toBytes((int) (Object) getFieldValue());
        } else if (getFieldValue() instanceof Float) {
            value = Bytes.toBytes((float) (Object) getFieldValue());
        } else if (getFieldValue() instanceof Short) {
            value = Bytes.toBytes((short) (Object) getFieldValue());
        } else if (getFieldValue() instanceof Long) {
            value = Bytes.toBytes((long) (Object) getFieldValue());
        } else if (getFieldValue() instanceof Boolean) {
            value = Bytes.toBytes((boolean) (Object) getFieldValue());
        } else if (getFieldValue() instanceof String) {
            value = Bytes.toBytes((String) getFieldValue());
        } else {
            try {
                throw new Exception("");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return new SingleColumnValueFilter(Bytes.toBytes(names[0]), Bytes.toBytes(names[1]), getComparisonExpression(), value);
    }
}
