package gr.ds.unipi.noda.api.parquet.classes;

import com.google.common.collect.Maps;
import shaded.parquet.com.fasterxml.jackson.databind.node.BinaryNode;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;

public class MapRecord extends Record {
    public MapRecord() {
    }

    protected Object toJsonObject() {
        Map<String, Object> result = Maps.newLinkedHashMap();
        Iterator var2 = this.getValues().iterator();

        while(var2.hasNext()) {
            Record.NameValue value = (Record.NameValue)var2.next();
            String key = null;
            Object val = null;
            Iterator var6 = ((Record)value.getValue()).getValues().iterator();

            while(var6.hasNext()) {
                Record.NameValue kv = (Record.NameValue)var6.next();
                String kvName = kv.getName();
                Object kvValue = kv.getValue();
                if (kvName.equals("key")) {
                    key = this.keyToString(kvValue);
                } else if (kvName.equals("value")) {
                    val = toJsonValue(kvValue);
                }
            }

            result.put(key, val);
        }

        return result;
    }

    String keyToString(Object kvValue) {
        if (kvValue == null) {
            return "null";
        } else {
            Class<?> type = kvValue.getClass();
            if (type.isArray()) {
                if (type.getComponentType() == Boolean.TYPE) {
                    return Arrays.toString((boolean[])((boolean[])kvValue));
                } else if (type.getComponentType() == Byte.TYPE) {
                    return (new BinaryNode((byte[])((byte[])kvValue))).asText();
                } else if (type.getComponentType() == Character.TYPE) {
                    return Arrays.toString((char[])((char[])kvValue));
                } else if (type.getComponentType() == Double.TYPE) {
                    return Arrays.toString((double[])((double[])kvValue));
                } else if (type.getComponentType() == Float.TYPE) {
                    return Arrays.toString((float[])((float[])kvValue));
                } else if (type.getComponentType() == Integer.TYPE) {
                    return Arrays.toString((int[])((int[])kvValue));
                } else if (type.getComponentType() == Long.TYPE) {
                    return Arrays.toString((long[])((long[])kvValue));
                } else {
                    return type.getComponentType() == Short.TYPE ? Arrays.toString((short[])((short[])kvValue)) : Arrays.toString((Object[])((Object[])kvValue));
                }
            } else {
                return String.valueOf(kvValue);
            }
        }
    }
}
