package gr.ds.unipi.noda.api.cassandra.joinOperators;

import gr.ds.unipi.noda.api.core.operators.joinOperators.BaseJoinOperatorFactory;
import gr.ds.unipi.noda.api.core.operators.joinOperators.JoinOperator;

public class CassandraJoinOperatorFactory extends BaseJoinOperatorFactory {
    @Override
    public JoinOperator newOperatorGte(String columnA, String columnB) {
        throw new UnsupportedOperationException("This operation is not supported by Cassandra!");
    }

    @Override
    public JoinOperator newOperatorGt(String columnA, String columnB) {
        throw new UnsupportedOperationException("This operation is not supported by Cassandra!");
    }

    @Override
    public JoinOperator newOperatorLte(String columnA, String columnB) {
        throw new UnsupportedOperationException("This operation is not supported by Cassandra!");
    }

    @Override
    public JoinOperator newOperatorLt(String columnA, String columnB) {
        throw new UnsupportedOperationException("This operation is not supported by Cassandra!");
    }

    @Override
    public JoinOperator newOperatorEq(String columnA, String columnB) {
        throw new UnsupportedOperationException("This operation is not supported by Cassandra!");
    }

    @Override
    public JoinOperator newOperatorNe(String columnA, String columnB) {
        throw new UnsupportedOperationException("This operation is not supported by Cassandra!");
    }
}
