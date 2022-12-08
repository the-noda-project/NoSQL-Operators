package gr.ds.unipi.noda.api.cassandra;

import gr.ds.unipi.noda.api.core.nosqldb.NoSqlDbConnector;

public final class CassandraConnector implements NoSqlDbConnector<Object> {

    private CassandraConnector(/*your arguments should be placed here*/){
        //the arguments should be assigned to private instance variables, and if possible, to final ones.
    }

    public static CassandraConnector newCassandraConnector(/*your arguments should be placed here*/){
        return new CassandraConnector(/*Pass the arguments here and modify the private constructor*/);
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
