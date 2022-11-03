package gr.ds.unipi.noda.api.core.operators.joinOperators;

import gr.ds.unipi.noda.api.core.operators.Operator;

public abstract class JoinOperator<T> implements Operator<T> {

    private final String columnA;
    private final String columnB;
    private JoinCondition condition;

    protected JoinOperator(String columnA, String columnB) {
        this.columnA = columnA;
        this.columnB = columnB;
        this.condition = JoinCondition.INNER;
    }

    public String getColumnAName() {
        return columnA;
    }

    public String getColumnBName() {
        return columnB;
    }

    public static BaseJoinOperatorFactory joinOperator;

    protected JoinCondition getJoinCondition(){
        return condition;
    }

    public JoinOperator inner(){
        this.condition = JoinCondition.INNER;
        return this;
    }

    public JoinOperator right(){
        this.condition = JoinCondition.RIGHT;
        return this;
    }

    public JoinOperator left(){
        this.condition = JoinCondition.LEFT;
        return this;
    }

    public JoinOperator full(){
        this.condition = JoinCondition.FULL;
        return this;
    }

}
