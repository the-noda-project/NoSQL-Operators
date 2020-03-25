package gr.ds.unipi.noda.api.redisearch.sortOperators;

import gr.ds.unipi.noda.api.core.operators.sortOperators.BaseSortOperatorFactory;
import gr.ds.unipi.noda.api.core.operators.sortOperators.SortOperator;

/**
 * @author adimo on 10/10/2019
 */
public class RedisSortOperatorFactory extends BaseSortOperatorFactory {
    @Override
    public SortOperator newOperatorAsc(String fieldName) {
        return OperatorAsc.newOperatorAsc(fieldName);
    }

    @Override
    public SortOperator newOperatorDesc(String fieldName) {
        return OperatorDesc.newOperatorDesc(fieldName);
    }
}
