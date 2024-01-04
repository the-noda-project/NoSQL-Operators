package gr.ds.unipi.noda.api.parquet;

import gr.ds.unipi.noda.api.core.nosqldb.NoSqlDbConnector;

public final class ParquetConnector implements NoSqlDbConnector<Object> {

    private ParquetConnector(/*your arguments should be placed here*/){
        //the arguments should be assigned to private instance variables, and if possible, to final ones.
    }

    public static ParquetConnector newParquetConnector(/*your arguments should be placed here*/){
        return new ParquetConnector(/*Pass the arguments here and modify the private constructor*/);
    }

    @Override
    public Object createConnection() {
        return null;
    }

    @Override
    public int hashCode() {
        return 0;
    }

    @Override
    public boolean equals(Object o) {
        return false;
    }
}
