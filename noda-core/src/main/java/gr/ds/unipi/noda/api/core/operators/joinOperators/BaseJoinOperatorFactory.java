package gr.ds.unipi.noda.api.core.operators.joinOperators;

public abstract class BaseJoinOperatorFactory {

    public abstract JoinOperator newOperatorGte(String columnA, String columnB);

    public abstract JoinOperator newOperatorGt(String columnA, String columnB);

    public abstract JoinOperator newOperatorLte(String columnA, String columnB);

    public abstract JoinOperator newOperatorLt(String columnA, String columnB);

    public abstract JoinOperator newOperatorEq(String columnA, String columnB);

    public abstract JoinOperator newOperatorNe(String columnA, String columnB);
}
