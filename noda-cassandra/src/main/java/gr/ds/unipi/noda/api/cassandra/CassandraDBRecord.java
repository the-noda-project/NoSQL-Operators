package gr.ds.unipi.noda.api.cassandra;

import com.datastax.oss.driver.api.core.cql.Row;
import gr.ds.unipi.noda.api.core.nosqldb.NoSqlDbRecord;

import java.math.BigDecimal;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class CassandraDBRecord extends NoSqlDbRecord<Row> {

    protected CassandraDBRecord(Row row) {
        super(row);
    }

    @Override
    public boolean containsField(String field) {
        return getObjectRecord().getColumnDefinitions().contains(field);
    }

    @Override
    public <U> boolean containsValue(U value) {
        for (int i = 0; i < getObjectRecord().size(); i++) {
            if (Objects.equals(getObjectRecord().getObject(i), value)) {
                return true;
            }
        }
        return false;
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
        return getObjectRecord().getInt(field);
    }

    @Override
    public long getLong(String field) {
        return getObjectRecord().getLong(field);
    }

    @Override
    public float getFloat(String field) {
        return getObjectRecord().getFloat(field);
    }

    @Override
    public double getDouble(String field) {
        return getObjectRecord().getDouble(field);
    }

    @Override
    public Date getDate(String field) {
        ZoneId defaultZoneId = ZoneId.systemDefault();
        return Date.from(Objects.requireNonNull(getObjectRecord().getLocalDate(field)).atStartOfDay(defaultZoneId).toInstant());
    }

    @Override
    public short getShort(String field) {
        return getObjectRecord().getShort(field);
    }

    @Override
    public BigDecimal getBigDecimal(String field) {
        return getObjectRecord().getBigDecimal(field);
    }

    @Override
    public byte getByte(String field) {
        return getObjectRecord().getByte(field);
    }

    @Override
    public <U> List<U> getList(String field, Class<U> clazz) {
        return getObjectRecord().getList(field, clazz);
    }

    @Override
    public String toString() {
        return getObjectRecord().getFormattedContents();
    }
}
