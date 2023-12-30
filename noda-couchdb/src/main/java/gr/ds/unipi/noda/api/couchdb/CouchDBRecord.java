package gr.ds.unipi.noda.api.couchdb;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import gr.ds.unipi.noda.api.core.nosqldb.NoSqlDbRecord;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.OffsetDateTime;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class CouchDBRecord extends NoSqlDbRecord<JsonObject> {
    protected CouchDBRecord(JsonObject objectRecord) {
        super(objectRecord);
    }

    @Override
    public boolean containsField(String field) {
        return getObjectRecord().has(field);
    }

    @Override
    public <U> boolean containsValue(U value) {
        JsonElement jsonValue = new Gson().toJsonTree(value);
        for (Map.Entry<String, JsonElement> element : getObjectRecord().entrySet()) {
            if (element.getValue().equals(jsonValue)) return true;
        }
        return false;
    }

    /**
     * Returns the boolean, or false if the field is null or not a boolean.
     */
    @Override
    public boolean getBoolean(String field) {
        JsonElement value = getObjectRecord().get(field);
        try {
            return value != null && value.getAsBoolean();
        } catch (IllegalStateException e) {
            throw new IllegalStateException("\"" + field + "\" is not a boolean.", e);
        }
    }

    /**
     * Returns the field if it is a string, or the first element if the field is a list and contains a single element.
     */
    @Override
    public String getString(String field) {
        JsonElement value = getObjectRecord().get(field);
        try {
            return value == null ? null : value.getAsJsonPrimitive().getAsString();
        } catch (IllegalStateException e) {
            throw new IllegalStateException("\"" + field + "\" is not a string.", e);
        }
    }

    /**
     * Returns the int value of the field, or 0 if the field is null.
     */
    @Override
    public int getInt(String field) {
        JsonElement value = getObjectRecord().get(field);
        try {
            return value == null ? 0 : value.getAsJsonPrimitive().getAsInt();
        } catch (IllegalStateException e) {
            throw new IllegalStateException("\"" + field + "\" is not an int.", e);
        }
    }

    /**
     * Returns the long value of the field, or 0 if the field is null.
     */
    @Override
    public long getLong(String field) {
        JsonElement value = getObjectRecord().get(field);
        try {
            return value == null ? 0 : value.getAsJsonPrimitive().getAsLong();
        } catch (IllegalStateException e) {
            throw new IllegalStateException("\"" + field + "\" is not a long.", e);
        }
    }

    /**
     * Returns the float value of the field, or 0 if the field is null.
     */
    @Override
    public float getFloat(String field) {
        JsonElement value = getObjectRecord().get(field);
        try {
            return value == null ? 0 : value.getAsJsonPrimitive().getAsFloat();
        } catch (IllegalStateException e) {
            throw new IllegalStateException("\"" + field + "\" is not a float.", e);
        }
    }

    /**
     * Returns the double value of the field, or 0 if the field is null.
     */
    @Override
    public double getDouble(String field) {
        JsonElement value = getObjectRecord().get(field);
        try {
            return value == null ? 0 : value.getAsJsonPrimitive().getAsDouble();
        } catch (IllegalStateException e) {
            throw new IllegalStateException("\"" + field + "\" is not a double.", e);
        }
    }

    /**
     * Parses the field as Date (ISO date-time format) and returns it, or null if the field is null.
     */
    @Override
    public Date getDate(String field) {
        JsonElement value = getObjectRecord().get(field);

        if (value == null) {
            return null;
        }

        try {
            return parseDate(value.getAsJsonPrimitive().getAsString());
        } catch (IllegalStateException | DateTimeParseException e) {
            throw new IllegalStateException("\"" + field + "\" is not a Date.", e);
        }
    }

    /**
     * Returns the short value of the field, or 0 if the field is null.
     */
    @Override
    public short getShort(String field) {
        JsonElement value = getObjectRecord().get(field);
        try {
            return value == null ? 0 : value.getAsJsonPrimitive().getAsShort();
        } catch (IllegalStateException e) {
            throw new IllegalStateException("\"" + field + "\" is not a short.", e);
        }
    }

    /**
     * Returns the BigDecimal value of the field, or null if the field is null.
     */
    @Override
    public BigDecimal getBigDecimal(String field) {
        JsonElement value = getObjectRecord().get(field);
        try {
            return value == null ? null : value.getAsJsonPrimitive().getAsBigDecimal();
        } catch (IllegalStateException e) {
            throw new IllegalStateException("\"" + field + "\" is not a BigDecimal.", e);
        }
    }

    /**
     * Returns the byte value of the field, or 0 if the field is null.
     */
    @Override
    public byte getByte(String field) {
        JsonElement value = getObjectRecord().get(field);
        try {
            return value == null ? 0 : value.getAsJsonPrimitive().getAsByte();
        } catch (IllegalStateException e) {
            throw new IllegalStateException("\"" + field + "\" is not a byte.", e);
        }
    }

    @Override
    public <U> List<U> getList(String field, Class<U> clazz) {
        JsonElement value = getObjectRecord().get(field);

        if (value == null) {
            return null;
        }

        JsonArray array;
        try {
            array = value.getAsJsonArray();
        } catch (IllegalStateException e) {
            throw new IllegalStateException("\"" + field + "\" is not a List.", e);
        }

        try {
            List<U> result = new ArrayList<>();

            for (JsonElement element : array) {
                if (element.isJsonPrimitive()) {
                    if (Integer.class.isAssignableFrom(clazz)) {
                        result.add(clazz.cast(element.getAsJsonPrimitive().getAsInt()));
                    } else if (Long.class.isAssignableFrom(clazz)) {
                        result.add(clazz.cast(element.getAsJsonPrimitive().getAsLong()));
                    } else if (Short.class.isAssignableFrom(clazz)) {
                        result.add(clazz.cast(element.getAsJsonPrimitive().getAsShort()));
                    } else if (Float.class.isAssignableFrom(clazz)) {
                        result.add(clazz.cast(element.getAsJsonPrimitive().getAsFloat()));
                    } else if (Double.class.isAssignableFrom(clazz)) {
                        result.add(clazz.cast(element.getAsJsonPrimitive().getAsDouble()));
                    } else if (Byte.class.isAssignableFrom(clazz)) {
                        result.add(clazz.cast(element.getAsJsonPrimitive().getAsByte()));
                    } else if (BigDecimal.class.isAssignableFrom(clazz)) {
                        result.add(clazz.cast(element.getAsJsonPrimitive().getAsBigDecimal()));
                    } else if (BigInteger.class.isAssignableFrom(clazz)) {
                        result.add(clazz.cast(element.getAsJsonPrimitive().getAsBigInteger()));
                    } else if (CharSequence.class.isAssignableFrom(clazz)) {
                        result.add(clazz.cast(element.getAsJsonPrimitive().getAsString()));
                    } else if (Date.class.isAssignableFrom(clazz)) {
                        result.add(clazz.cast(parseDate(element.getAsJsonPrimitive().getAsString())));
                    } else if (Boolean.class.isAssignableFrom(clazz)) {
                        result.add(clazz.cast(element.getAsJsonPrimitive().getAsBoolean()));
                    } else {
                        throw new UnsupportedOperationException("For: " + clazz);
                    }
                } else if (element.isJsonArray()) {
                    if (List.class.isAssignableFrom(clazz)) {
                        result.add(clazz.cast(element.getAsJsonArray().asList()));
                    } else {
                        throw new UnsupportedOperationException("For: " + clazz);
                    }
                } else if (element.isJsonObject()) {
                    if (Map.class.isAssignableFrom(clazz)) {
                        result.add(clazz.cast(element.getAsJsonObject().asMap()));
                    } else {
                        throw new UnsupportedOperationException("For: " + clazz);
                    }
                } else if (element.isJsonNull()) {
                    result.add(null);
                }
            }

            return result;
        } catch (IllegalStateException | NumberFormatException e) {
            throw new IllegalStateException("\"" + field + "\" is not a List of " + clazz, e);
        }
    }

    @Override
    public String toString() {
        return getObjectRecord().toString();
    }

    private Date parseDate(String dateString) {
        return Date.from(OffsetDateTime.parse(dateString).toInstant());
    }
}
