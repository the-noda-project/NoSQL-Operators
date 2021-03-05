package gr.ds.unipi.noda.api.core.visualization;

public enum NoSQLExpression {
    INSTANCE;

    private String expression = "";

    public void setExpression(String expression){
        this.expression = expression;
    }

    public String getExpression(){
        return expression;
    }
}
