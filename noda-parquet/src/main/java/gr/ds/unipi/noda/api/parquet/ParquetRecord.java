package gr.ds.unipi.noda.api.parquet;

import gr.ds.unipi.noda.api.core.nosqldb.NoSqlDbRecord;
import org.bson.Document;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class ParquetRecord extends NoSqlDbRecord<Document> {
    protected ParquetRecord(Document objectRecord) {
        super(objectRecord);
    }

    @Override
    public boolean containsField(String field) {
        return getObjectRecord().containsKey(field);
    }

    @Override
    public <U> boolean containsValue(U value) {
        return getObjectRecord().containsValue(value);
    }

    @Override
    public boolean getBoolean(String field) {
        return getObjectRecord().getBoolean(field);
    }

    @Override
    public String getString(String field) {
        return getObjectRecord().getString(field);
    }

    @Override
    public int getInt(String field) {
        return getObjectRecord().getInteger(field);
    }

    @Override
    public long getLong(String field) {
        return getObjectRecord().getLong(field);
    }

    @Override
    public float getFloat(String field) {
        throw new UnsupportedOperationException();
    }

    @Override
    public double getDouble(String field) {
        return getObjectRecord().getDouble(field);
    }

    @Override
    public Date getDate(String field) {
        return getObjectRecord().getDate(field);
    }

    @Override
    public short getShort(String field) {
        throw new UnsupportedOperationException();
    }

    @Override
    public BigDecimal getBigDecimal(String field) {
        return null;
    }

    @Override
    public byte getByte(String field) {
        return 0;
    }

    @Override
    public <U> List<U> getList(String field, Class<U> clazz) {
        return getObjectRecord().getList(field, clazz);
    }

    @Override
    public String toString() {
        return getObjectRecord().toString();
    }
}
