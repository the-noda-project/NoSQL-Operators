package gr.ds.unipi.noda.api.parquet.joinOperators;

import gr.ds.unipi.noda.api.core.operators.joinOperators.BaseJoinOperatorFactory;
import gr.ds.unipi.noda.api.core.operators.joinOperators.JoinOperator;

public class ParquetJoinOperatorFactory extends BaseJoinOperatorFactory {
    @Override
    public JoinOperator newOperatorGte(String columnA, String columnB) {
        return null;
    }

    @Override
    public JoinOperator newOperatorGt(String columnA, String columnB) {
        return null;
    }

    @Override
    public JoinOperator newOperatorLte(String columnA, String columnB) {
        return null;
    }

    @Override
    public JoinOperator newOperatorLt(String columnA, String columnB) {
        return null;
    }

    @Override
    public JoinOperator newOperatorEq(String columnA, String columnB) {
        return null;
    }

    @Override
    public JoinOperator newOperatorNe(String columnA, String columnB) {
        return null;
    }
}
