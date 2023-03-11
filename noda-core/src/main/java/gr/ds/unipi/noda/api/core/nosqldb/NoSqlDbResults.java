package gr.ds.unipi.noda.api.core.nosqldb;

public abstract class NoSqlDbResults<T> {

    private final T batchRecords;

    protected NoSqlDbResults(T batchRecords) {
        this.batchRecords = batchRecords;
    }

    protected T getBatchRecords(){
        return batchRecords;
    }

    public abstract boolean hasNextRecord();

    public abstract NoSqlDbRecord getRecord();

    public abstract void close();

}
