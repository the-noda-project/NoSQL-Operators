package gr.ds.unipi.noda.api.redis.filterOperators;

public class Triplet {

    private final String evalExpression;
    private final String[] keysArray;
    private final String[] argvArray;

    private Triplet(String evalExpression, String[] keysArray, String[] argvArray) {
        this.evalExpression = evalExpression;
        this.keysArray = keysArray;
        this.argvArray = argvArray;
    }

    public String getEvalExpression() {
        return evalExpression;
    }

    public String[] getKeysArray() {
        return keysArray;
    }

    public String[] getArgvArray() {
        return argvArray;
    }

    public static Triplet newTriplet(String evalExpression, String[] keysArray, String[] argvArray){
        return new Triplet(evalExpression, keysArray, argvArray);
    }
}
