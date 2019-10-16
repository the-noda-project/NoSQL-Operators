package gr.ds.unipi.noda.api.mongo.sortOperator;

import gr.ds.unipi.noda.api.core.operators.sortOperators.BaseSortOperatorFactory;
import gr.ds.unipi.noda.api.core.operators.sortOperators.SortOperator;

public class MongoDBSortOperatorFactory extends BaseSortOperatorFactory {

    @Override
    public SortOperator newOperatorAsc(String fieldName) {
        return OperatorAsc.newOperatorAsc(fieldName);
    }

    @Override
    public SortOperator newOperatorDesc(String fieldName) {
        return OperatorDesc.newOperatorDesc(fieldName);
    }
}
