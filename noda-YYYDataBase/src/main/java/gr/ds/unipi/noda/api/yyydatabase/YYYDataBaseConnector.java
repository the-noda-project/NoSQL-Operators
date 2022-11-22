package gr.ds.unipi.noda.api.yyydatabase;

import gr.ds.unipi.noda.api.core.nosqldb.NoSqlDbConnector;

public final class YYYDataBaseConnector implements NoSqlDbConnector<Object> {

    private YYYDataBaseConnector(/*your arguments should be placed here*/){
        //the arguments should be assigned to private instance variables, and if possible, to final ones.
    }

    public static YYYDataBaseConnector newYYYDataBaseConnector(/*your arguments should be placed here*/){
        return new YYYDataBaseConnector(/*Pass the arguments here and modify the private constructor*/);
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
