package gr.ds.unipi.noda.api.core.operators.filterOperators.logicalOperators;

import gr.ds.unipi.noda.api.core.operators.filterOperators.FilterOperator;

import java.util.Arrays;

public abstract class LogicalOperator<T> implements FilterOperator<T> {

    private FilterOperator[] filterOperatorChildren;//a set method has been added because redis module modifies children

    protected LogicalOperator(FilterOperator filterOperator1, FilterOperator filterOperator2, FilterOperator... filterOperators) {
//        checkNumberOfChildrenCondition(filterOperatorChildren);
//        this.filterOperatorChildren = filterOperatorChildren;

        if (filterOperators.length == 0) {
            filterOperatorChildren = new FilterOperator[]{filterOperator1, filterOperator2};
        } else {
            filterOperatorChildren = new FilterOperator[filterOperators.length + 2];
            filterOperatorChildren[0] = filterOperator1;
            filterOperatorChildren[1] = filterOperator2;

            int i = 2;
            for (FilterOperator fops : filterOperators) {
                filterOperatorChildren[i++] = fops;
            }
        }

    }

    protected void setFilterOperatorChildren(FilterOperator[] filterOperatorChildren) {
        this.filterOperatorChildren = filterOperatorChildren;
    }

    protected FilterOperator[] getFilterOperatorChildren() {
        return filterOperatorChildren;
    }

    public static BaseLogicalOperatorFactory logicalOperator;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LogicalOperator<?> that = (LogicalOperator<?>) o;

        // Probably incorrect - comparing Object[] arrays with Arrays.equals
        return Arrays.equals(filterOperatorChildren, that.filterOperatorChildren);
    }

    @Override
    public int hashCode() {
        int result = Arrays.hashCode(filterOperatorChildren);
        result = 31 * result + getClass().hashCode();
        return result;
    }

//    private void checkNumberOfChildrenCondition(FilterOperator... filterOperatorChildren) {
//        if (filterOperatorChildren.length < 2) {
//            try {
//                throw new Exception("Less than two children");
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
//    }

}
