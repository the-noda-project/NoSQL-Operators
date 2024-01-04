package gr.ds.unipi.noda.api.parquet.filterOperators.comparisonOperators;

import org.apache.parquet.filter2.predicate.FilterPredicate;
import org.apache.parquet.filter2.predicate.Operators;

import static org.apache.parquet.filter2.predicate.FilterApi.*;

abstract class ComparisonOperator<U> extends gr.ds.unipi.noda.api.core.operators.filterOperators.comparisonOperators.ComparisonOperator<FilterPredicate, U> {
    protected ComparisonOperator(String fieldName, U fieldValue) {
        super(fieldName, fieldValue);
    }

    protected abstract <C extends Operators.Column & Operators.SupportsLtGt, V  extends Comparable> FilterPredicate getOperator1(C column, V value);
//    protected abstract <C extends Operators.Column & Operators.SupportsEqNotEq, V  extends Comparable> FilterPredicate getOperator2(C column, V value);

    @Override
    public FilterPredicate getOperatorExpression() {

        System.out.println("The class is "+ this.getClass());
        if(this.getClass()== OperatorGreaterThanEqual.class ){

            System.out.println("It is");
        }

        if (getFieldValue() instanceof Double) {
            return getOperator1(doubleColumn(getFieldName()), (double) getFieldValue());
        } else if (getFieldValue() instanceof Integer) {
            return getOperator1(intColumn(getFieldName()), (int) getFieldValue());
        } else if (getFieldValue() instanceof Float) {
            return getOperator1(floatColumn(getFieldName()), (float) getFieldValue());
        } else if (getFieldValue() instanceof Short) {
            try {
                throw new Exception("Short type is not supported");
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        } else if (getFieldValue() instanceof Long) {
            return getOperator1(longColumn(getFieldName()), (long) getFieldValue());
        } else if (getFieldValue() instanceof Boolean) {
            if(this.getClass()!= OperatorEqual.class && this.getClass()!= OperatorNotEqual.class ){
                try {
                    throw new Exception("Boolean type is supported only with the equal and not equal operator.");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }else if(this.getClass()== OperatorEqual.class){
                return eq(booleanColumn(getFieldName()), (boolean) getFieldValue());
            }else if(this.getClass()== OperatorNotEqual.class){
                return notEq(booleanColumn(getFieldName()), (boolean) getFieldValue());
            }
            return null;
        } else if (getFieldValue() instanceof String) {
            return getOperator1(binaryColumn(getFieldName()), (String) getFieldValue());
        } else {
            try {
                throw new Exception("Type is not supported");
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }
    }
}
