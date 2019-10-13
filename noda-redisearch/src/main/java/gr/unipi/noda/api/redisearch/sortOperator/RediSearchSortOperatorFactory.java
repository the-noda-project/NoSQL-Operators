package gr.unipi.noda.api.redisearch.sortOperator;

import gr.unipi.noda.api.core.operators.sortOperators.BaseSortOperatorFactory;
import gr.unipi.noda.api.core.operators.sortOperators.SortOperator;

/**
 * @author adimo on 10/10/2019
 */
public class RediSearchSortOperatorFactory extends BaseSortOperatorFactory {
    @Override
    public SortOperator newOperatorAsc(String fieldName) {
        return OperatorAsc.newOperatorAsc(fieldName);
    }

    @Override
    public SortOperator newOperatorDesc(String fieldName) {
        return OperatorDesc.newOperatorDesc(fieldName);
    }
}
