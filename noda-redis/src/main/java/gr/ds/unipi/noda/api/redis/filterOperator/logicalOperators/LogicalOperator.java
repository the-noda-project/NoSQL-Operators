package gr.ds.unipi.noda.api.redis.filterOperator.logicalOperators;

import gr.ds.unipi.noda.api.core.operators.Operator;
import gr.ds.unipi.noda.api.core.operators.filterOperators.FilterOperator;
import gr.ds.unipi.noda.api.redis.filterOperator.RandomStringGenerator;

import java.util.*;

abstract class LogicalOperator extends gr.ds.unipi.noda.api.core.operators.filterOperators.logicalOperators.LogicalOperator<List<Map.Entry<Operator, String[]>>> {
    protected LogicalOperator(FilterOperator filterOperator1, FilterOperator filterOperator2, FilterOperator... filterOperators) {
        super(filterOperator1, filterOperator2, filterOperators);
    }

    @Override
    public List<Map.Entry<Operator, String[]>> getOperatorExpression() {

        List<Map.Entry<Operator, String[]>> list = new ArrayList<>();
        String[] temporaryListsName = new String[this.getFilterOperatorChildren().length + 1];
        temporaryListsName[0] = RandomStringGenerator.randomCharacterNumericString();

        for (int i = 0; i < this.getFilterOperatorChildren().length; i++) {
            list.addAll((Collection) getFilterOperatorChildren()[i].getOperatorExpression());

            int sizeOfChildList = ((List<Map.Entry<Operator, String[]>>) getFilterOperatorChildren()[i].getOperatorExpression()).size();
            Map.Entry<Operator, String[]> entry = ((List<Map.Entry<Operator, String[]>>) getFilterOperatorChildren()[i].getOperatorExpression()).get(sizeOfChildList-1);
            temporaryListsName[i+1] = entry.getValue()[0];
        }
        list.add(new AbstractMap.SimpleImmutableEntry<>(this, temporaryListsName));
        return list;
    }


}
