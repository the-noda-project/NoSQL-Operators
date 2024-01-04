package gr.ds.unipi.noda.api.parquet;

import com.google.common.base.Strings;
import com.google.common.collect.Maps;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import gr.ds.unipi.noda.api.core.nosqldb.NoSqlDbRecord;
import gr.ds.unipi.noda.api.core.nosqldb.NoSqlDbResults;
import org.apache.parquet.tools.read.SimpleRecord;
import org.bson.Document;
import org.json4s.jackson.Json;
import shaded.parquet.com.fasterxml.jackson.databind.ObjectMapper;
import shaded.parquet.com.fasterxml.jackson.databind.node.BinaryNode;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.*;

public class ParquetRecord extends NoSqlDbRecord<List<ParquetRecord.NameValue>> {

//    private Object[] objects;
//    private ParquetRecord(Object[] objects){
//        super(objects);
//    }

//    public static ParquetRecord newParquetRecord(Object[] objects){
//        return new ParquetRecord(objects);
//    }

//    protected ParquetRecord(Object objectRecord) {
//        super(objectRecord);
//    }

    private Document document;
    @Override
    public boolean containsField(String field) {
        return false;
    }

    @Override
    public <U> boolean containsValue(U value) {
        return false;
    }

    @Override
    public boolean getBoolean(String field) {
        return false;
    }

    @Override
    public String getString(String field) {
        System.out.println(toJsonObject());
        System.out.println(toJsonObject());
        document = Document.parse(toJsonObject().toString().replaceAll("=",":"));

        System.out.println(document);
        return document.getString(field);
    }

    @Override
    public int getInt(String field) {
        return 0;
    }

    @Override
    public long getLong(String field) {
        return 0;
    }

    @Override
    public float getFloat(String field) {
        return 0;
    }

    @Override
    public double getDouble(String field) {
        return 0;
    }

    @Override
    public Date getDate(String field) {
        return null;
    }

    @Override
    public short getShort(String field) {
        return 0;
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
        return null;
    }



//    protected final List<ParquetRecord.NameValue> values = new ArrayList();

    public ParquetRecord() {
        super(new ArrayList<>());
    }

    public void add(String name, Object value) {
        this.getObjectRecord().add(new ParquetRecord.NameValue(name, value));
    }

    public List<ParquetRecord.NameValue> getValues() {
        return Collections.unmodifiableList(this.getObjectRecord());

    }

    @Override
    public String toString() {
        return this.getObjectRecord().toString();
    }

    public void prettyPrint() {
        this.prettyPrint(new PrintWriter(System.out, true));
    }

    public void prettyPrint(PrintWriter out) {
        this.prettyPrint(out, 0);
    }

    public void prettyPrint(PrintWriter out, int depth) {
        Iterator var3 = this.getObjectRecord().iterator();

        while(true) {
            while(var3.hasNext()) {
                ParquetRecord.NameValue value = (ParquetRecord.NameValue)var3.next();
                out.print(Strings.repeat(".", depth));
                out.print(value.getName());
                Object val = value.getValue();
                if (val == null) {
                    out.print(" = ");
                    out.print("<null>");
                } else if (byte[].class == val.getClass()) {
                    out.print(" = ");
                    out.print((new BinaryNode((byte[])((byte[])val))).asText());
                } else if (short[].class == val.getClass()) {
                    out.print(" = ");
                    out.print(Arrays.toString((short[])((short[])val)));
                } else if (int[].class == val.getClass()) {
                    out.print(" = ");
                    out.print(Arrays.toString((int[])((int[])val)));
                } else if (long[].class == val.getClass()) {
                    out.print(" = ");
                    out.print(Arrays.toString((long[])((long[])val)));
                } else if (float[].class == val.getClass()) {
                    out.print(" = ");
                    out.print(Arrays.toString((float[])((float[])val)));
                } else if (double[].class == val.getClass()) {
                    out.print(" = ");
                    out.print(Arrays.toString((double[])((double[])val)));
                } else if (boolean[].class == val.getClass()) {
                    out.print(" = ");
                    out.print(Arrays.toString((boolean[])((boolean[])val)));
                } else if (val.getClass().isArray()) {
                    out.print(" = ");
                    out.print(Arrays.deepToString((Object[])((Object[])val)));
                } else {
                    if (ParquetRecord.class.isAssignableFrom(val.getClass())) {
                        out.println(":");
                        ((ParquetRecord)val).prettyPrint(out, depth + 1);
                        continue;
                    }

                    out.print(" = ");
                    out.print(String.valueOf(val));
                }

                out.println();
            }

            return;
        }
    }

    public void prettyPrintJson(PrintWriter out) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        out.write(mapper.writeValueAsString(this.toJsonObject()));
    }

    protected Object toJsonObject() {
        Map<String, Object> result = Maps.newLinkedHashMap();
        Iterator var2 = this.getObjectRecord().iterator();
        while(var2.hasNext()) {
            ParquetRecord.NameValue value = (ParquetRecord.NameValue)var2.next();
            result.put(value.getName(), toJsonValue(value.getValue()));
        }
        return result;
    }

    protected static Object toJsonValue(Object val) {
        if (ParquetRecord.class.isAssignableFrom(val.getClass())) {
            return ((ParquetRecord)val).toJsonObject();
        } else {
            return byte[].class == val.getClass() ? new BinaryNode((byte[])((byte[])val)) : val;
        }
    }

    public static final class NameValue {
        private final String name;
        private final Object value;

        public NameValue(String name, Object value) {
            this.name = name;
            this.value = value;
        }

        public String toString() {
            return this.name + ": " + this.value;
        }

        public String getName() {
            return this.name;
        }

        public Object getValue() {
            return this.value;
        }
    }
}
