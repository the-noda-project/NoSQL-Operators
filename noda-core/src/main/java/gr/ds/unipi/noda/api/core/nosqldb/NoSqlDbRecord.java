package gr.ds.unipi.noda.api.core.nosqldb;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public abstract class NoSqlDbRecord<T> {

    private final T objectRecord;

    protected NoSqlDbRecord(T objectRecord) {
        this.objectRecord = objectRecord;
    }

    protected T getObjectRecord(){
        return objectRecord;
    }

    public abstract boolean containsField(String field);
    public abstract <U> boolean containsValue(U value);

    public abstract boolean getBoolean(String field);
    public abstract String getString(String field);
    public abstract int getInt(String field);
    public abstract long getLong(String field);
    public abstract float getFloat(String field);
    public abstract double getDouble(String field);
    public abstract Date getDate(String field);
    public abstract short getShort(String field);
    public abstract BigDecimal getBigDecimal(String field);
    public abstract byte getByte(String field);
    public abstract <U> List<U> getList(String field, Class<U> clazz);

    public abstract String toString();

}
