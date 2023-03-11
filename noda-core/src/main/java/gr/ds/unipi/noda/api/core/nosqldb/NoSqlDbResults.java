package gr.ds.unipi.noda.api.core.nosqldb;

public abstract class NoSqlDbResults<T> {

    private final T noSqlDbResults;

    protected NoSqlDbResults(T noSqlDbResults) {
        this.noSqlDbResults = noSqlDbResults;
    }

    protected T getNoSqlDbResults(){
        return noSqlDbResults;
    }

    public abstract boolean hasNextRecord();

    public abstract NoSqlDbRecord getRecord();

    public abstract void close();

}
